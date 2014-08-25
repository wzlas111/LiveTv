package com.eastelsoft.livetv.ui.main;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.base.BaseActivity;
import com.eastelsoft.livetv.ui.fragment.ColumnFragment;
import com.eastelsoft.livetv.ui.fragment.HomeFragment;
import com.eastelsoft.livetv.ui.fragment.LiveFragment;

public class MainActivity extends BaseActivity {
	
	private RadioGroup radioGroup;
	private RadioButton btn_home;
	private RadioButton btn_live;
	private RadioButton btn_column;
	private RadioButton btn_topic;
	private RadioButton btn_interact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		initViews();
		initFragment();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		initActionBar();
		btn_home.setChecked(true);
		setTextColor(0);
		setFragment(0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actionbar_home, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.account:
				Toast.makeText(MainActivity.this, "ÕËºÅµÇÂ½", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
		return true;
	}
	
	private void initActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setTitle(getString(R.string.home_title));
		actionBar.setDisplayShowHomeEnabled(false);
	}
	
	private void initFragment() {
		HomeFragment homeFragment = getHomeFragment();
		LiveFragment liveFragment = getLiveFragment();
		ColumnFragment columnFragment = getColumnFragment();
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		if (!homeFragment.isAdded()) {
			transaction.add(R.id.content, homeFragment, HomeFragment.class.getName());
		}
		if (!liveFragment.isAdded()) {
			transaction.add(R.id.content, liveFragment, LiveFragment.class.getName());
		}
		if (!columnFragment.isAdded()) {
			transaction.add(R.id.content, columnFragment, ColumnFragment.class.getName());
		}
		
		if (!transaction.isEmpty()) {
			transaction.commit();
			getSupportFragmentManager().executePendingTransactions();
		}
	}
	
	private void initViews() {
		radioGroup = (RadioGroup)this.findViewById(R.id.radio_group);
		btn_home = (RadioButton)this.findViewById(R.id.bar_home);
		btn_live = (RadioButton)this.findViewById(R.id.bar_live);
		btn_column = (RadioButton)this.findViewById(R.id.bar_column);
		btn_topic = (RadioButton)this.findViewById(R.id.bar_topic);
		btn_interact = (RadioButton)this.findViewById(R.id.bar_interact);
		
		btn_home.setOnClickListener(onClickListener);
		btn_live.setOnClickListener(onClickListener);
		btn_column.setOnClickListener(onClickListener);
		btn_topic.setOnClickListener(onClickListener);
		btn_interact.setOnClickListener(onClickListener);
	}
	private void setTextColor(int postion) {
		for (int i = 0; i < 5; i++) {
			((RadioButton)radioGroup.getChildAt(i)).setTextColor(getResources().getColor(R.color.black));
		}
		((RadioButton)radioGroup.getChildAt(postion)).setTextColor(getResources().getColor(R.color.blueviolet));
	}
	private OnClickListener onClickListener = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.bar_home:
					btn_home.setChecked(true);
					setTextColor(0);
					setFragment(0);
					break;
				case R.id.bar_live:
					btn_live.setChecked(true);
					setTextColor(1);
					setFragment(1);
					break;
				case R.id.bar_column:
					btn_column.setChecked(true);
					setTextColor(2);
					setFragment(2);
					break;
				case R.id.bar_topic:
					btn_topic.setChecked(true);
					setTextColor(3);			
					break;
				case R.id.bar_interact:
					btn_interact.setChecked(true);
					setTextColor(4);
					break;
			}
		}
	};
	
	private void setFragment(int position) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.hide(getHomeFragment());
		transaction.hide(getLiveFragment());
		transaction.hide(getColumnFragment());
		switch (position) {
		case 0:
			transaction.show(getHomeFragment());
			break;
		case 1:
			transaction.show(getLiveFragment());
			break;
		case 2:
			transaction.show(getColumnFragment());
			break;
		default:
			break;
		}
		transaction.commit();
	}
	
	public HomeFragment getHomeFragment() {
		HomeFragment fragment = (HomeFragment)getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getName());
		if (fragment == null) {
			fragment = new HomeFragment();
		}
		return fragment;
	}
	
	public LiveFragment getLiveFragment() {
		LiveFragment fragment = (LiveFragment)getSupportFragmentManager().findFragmentByTag(LiveFragment.class.getName());
		if (fragment == null) {
			fragment = new LiveFragment();
		}
		return fragment;
	}
	
	public ColumnFragment getColumnFragment() {
		ColumnFragment fragment = (ColumnFragment)getSupportFragmentManager().findFragmentByTag(ColumnFragment.class.getName());
		if (fragment == null) {
			fragment = new ColumnFragment();
		}
		return fragment;
	}
}
