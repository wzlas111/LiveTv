package com.eastelsoft.livetv;

import android.app.Application;

public class GlobalContext extends Application {

	private static GlobalContext globalContext = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		globalContext = this;
	}
	
	public static GlobalContext getInstance() {
		return globalContext;
	}
}
