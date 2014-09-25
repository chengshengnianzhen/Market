package com.example.market;

import org.json.JSONObject;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfigeration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.MyLocationConfigeration.LocationMode;
import com.baidu.mapapi.model.LatLng;
import com.example.market.activity.BaseActivity;
import com.example.market.activity.MyApplication;
import com.example.market.db.Userinfo;
import com.example.market.web.HttpUtil;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class Main_activity_aboveright extends BaseActivity {  
    MapView mMapView = null;  
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	private LocationMode mCurrentMode;
	BaiduMap mBaiduMap;
	BitmapDescriptor mCurrentMarker;
	// UI相关
	TextView textView1;
	Button requestLocButton;
	private String Longitude;
	private String Latitude;
	boolean isFirstLoc = true;// 是否首次定位
	boolean isFirstupload = true;//是否首次上传
    @Override
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);   
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext  
        //注意该方法要再setContentView方法之前实现  
        SDKInitializer.initialize(getApplicationContext());  
        setContentView(R.layout.main_activity_aboveright);
        //获取地图控件引用
        setTitle("位置信息");
        requestLocButton = (Button) findViewById(R.id.main_activity_aboveright_button);
		mCurrentMode = LocationMode.NORMAL;		
		requestLocButton.setText("普通");
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_geo);
		OnClickListener btnClickListener = new OnClickListener() {
			public void onClick(View v) {
				switch (mCurrentMode) {
				case NORMAL:
					requestLocButton.setText("罗盘");
					mCurrentMode = LocationMode.COMPASS;
					mBaiduMap
							.setMyLocationConfigeration(new MyLocationConfigeration(
									mCurrentMode, true, mCurrentMarker));
					break;
				case COMPASS:
					requestLocButton.setText("普通");
					mCurrentMode = LocationMode.NORMAL;
					mBaiduMap
							.setMyLocationConfigeration(new MyLocationConfigeration(
									mCurrentMode, true, mCurrentMarker));
					break;
				}
			}
		};
		requestLocButton.setOnClickListener(btnClickListener);	
        mMapView = (MapView) findViewById(R.id.main_activity_aboveright_mapview);
        textView1=(TextView) findViewById(R.id.main_activity_aboveright_textview);
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
			textView1.setText("我的位置："+location.getAddrStr());
			Latitude = String.valueOf(location.getLatitude());
			Longitude =String.valueOf(location.getLongitude());
			if (isFirstupload) {
				DbUtils dbUtil=DbUtils.create(Main_activity_aboveright.this,"market");
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
					Toast.makeText(Main_activity_aboveright.this,"登录时没有联网，请重新登录" ,Toast.LENGTH_LONG ).show();
				}
				
				isFirstupload=false;
			}
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
		 String urlString=application.getUrl()+"android/addLocation.jsp";
		 RequestParams qParams=new RequestParams();
		 qParams.put("userId", String.valueOf(userId));
		 qParams.put("Longitude", Longitude);
		 qParams.put("Latitude", Latitude);
		 HttpUtil.post(urlString, qParams,new AsyncHttpResponseHandler(){			 
			 @Override
				public void onSuccess(int a,String response) {
					// TODO Auto-generated method stub
					  try
					  {
						if(a==200)
						{
							JSONObject jsonObject=new JSONObject(response);
							if(jsonObject.getInt("resCode")!=0)
							{
								Toast.makeText(Main_activity_aboveright.this, "上传位置失败:"+jsonObject.getString("resMsg"),
										Toast.LENGTH_LONG).show();
								Log.d("resMsg", jsonObject.getString("resMsg"));
							}
						}
					  	else {
					  		Toast.makeText(Main_activity_aboveright.this, "上传位置失败:"+response,
									Toast.LENGTH_LONG).show();
						}
		                Log.d("location", response.toString());
					  }catch(Exception e){
						  Toast.makeText(Main_activity_aboveright.this, "上传位置失败:",
									Toast.LENGTH_LONG).show();
					  }
				}
		        });
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
    }