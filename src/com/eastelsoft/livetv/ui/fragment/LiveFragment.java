package com.eastelsoft.livetv.ui.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.base.BaseFragment;

public class LiveFragment extends BaseFragment{
	
	private ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.live_fragment, container, false);
		buildView(view);
		buildActionBar();
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	private void buildView(View view) {
		viewPager = (ViewPager)view.findViewById(R.id.viewpager);
	}

	private void buildActionBar() {
		ActionBar actionBar = getActivity().getActionBar();
		actionBar.setTitle(getString(R.string.bar_live_tile));
	}
}
