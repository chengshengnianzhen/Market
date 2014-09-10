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

public class Main_activity_bottomright extends BaseActivity
{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_bottomright);
		setTitle("市场巡查原则");
		}
}
