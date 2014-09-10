package com.example.market;


import com.example.market.R.id;
import com.example.market.activity.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore.RightsStatus;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main_activity_bottom extends BaseActivity
{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity_bottom);
		setTitle("商品追踪信息");
		}
}
