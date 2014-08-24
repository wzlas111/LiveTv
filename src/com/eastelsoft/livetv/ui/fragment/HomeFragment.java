package com.eastelsoft.livetv.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.bean.IndexListBean;
import com.eastelsoft.livetv.dao.IndexListDao;
import com.eastelsoft.livetv.ui.adapter.HomeAdapter;
import com.eastelsoft.livetv.ui.base.BaseFragment;
import com.eastelsoft.livetv.ui.player.VideoPlayerActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public class HomeFragment extends BaseFragment implements LoaderCallbacks<List<IndexListBean>>{

	protected PullToRefreshListView pullToRefreshListView;
	protected View footerView;
	
	private HomeAdapter mAdapter;
	private List<IndexListBean> mData = new ArrayList<IndexListBean>();
	
	private static final int LOADER_ID = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_fragment, container, false);
		buildListView(inflater, view);
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mAdapter = new HomeAdapter(this, mData);
		getListView().setAdapter(mAdapter);
		getLoaderManager().initLoader(LOADER_ID, null, this);
		pullToRefreshListView.setOnRefreshListener(refreshListener);
		pullToRefreshListView.setOnItemClickListener(listitemClickListener);
	}
	
	private void buildListView(LayoutInflater inflater, View view) {
		pullToRefreshListView = (PullToRefreshListView)view.findViewById(R.id.pull_refresh_list);
		footerView = inflater.inflate(R.layout.listview_footer_layout, null);
		getListView().addFooterView(footerView);
	}
	
	public ListView getListView() {
		return pullToRefreshListView.getRefreshableView();
	}

	@Override
	public Loader<List<IndexListBean>> onCreateLoader(int id, Bundle args) {
		return new IndexListDataLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<List<IndexListBean>> loader,
			List<IndexListBean> data) {
		System.out.println("data : " + data.size());
		if (data != null && data.size() > 0) {
			this.mData.clear();
			this.mData.addAll(data);
		}else {
			Toast.makeText(getActivity(), "网络有问题，数据加载失败!", Toast.LENGTH_SHORT).show();
		}
		mAdapter.notifyDataSetChanged();
		pullToRefreshListView.onRefreshComplete();
	}

	@Override
	public void onLoaderReset(Loader<List<IndexListBean>> loader) {
		this.mData = new ArrayList<>();
		mAdapter.notifyDataSetChanged();
	}
	
	public static class IndexListDataLoader extends AsyncTaskLoader<List<IndexListBean>> {
		
		public IndexListDataLoader(Context context) {
			super(context);
		}

		@Override
		protected void onStartLoading() {
			super.onStartLoading();
			forceLoad();
		}
		
		@Override
		public List<IndexListBean> loadInBackground() {
			try {
				return new IndexListDao().getBean();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ArrayList<IndexListBean>();
		}
	}
	
	private OnRefreshListener<ListView> refreshListener = new OnRefreshListener<ListView>() {
		public void onRefresh(PullToRefreshBase<ListView> refreshView) {
			getLoaderManager().restartLoader(LOADER_ID, null, HomeFragment.this);
		}
	};
	
	private OnItemClickListener listitemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			IndexListBean bean = mData.get(position);
			Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
			intent.putExtra("id", bean.getId());
			intent.putExtra("title", bean.getTitle());
			intent.putExtra("brief", bean.getBrief());
			intent.putExtra("url", bean.getVideo().getUrl());
			startActivity(intent);
		}
	};
}
