package com.example.market;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfigeration.LocationMode;
import com.example.market.Main_activity_aboveright.MyLocationListenner;
import com.example.market.activity.BaseActivity;
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
import com.baidu.mapapi.model.LatLng;
public class Main_activity_centerleft extends BaseActivity{
	 MapView mMapView = null;  
		LocationClient mLocClient;
		public MyLocationListenner myListener = new MyLocationListenner();
		private LocationMode mCurrentMode;
		BaiduMap mBaiduMap;
		BitmapDescriptor mCurrentMarker;
		boolean isFirstLoc = true;
		Button requestLocButton;
	@Override  
	
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.main_activity_centerleft);
        setTitle("附近终端");
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
		//附近终端接口
		 ArrayList<HashMap<String, Object>> data = getData();  
	        //模仿SimpleAdapter实现的自己的adapter  
	        Main_activity_centerleft_Myadapter adapter = new Main_activity_centerleft_Myadapter(this, data);  
	          
	        /** 
	         * 有些人很迷糊，我们都知道vlist2.xml相当于存储一行数据的组件布局，我们在前边的代码中，都是有一个主布局文件main.xml的， 
	         * 组件布局文件是放在主布局文件上显示的，一般代码中都是通过setContentView()来指定主布局文件的。为何这里根本就没有用到 
	         * ，但是listView还能有一个界面来呈现呢。 
	         * 让我们看看setListAdapter在ListActivity中的实现， 
	         * public void setListAdapter(ListAdapter adapter) { 
	            synchronized (this) { 
	            ensureList(); 
	            mAdapter = adapter; 
	            mList.setAdapter(adapter); 
	        } 
	    } 
	    里面调用了一个ensureList方法，我们再来看看这个方法： 
	     private void ensureList() { 
	        if (mList != null) { 
	            return; 
	        } 
	        setContentView(com.android.internal.R.layout.list_content); 
	 
	    } 
	    现在看到了，这里有个 setContentView方法，里面设置了我们的组件在一个android自己提供的界面上显示。 
	    原来，我们的理论还是适用的，只不过ListActivity给我进行了隐藏实现。 
	         */  
	        ListView listView=(ListView)findViewById(R.id.main_activity_centerleft_listview);
	        listView.setAdapter(adapter); 	          
	          
	    }  
	  
	    /** 
	     * @author chenzheng_java 
	     * @description 准备一些测试数据 
	     * @return 一个包含了数据信息的hashMap集合 
	     */  
	    private ArrayList<HashMap<String, Object>> getData(){  
	        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String,Object>>();  
	        for(int i=0;i<4;i++){  
	            HashMap<String, Object> tempHashMap = new HashMap<String, Object>();  
	            tempHashMap.put("name", "标题"+i);  
	            tempHashMap.put("reduce", "距离");  
	            arrayList.add(tempHashMap);  
	        }  
	        return arrayList;  
	    }  
	  
	    protected void onListItemClick(ListView l, View v, int position, long id) {  
	          
	        Log.i("输出信息",v.toString() );  
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
			for(int i=0;i<3;i++)
			{
				MyLocationData locData2 =new MyLocationData.Builder()
				.accuracy(location.getRadius())
				.direction(100).latitude(location.getLatitude()+0.01*i)
				.longitude(location.getLongitude()).build();
				mBaiduMap.setMyLocationData(locData2);			
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