package com.eastelsoft.livetv.ui.adapter;

import java.util.List;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.bean.IndexListBean;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends BaseAdapter {

	protected Fragment mFragment;
	protected LayoutInflater mLayoutInflater;
	protected List<IndexListBean> mList;
	
	public HomeAdapter(Fragment fragment, List<IndexListBean> pList) {
		mFragment = fragment;
		mLayoutInflater = fragment.getActivity().getLayoutInflater();
		mList = pList;
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null || convertView.getTag() == null) {
			convertView = mLayoutInflater.inflate(R.layout.listview_item_layout, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.tv_title = (TextView)convertView.findViewById(R.id.title);
			viewHolder.tv_date = (TextView)convertView.findViewById(R.id.date);
		} else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		IndexListBean bean = mList.get(position);
		viewHolder.tv_title.setText(bean.getTitle());
		viewHolder.tv_date.setText(bean.getPublish_time());
		
		convertView.setTag(viewHolder);
		return convertView;
	}
	
	private class ViewHolder {
		ImageView iv_avtar;
		TextView tv_title;
		TextView tv_date;
	}
}
