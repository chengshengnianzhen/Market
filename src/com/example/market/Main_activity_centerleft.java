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
        setTitle("�����ն�");
        requestLocButton = (Button) findViewById(R.id.main_activity_centerleft_button);
		mCurrentMode = LocationMode.NORMAL;		
		requestLocButton.setText("�����ն�");
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_geo);
		OnClickListener btnClickListener = new OnClickListener() {
			public void onClick(View v) {
				switch (mCurrentMode) {
				case NORMAL:
					requestLocButton.setText("�����ն�");
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
		// ������λͼ��
		mBaiduMap.setMyLocationEnabled(true);
		// ��λ��ʼ��
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// ��gps
		option.setAddrType("all");	
		option.setCoorType("bd09ll"); // ������������
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
		//�����ն˽ӿ�
		 ArrayList<HashMap<String, Object>> data = getData();  
	        //ģ��SimpleAdapterʵ�ֵ��Լ���adapter  
	        Main_activity_centerleft_Myadapter adapter = new Main_activity_centerleft_Myadapter(this, data);  
	          
	        /** 
	         * ��Щ�˺��Ժ������Ƕ�֪��vlist2.xml�൱�ڴ洢һ�����ݵ�������֣�������ǰ�ߵĴ����У�������һ���������ļ�main.xml�ģ� 
	         * ��������ļ��Ƿ����������ļ�����ʾ�ģ�һ������ж���ͨ��setContentView()��ָ���������ļ��ġ�Ϊ�����������û���õ� 
	         * ������listView������һ�������������ء� 
	         * �����ǿ���setListAdapter��ListActivity�е�ʵ�֣� 
	         * public void setListAdapter(ListAdapter adapter) { 
	            synchronized (this) { 
	            ensureList(); 
	            mAdapter = adapter; 
	            mList.setAdapter(adapter); 
	        } 
	    } 
	    ���������һ��ensureList��������������������������� 
	     private void ensureList() { 
	        if (mList != null) { 
	            return; 
	        } 
	        setContentView(com.android.internal.R.layout.list_content); 
	 
	    } 
	    ���ڿ����ˣ������и� setContentView�������������������ǵ������һ��android�Լ��ṩ�Ľ�������ʾ�� 
	    ԭ�������ǵ����ۻ������õģ�ֻ����ListActivity���ҽ���������ʵ�֡� 
	         */  
	        ListView listView=(ListView)findViewById(R.id.main_activity_centerleft_listview);
	        listView.setAdapter(adapter); 	          
	          
	    }  
	  
	    /** 
	     * @author chenzheng_java 
	     * @description ׼��һЩ�������� 
	     * @return һ��������������Ϣ��hashMap���� 
	     */  
	    private ArrayList<HashMap<String, Object>> getData(){  
	        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String,Object>>();  
	        for(int i=0;i<4;i++){  
	            HashMap<String, Object> tempHashMap = new HashMap<String, Object>();  
	            tempHashMap.put("name", "����"+i);  
	            tempHashMap.put("reduce", "����");  
	            arrayList.add(tempHashMap);  
	        }  
	        return arrayList;  
	    }  
	  
	    protected void onListItemClick(ListView l, View v, int position, long id) {  
	          
	        Log.i("�����Ϣ",v.toString() );  
	    }  
	public void setLocationMode(LocationMode mode)
    {
    		
    }
    public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view ���ٺ��ڴ����½��յ�λ��
			if (location == null || mMapView == null)
				return;
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// �˴����ÿ����߻�ȡ���ķ�����Ϣ��˳ʱ��0-360
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
			//textView1.setText("�ҵ�λ�ã�"+location.getAddrStr());
			/*LatLng llText = new LatLng(location.getLatitude(),location.getLongitude());  
			//��������Option���������ڵ�ͼ���������  
			OverlayOptions textOption = new TextOptions()  
			    .bgColor(0xAAFFFF00)  
			    .fontSize(24)  
			    .fontColor(0xFFFF00FF)  
			    .text(location.getAddrStr())  
			    .rotate(0)  
			    .position(llText);  
			//�ڵ�ͼ����Ӹ����ֶ�����ʾ 
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
        //��activityִ��onDestroyʱִ��mMapView.onDestroy()��ʵ�ֵ�ͼ�������ڹ���  
        mLocClient.stop();
		// �رն�λͼ��
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;
		super.onDestroy();
    }  
    @Override  
    protected void onResume() {  
        super.onResume();  
        //��activityִ��onResumeʱִ��mMapView. onResume ()��ʵ�ֵ�ͼ�������ڹ���  
        mMapView.onResume(); 
        super.onResume();
        }  
    @Override  
    protected void onPause() {  
        super.onPause();  
        //��activityִ��onPauseʱִ��mMapView. onPause ()��ʵ�ֵ�ͼ�������ڹ���  
        mMapView.onPause();  
        super.onPause();
        }  
}