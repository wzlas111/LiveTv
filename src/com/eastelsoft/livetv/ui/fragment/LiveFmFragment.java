package com.eastelsoft.livetv.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.base.BaseFragment;

public class LiveFmFragment extends BaseFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.live_fm_fragment_layout, container, false);
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
}
