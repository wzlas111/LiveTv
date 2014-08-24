package com.eastelsoft.livetv.ui.welcome;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.main.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_layout);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		getActionBar().hide();
		handler.postDelayed(new Runnable() {
			public void run() {
				finish();
				Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(intent);
			}
		}, 2000L);
	}
	
	private Handler handler = new Handler();
}
