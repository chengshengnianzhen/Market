package com.example.market;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.utils.Company;
import com.example.market.utils.Questionnaire;
import com.example.market.web.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Main_activity_centerright extends BaseActivity
{
	private List<String> items = null;  
	ActionBar actionBar;
	private String company;
	private ProgressDialog pDialog;
	private ArrayList<Questionnaire> askList = new ArrayList<Questionnaire>();
	private int number;
	private ListView listView;
	private ArrayList<Questionnaire> questionnaires;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_aboveleft_list);
		setTitle("Ñ²²é¼ÇÂ¼");
		items = new ArrayList<String>(); 
		Log.d("actionBar", "actionBar");
		listView=(ListView)findViewById(R.id.main_activtiy_aboveleft_listview);
		Log.d("listView", "listView");
		GetFromservive();
	}
	private void GetFromservive(){			
 
		 MyApplication application = (MyApplication)getApplication();
		 int userId= application.getCurIndex();
		 String urlString=application.getUrl()+"android/getRecord.jsp";
		 RequestParams qParams=new RequestParams();
		 qParams.put("userId", String.valueOf(userId));
		 Log.d("userId", String.valueOf(userId)+urlString);
		 HttpUtil.get(urlString,qParams, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONObject response)  {
				// TODO Auto-generated method stub
				 int resCode=-1;
				  try
				  {
				  	String resMsg=response.getString("resMsg");
				  	Log.d("resMsg", resMsg);
				  	resCode=response.getInt("resCode");
				  	Log.d("resCode", String.valueOf(resCode));
				  	number=response.getInt("count");
				  	Log.d("number", String.valueOf(number));
				  	Log.d("response", response.toString());			  	
				  	if(resCode==0)
				  	{
	                create(response.getJSONArray("questionnaires"));
				  	}
				  	else {
				  		Toast.makeText(Main_activity_centerright.this, "²éÑ¯Ê§°Ü:"+resMsg,
								Toast.LENGTH_LONG).show();
					}
	                Log.d("items", response.toString());
				  }catch(Exception e){
					  Toast.makeText(Main_activity_centerright.this, "²éÑ¯Ê§°Ü"+e,
								Toast.LENGTH_LONG).show();
					  Log.d("e", e.toString());
				  }
			}
	        });
	}
	protected void create(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		Type type = new TypeToken<ArrayList<Questionnaire>>() {
		}.getType();
		ArrayList<Questionnaire> list = gson.fromJson(jsonArray.toString(), type);
		askList.addAll(list);
		Log.d("Company", "create(JSONArray jsonArray)");
		Log.d("askList.size()", String.valueOf(askList.size()));
		for(int i=0;i<askList.size();i++)
		{
			items.add(askList.get(i).getCompanyName());
		}
	    listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
	    Log.d("listView", "listView1");
	    listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Gson gson=new Gson();
					Intent intent= new Intent(Main_activity_centerright.this,Main_activity_centerright_questionnaire.class);
					String message=gson.toJson(askList.get(position));
					intent.putExtra("message", message);
					startActivity(intent);
				}
			});
		Log.d("listView", "listView2");
	}
}