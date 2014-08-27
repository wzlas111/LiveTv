package com.eastelsoft.livetv.ui.fragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.adapter.LivePagerAdapter;
import com.eastelsoft.livetv.ui.base.BaseFragment;

public class LiveFragment extends BaseFragment{
	
	private ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.live_fragment, container, false);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		buildView(view);
		
		viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(2);
        LivePagerAdapter liveAdapter = new LivePagerAdapter(this);
        viewPager.setAdapter(liveAdapter);
        viewPager.setOnPageChangeListener(onPageChangeListener);
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	private void buildView(View view) {
		viewPager = (ViewPager)view.findViewById(R.id.viewpager);
	}

	public void buildActionBar() {
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(getString(R.string.bar_live_tile));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.removeAllTabs();
		SimpleTabListener tabListener = new SimpleTabListener(viewPager);
		actionBar.addTab(buildTvTab(tabListener));
		actionBar.addTab(buildFmTab(tabListener));
		viewPager.setCurrentItem(0, false);
	}
	
	private ActionBar.Tab buildTvTab(SimpleTabListener tabListener) {
		View customView = getActivity().getLayoutInflater().inflate(R.layout.tab_tv_fm_layout, null);
		((TextView) customView.findViewById(R.id.title)).setText(getString(R.string.tv_title));
		ActionBar.Tab tvTab = getActivity().getActionBar().newTab()
				.setCustomView(customView)
				.setTag(LiveTvFragment.class.getName())
				.setTabListener(tabListener);
		
		return tvTab;
	}
	
	private ActionBar.Tab buildFmTab(SimpleTabListener tabListener) {
		View customView = getActivity().getLayoutInflater().inflate(R.layout.tab_tv_fm_layout, null);
		((TextView) customView.findViewById(R.id.title)).setText(getString(R.string.fm_title));
		ActionBar.Tab fmTab = getActivity().getActionBar().newTab()
				.setCustomView(customView)
				.setTag(LiveFmFragment.class.getName())
				.setTabListener(tabListener);
		
		return fmTab;
	}
	
	public LiveTvFragment getTvFragment() {
		LiveTvFragment fragment = (LiveTvFragment)getChildFragmentManager().findFragmentByTag(LiveTvFragment.class.getName());
		if (fragment == null) {
			fragment = new LiveTvFragment();
		}
		return fragment;
	}
	
	public LiveFmFragment getFmFragment() {
		LiveFmFragment fragment = (LiveFmFragment)getChildFragmentManager().findFragmentByTag(LiveFmFragment.class.getName());
		if (fragment == null) {
			fragment = new LiveFmFragment();
		}
		return fragment;
	}
	
	private SimpleOnPageChangeListener onPageChangeListener = new SimpleOnPageChangeListener(){
		public void onPageSelected(int position) {
			ActionBar actionBar = getActivity().getActionBar();
			actionBar.setSelectedNavigationItem(position);
		}
	};
	
	private class SimpleTabListener implements TabListener {
		
		private ViewPager mViewPager;
		
		public SimpleTabListener(ViewPager viewPager) {
			this.mViewPager = viewPager;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if (mViewPager != null && mViewPager.getCurrentItem() != tab.getPosition()) {
				mViewPager.setCurrentItem(tab.getPosition());
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
		}
		
	}
}
