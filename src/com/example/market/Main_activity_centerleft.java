package com.example.market;

import java.lang.reflect.Type;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfigeration.LocationMode;
import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.db.Userinfo;
import com.example.market.utils.Location;
import com.example.market.web.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfigeration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
public class Main_activity_centerleft extends BaseActivity{
	 	MapView mMapView = null;  
		LocationClient mLocClient;
		public MyLocationListenner myListener = new MyLocationListenner();
		private LocationMode mCurrentMode;
		BaiduMap mBaiduMap;
		BitmapDescriptor mCurrentMarker;
		boolean isFirstLoc = true;
		boolean isFirstupload = true;//是否首次上传
		Button requestLocButton;
		private String Longitude;
		private String Latitude;
		private ProgressDialog pDialog;
		private ListView listView;
		Main_activity_centerleft_Myadapter madapter;
		private ArrayList<Location> askList = new ArrayList<Location>();
	@Override
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.main_activity_centerleft);
        setTitle("附近终端");
        listView=(ListView)findViewById(R.id.main_activity_centerleft_listview);
        madapter = new Main_activity_centerleft_Myadapter(this); 
        listView.setAdapter(madapter);
        requestLocButton = (Button) findViewById(R.id.main_activity_centerleft_button);
		mCurrentMode = LocationMode.NORMAL;		
		requestLocButton.setText("附近终端");
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_geo);
		OnClickListener btnClickListener = new OnClickListener() {
			public void onClick(View v) {
				switch (mCurrentMode) {
				case NORMAL:
					requestLocButton.setText("附近终端");
					mCurrentMode = LocationMode.NORMAL;
					mBaiduMap
							.setMyLocationConfigeration(new MyLocationConfigeration(
									mCurrentMode, true, mCurrentMarker));
					break;
				default:
					break;
				}
			}
		};
		requestLocButton.setOnClickListener(btnClickListener);	
		mMapView=(MapView)findViewById(R.id.main_activity_centerleft_mapview);
		mBaiduMap = mMapView.getMap();
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setAddrType("all");	
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	 	          
	    //mMapView.setVisibility(View.GONE);      
	    }  

	public void setLocationMode(LocationMode mode)
    {
    		
    }
    public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mMapView == null)
				return;
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(100).latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			mBaiduMap.setMyLocationData(locData);
			Latitude = String.valueOf(location.getLatitude());
			Longitude =String.valueOf(location.getLongitude());
			if(isFirstupload)
			{
				DbUtils dbUtil=DbUtils.create(Main_activity_centerleft.this,"market");
		    	Userinfo userinfo = null;
				try {
					userinfo = dbUtil.findById(Userinfo.class, 1);
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(userinfo.isIsnetwork())
				{
					PutToService();
				}else {
					Toast.makeText(Main_activity_centerleft.this,"登录时没有联网，请重新登录" ,Toast.LENGTH_LONG ).show();
				}
				isFirstupload=false;
			}
			//textView1.setText("我的位置："+location.getAddrStr());
			/*LatLng llText = new LatLng(location.getLatitude(),location.getLongitude());  
			//构建文字Option对象，用于在地图上添加文字  
			OverlayOptions textOption = new TextOptions()  
			    .bgColor(0xAAFFFF00)  
			    .fontSize(24)  
			    .fontColor(0xFFFF00FF)  
			    .text(location.getAddrStr())  
			    .rotate(0)  
			    .position(llText);  
			//在地图上添加该文字对象并显示 
			mBaiduMap.addOverlay(textOption);*/
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
				location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);
			}
		}
		public void onReceivePoi(BDLocation poiLocation) {
		}
	}
     protected void PutToService() {
			 
			 MyApplication application = (MyApplication)getApplication();
			 int userId= application.getCurIndex();
			 String urlString=application.getUrl()+"android/getLocation.jsp";
			 RequestParams qParams=new RequestParams();
			 qParams.put("userId", String.valueOf(userId));
			 qParams.put("Longitude", Longitude);
			 qParams.put("Latitude", Latitude);
			 HttpUtil.get(urlString,qParams, new JsonHttpResponseHandler() {
				
				@Override
				public void onSuccess(JSONObject response) {
					// TODO Auto-generated method stub
					Log.d("response1", response.toString());
		              try {
		            	  
		            	if(response.getInt("resCode")==0)
		            	{
		            		Log.d("response2", response.toString());
		            		create(response.getInt("count"),response.getJSONArray("items"));
		            		
		            	}
		            	else {
		            		Toast.makeText(Main_activity_centerleft.this, "获取数据失败:"+response,
									Toast.LENGTH_LONG).show();
		            		Log.d("获取数据失败:", response.toString());
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						Toast.makeText(Main_activity_centerleft.this, "获取数据失败1:"+response,
								Toast.LENGTH_LONG).show();
						Log.d("获取数据失败1:", response.toString()+e);
						e.printStackTrace();
					}  
				}
			});
	}
    private void create(int number,JSONArray jsonArray)
    {
    	if(number==0)
    	{
    		listView.setVisibility(View.GONE);
    	}
    	else{
    	GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		Type type = new TypeToken<ArrayList<Location>>() {
		}.getType();
		ArrayList<Location> list = gson.fromJson(jsonArray.toString(), type);
		askList.addAll(list);
		Log.d("Location", "create(JSONArray jsonArray)"); 	    
		madapter.notifyDataSetChanged();
    	}
    }
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
        mLocClient.stop();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		super.onDestroy();
    }  
    @Override  
    protected void onResume() {  
        super.onResume();  
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理  
        mMapView.onResume(); 
        super.onResume();
        }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理  
        mMapView.onPause();  
        super.onPause();
        }   
    @SuppressLint("InflateParams") public class Main_activity_centerleft_Myadapter extends BaseAdapter {  
    	
        private LayoutInflater layoutInflater;  
        private Context context;   
        
        public Main_activity_centerleft_Myadapter(Context context) {  
              
            this.context = context;    
            this.layoutInflater = LayoutInflater.from(context);  
        }  
      
        /** 
         *获取列数  
         */  
        public int getCount() {  
            return askList.size();  
        }  
        /** 
         *获取某一位置的数据  
         */  
        public Object getItem(int position) {  
            return position;  
        }  
        /** 
         *获取唯一标识 
         */  
        public long getItemId(int position) {  
            return position;  
        }  
      
        /** 
         * android绘制每一列的时候，都会调用这个方法 
         */  
        public View getView(int position, View convertView, ViewGroup parent) {  
        	Main_activity_centerleft_Myadapter_usermessage user = null;  
            if(convertView==null){  
                user = new Main_activity_centerleft_Myadapter_usermessage();  
                // 获取组件布局  
                convertView = layoutInflater.inflate(R.layout.main_activity_centerleft_listview, null);    
                user.titleView = (TextView) convertView.findViewById(R.id.main_activity_centerleft_listview_name);  
                user.infoView = (TextView) convertView.findViewById(R.id.main_activity_centerleft_listview_reduce);  
                user.button = (Button) convertView.findViewById(R.id.main_activity_centerleft_listview_button);  
                // 这里要注意，是使用的tag来存储数据的。  
                convertView.setTag(user);  
            }  
            else {  
                user = (Main_activity_centerleft_Myadapter_usermessage) convertView.getTag();  
            }  
            // 绑定数据、以及事件触发    
            user.titleView.setText(askList.get(position).getuserName());  
            user.infoView.setText(askList.get(position).getUserDistance()+"m"); 
            final int a=position;
            user.button.setOnClickListener(new OnClickListener(){  
      
                public void onClick(View v) {  
                    showInfo(a);  
                }  
                  
            });  
            return convertView;  
        }  
         public void showInfo(int a){    
      
        	  Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+askList.get(a).getMobilePhone()));        	    
        	  startActivity(intent);                               
             }    
      
    } 
    public final class Main_activity_centerleft_Myadapter_usermessage {  
        
        public TextView titleView;  
        public TextView infoView;  
        public Button button;  
          
          
    }  
}

