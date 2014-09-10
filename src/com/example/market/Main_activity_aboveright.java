package com.example.market;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.market.activity.BaseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
	boolean isFirstLoc = true;// 是否首次定位
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
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