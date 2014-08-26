package com.eastelsoft.livetv.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.bean.ChannelListBean;
import com.eastelsoft.livetv.dao.ChannelListDao;
import com.eastelsoft.livetv.ui.adapter.LiveAdapter;
import com.eastelsoft.livetv.ui.base.BaseFragment;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public class LiveTvFragment extends BaseFragment implements LoaderCallbacks<List<ChannelListBean>>{
	
	protected PullToRefreshListView pullToRefreshListView;
	
	private LiveAdapter mAdapter;
	private List<ChannelListBean> mData = new ArrayList<ChannelListBean>();
	
	private static final int NEW_LOADER_ID = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.live_tv_fragment_layout, container, false);
		buildListView(inflater,view);
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		mAdapter = new LiveAdapter(this, mData);
		getListView().setAdapter(mAdapter);
		getLoaderManager().initLoader(NEW_LOADER_ID, null, this);
		pullToRefreshListView.setOnRefreshListener(refreshListener);
	}
	
	private void buildListView(LayoutInflater inflater, View view) {
		pullToRefreshListView = (PullToRefreshListView)view.findViewById(R.id.pull_refresh_list);
	}
	
	public ListView getListView() {
		return pullToRefreshListView.getRefreshableView();
	}

	@Override
	public Loader<List<ChannelListBean>> onCreateLoader(int arg0, Bundle arg1) {
		return new ChannelListLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<List<ChannelListBean>> loader,
			List<ChannelListBean> data) {
		if (data != null && data.size() > 0) {
			this.mData.clear();
			this.mData.addAll(data);
		} else {
			Toast.makeText(getActivity(), "网络有问题，数据加载失败!", Toast.LENGTH_SHORT).show();
		}
		mAdapter.notifyDataSetChanged();
		pullToRefreshListView.onRefreshComplete();
	}

	@Override
	public void onLoaderReset(Loader<List<ChannelListBean>> arg0) {
		this.mData = new ArrayList<ChannelListBean>();
		mAdapter.notifyDataSetChanged();
	}
	
	private OnRefreshListener<ListView> refreshListener = new OnRefreshListener<ListView>() {
		public void onRefresh(PullToRefreshBase<ListView> refreshView) {
			getLoaderManager().restartLoader(NEW_LOADER_ID, null, LiveTvFragment.this);
		}
	};
	
	public static class ChannelListLoader extends AsyncTaskLoader<List<ChannelListBean>> {

		public ChannelListLoader(Context context) {
			super(context);
		}

		@Override
		protected void onStartLoading() {
			super.onStartLoading();
			forceLoad();
		}
		
		@Override
		public List<ChannelListBean> loadInBackground() {
			try {
				return new ChannelListDao().getBean();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	}
}
