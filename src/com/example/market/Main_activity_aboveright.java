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
	// UI���
	TextView textView1;
	Button requestLocButton;
	private String Longitude;
	private String Latitude;
	boolean isFirstLoc = true;// �Ƿ��״ζ�λ
	boolean isFirstupload = true;//�Ƿ��״��ϴ�
    @Override
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);   
        //��ʹ��SDK�����֮ǰ��ʼ��context��Ϣ������ApplicationContext  
        //ע��÷���Ҫ��setContentView����֮ǰʵ��  
        SDKInitializer.initialize(getApplicationContext());  
        setContentView(R.layout.main_activity_aboveright);
        //��ȡ��ͼ�ؼ�����
        setTitle("λ����Ϣ");
        requestLocButton = (Button) findViewById(R.id.main_activity_aboveright_button);
		mCurrentMode = LocationMode.NORMAL;		
		requestLocButton.setText("��ͨ");
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_geo);
		OnClickListener btnClickListener = new OnClickListener() {
			public void onClick(View v) {
				switch (mCurrentMode) {
				case NORMAL:
					requestLocButton.setText("����");
					mCurrentMode = LocationMode.COMPASS;
					mBaiduMap
							.setMyLocationConfigeration(new MyLocationConfigeration(
									mCurrentMode, true, mCurrentMarker));
					break;
				case COMPASS:
					requestLocButton.setText("��ͨ");
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
			textView1.setText("�ҵ�λ�ã�"+location.getAddrStr());
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
					Toast.makeText(Main_activity_aboveright.this,"��¼ʱû�������������µ�¼" ,Toast.LENGTH_LONG ).show();
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
								Toast.makeText(Main_activity_aboveright.this, "�ϴ�λ��ʧ��:"+jsonObject.getString("resMsg"),
										Toast.LENGTH_LONG).show();
								Log.d("resMsg", jsonObject.getString("resMsg"));
							}
						}
					  	else {
					  		Toast.makeText(Main_activity_aboveright.this, "�ϴ�λ��ʧ��:"+response,
									Toast.LENGTH_LONG).show();
						}
		                Log.d("location", response.toString());
					  }catch(Exception e){
						  Toast.makeText(Main_activity_aboveright.this, "�ϴ�λ��ʧ��:",
									Toast.LENGTH_LONG).show();
					  }
				}
		        });
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