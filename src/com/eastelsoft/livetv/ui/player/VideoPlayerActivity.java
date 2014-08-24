package com.eastelsoft.livetv.ui.player;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.eastelsoft.livetv.R;
import com.eastelsoft.livetv.ui.base.BaseActivity;

public class VideoPlayerActivity extends BaseActivity {
	
	private String data_id;
	private String video_url;
	private String title;
	private String brief;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_player_layout);
		buildActionBar();
		
		Intent intent = getIntent();
		data_id = intent.getStringExtra("id");
		video_url = intent.getStringExtra("url");
		title = intent.getStringExtra("title");
		brief = intent.getStringExtra("brief");
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return true;
	}
	
	private void buildActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
}
