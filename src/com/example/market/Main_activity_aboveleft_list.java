package com.example.market;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.market.Main_activity_center.item;
import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.utils.Company;
import com.example.market.web.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.integer;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View; 
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Main_activity_aboveleft_list extends BaseActivity
{
	private List<String> items = null;  
	ActionBar actionBar;
	private String company;
	private ProgressDialog pDialog;
	private ArrayList<Company> askList = new ArrayList<Company>();
	private int number;
	private ListView listView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.main_activity_aboveleft_list);		
		actionBar =getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.show();	
		setTitle("��ѯ���");
		items = new ArrayList<String>(); 
		Log.d("actionBar", "actionBar");
		Bundle extras = getIntent().getExtras();
		company=extras.getString("company");//�õ�Ҫ��ѯ������
		listView=(ListView)findViewById(R.id.main_activtiy_aboveleft_listview);
		Log.d("listView", "listView");
		GetFromservive();
		
	}
		private void GetFromservive(){			
	    	pDialog = ProgressDialog.show(this, "���Ե�", "����������");
	    	pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// ����ˮƽ������  
	    	pDialog.setCanceledOnTouchOutside(true);// �����ڵ��Dialog���Ƿ�ȡ��Dialog������
			 
			 MyApplication application = (MyApplication)getApplication();
			 int userId= application.getCurIndex();
			 String urlString=application.getUrl()+"android/getCompany.jsp";
			 RequestParams qParams=new RequestParams();
			 qParams.put("userId", String.valueOf(userId));
			 qParams.put("Company ",company);
			 Log.d("userId+Company", String.valueOf(userId)+company);
			 HttpUtil.get(urlString,qParams, new JsonHttpResponseHandler() {
			 int resCode=-1;
				@Override
				public void onSuccess(JSONObject response)  {
					// TODO Auto-generated method stub
					  pDialog.dismiss();
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
		                create(response.getJSONArray("items"));
					  	}
					  	else {
					  		Toast.makeText(Main_activity_aboveleft_list.this, "��ѯʧ��:"+resMsg,
									Toast.LENGTH_LONG).show();
						}
		                Log.d("items", response.toString());
					  }catch(Exception e){
						  Toast.makeText(Main_activity_aboveleft_list.this, "��ѯʧ��"+e,
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
			Type type = new TypeToken<ArrayList<Company>>() {
			}.getType();
			ArrayList<Company> list = gson.fromJson(jsonArray.toString(), type);
			askList.addAll(list);
			Log.d("Company", "create(JSONArray jsonArray)");
			Log.d("askList.size()", String.valueOf(askList.size()));
//			for(int i=0;i<askList.size();i++)
//			{
//				items.add(askList.get(i).getName());
//			}
//		    listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
//		    Log.d("listView", "listView1");
			mAdapter mAdapter1=new mAdapter(this);
			listView.setAdapter(mAdapter1);
		    listView.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						//�����������
						Gson gson=new Gson();
						Intent intent= new Intent(Main_activity_aboveleft_list.this,Main_activity_aboveleft_result.class);
						String message=gson.toJson(askList.get(position));
						intent.putExtra("message", message);
						startActivity(intent);
					}
				});
			Log.d("listView", "listView2");
		}
		public class mAdapter extends BaseAdapter {  
        	
            private LayoutInflater layoutInflater;  
            private Context context;   
            
            public mAdapter(Context context) {  
                  
                this.context = context;    
                this.layoutInflater = LayoutInflater.from(context);  
            }  
          
            /** 
             *��ȡ����  
             */  
            public int getCount() {  
                return askList.size();  
            }  
            /** 
             *��ȡĳһλ�õ�����  
             */  
            public Object getItem(int position) {  
                return position;  
            }  
            /** 
             *��ȡΨһ��ʶ 
             */  
            public long getItemId(int position) {  
                return position;  
            }  
          
            /** 
             * android����ÿһ�е�ʱ�򣬶������������� 
             */  
            public View getView(int position, View convertView, ViewGroup parent) {  
            	item witem=new item();   
                if(convertView==null){  
                    // ��ȡ�������  
                    convertView = layoutInflater.inflate(R.layout.listitem, null);    
                    witem.titleView = (TextView) convertView.findViewById(R.id.listviewitem1);  
                    witem.infoView = (TextView) convertView.findViewById(R.id.listviewitem2);  
                    witem.thirdView = (TextView) convertView.findViewById(R.id.listviewitem3);
                    witem.thirdView.setVisibility(View.GONE);
                    // ����Ҫע�⣬��ʹ�õ�tag���洢���ݵġ�  
                    convertView.setTag(witem);  
                }  
                else {  
                    witem = (item) convertView.getTag();  
                }  
                // �����ݡ��Լ��¼�����    
                witem.titleView.setText(askList.get(position).getName());
                witem.infoView.setText(askList.get(position).getNumber());
                //witem.thirdView.setText(askList.get(position).getTime());
                return convertView;  
            }   
          
    } 
    public final class item {  
            
            public TextView titleView;  
            public TextView infoView;  
            public TextView thirdView;  
              
              
    }  
}