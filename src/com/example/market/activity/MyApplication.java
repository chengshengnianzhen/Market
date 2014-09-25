package com.example.market.activity;

import android.app.Application;

public class MyApplication extends Application {
	private int userId;
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCurIndex() {

	return userId;

	}

	public void setCurIndex(int curIndex) {

	this.userId= curIndex;

	}

	@Override

	public void onCreate() {

	super.onCreate();

	}

	@Override

	public void onTerminate() {

	super.onTerminate();

	}
	
}

