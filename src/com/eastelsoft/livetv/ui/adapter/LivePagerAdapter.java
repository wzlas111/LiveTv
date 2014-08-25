package com.eastelsoft.livetv.ui.adapter;

import com.eastelsoft.livetv.ui.fragment.LiveFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public class LivePagerAdapter extends PagerAdapter {

	private SparseArray<Fragment> fragmentList;
	private FragmentTransaction ft;
	
	public LivePagerAdapter(LiveFragment fragment, SparseArray<Fragment> mList) {
		this.fragmentList = mList;
		ft = fragment.getChildFragmentManager().beginTransaction();
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}
	
	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return ((Fragment)object).getView() == view;
	}
	
	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}
	
}
