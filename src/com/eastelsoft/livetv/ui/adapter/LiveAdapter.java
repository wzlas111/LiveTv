package com.eastelsoft.livetv.ui.adapter;

import java.util.List;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.bean.ChannelListBean;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LiveAdapter extends BaseAdapter {

	protected Fragment mFragment;
	protected LayoutInflater mLayoutInflater;
	protected List<ChannelListBean> mList;
	
	public LiveAdapter(Fragment fragment, List<ChannelListBean> pList) {
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
			convertView = mLayoutInflater.inflate(R.layout.live_item_layout, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.iv_avtar = (ImageView)convertView.findViewById(R.id.avatar);
			viewHolder.tv_title = (TextView)convertView.findViewById(R.id.title);
			viewHolder.tv_live_title = (TextView)convertView.findViewById(R.id.live_title);
		} else {
			viewHolder = (ViewHolder)convertView.getTag();
		}
		ChannelListBean bean = mList.get(position);
		String audio_only = bean.getAudio_only();
		if ("0".equals(audio_only)) {
			viewHolder.iv_avtar.setImageDrawable(mFragment.getResources().getDrawable(R.drawable.tv_logo));
		}else{
			viewHolder.iv_avtar.setImageDrawable(mFragment.getResources().getDrawable(R.drawable.fm_logo));
		}
		
		viewHolder.tv_title.setText(bean.getName());
		viewHolder.tv_live_title.setText("ÕýÔÚ²¥³ö : "+bean.getCur_program().getProgram());
		
		convertView.setTag(viewHolder);
		return convertView;
	}
	
	private class ViewHolder {
		ImageView iv_avtar;
		TextView tv_title;
		TextView tv_live_title;
	}
}
