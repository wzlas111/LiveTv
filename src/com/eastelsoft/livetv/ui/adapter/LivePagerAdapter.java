package com.eastelsoft.livetv.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.fragment.LiveFmFragment;
import com.eastelsoft.livetv.ui.fragment.LiveFragment;
import com.eastelsoft.livetv.ui.fragment.LiveTvFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class LivePagerAdapter extends PagerAdapter {

	private List<String> fragmentList = new ArrayList<String>();
	private FragmentManager fm;
	
	public LivePagerAdapter(LiveFragment fragment) {
		fm = fragment.getChildFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		LiveTvFragment tvFragment = fragment.getTvFragment();
		LiveFmFragment fmFragment = fragment.getFmFragment();
		if (!tvFragment.isAdded()) {
			ft.add(R.id.viewpager, tvFragment, LiveTvFragment.class.getName());
			fragmentList.add(LiveTvFragment.class.getName());
		}
		if (!fmFragment.isAdded()) {
			ft.add(R.id.viewpager, fmFragment, LiveFmFragment.class.getName());
			fragmentList.add(LiveFmFragment.class.getName());
		}
		if (!ft.isEmpty()) {
			ft.commit();
			fm.executePendingTransactions();
		}
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		System.out.println("position : "+position);
		FragmentTransaction ft = fm.beginTransaction();
		
		String tag = fragmentList.get(position);
		Fragment fragment = fm.findFragmentByTag(tag);
		ft.show(fragment);
		ft.commit();
		return fragment;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}
	
	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return ((Fragment)object).getView() == view;
	}
	
}
