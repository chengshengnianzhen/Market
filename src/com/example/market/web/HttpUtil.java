package com.example.market.web;

import android.app.Application;

import com.example.market.activity.MyApplication;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpUtil {
	    private static     AsyncHttpClient client =new AsyncHttpClient();    //ʵ��������
	    static
	    {
	        client.setTimeout(11000);   //�������ӳ�ʱ����������ã�Ĭ��Ϊ10s
	    }
	    public static void get(String urlString,RequestParams params,AsyncHttpResponseHandler res)   //url���������
	    {
	        client.get(urlString, params,res);
	    }
		public static void get(String urlString,JsonHttpResponseHandler res)   //������������ȡjson�����������
	    {
	        client.get(urlString, res);
	    }
	    public static void get(String urlString,RequestParams params,JsonHttpResponseHandler res)   //����������ȡjson�����������
	    {
	        client.get(urlString, params,res);
	    }
	    public static void get(String urlString, BinaryHttpResponseHandler bHandler)   //��������ʹ�ã��᷵��byte����
	    {
	        client.get(urlString, bHandler);
	    }
	    public static AsyncHttpClient getClient()
	    {
	        return client;
	    }
	    
		public static void put(String urlString,
				JsonHttpResponseHandler jsonHttpResponseHandler) {
			// TODO Auto-generated method stub
			client.put(urlString, jsonHttpResponseHandler);
		}
		public static void put(String urlString,RequestParams params,
				JsonHttpResponseHandler jsonHttpResponseHandler) {
			// TODO Auto-generated method stub
			client.put(urlString, params , jsonHttpResponseHandler);
		}
		public static void post(String urlString,RequestParams params,
				JsonHttpResponseHandler jsonHttpResponseHandler) {
			// TODO Auto-generated method stub
			client.post(urlString, params , jsonHttpResponseHandler);
		}
		public static void post(String urlString,RequestParams params,
				AsyncHttpResponseHandler asyncHttpResponseHandler) {
			// TODO Auto-generated method stub
			client.post(urlString, params , asyncHttpResponseHandler);
		}
		public static void download_and_update(String urlString,BinaryHttpResponseHandler binaryHttpResponseHandler)
		{
			// TODO Auto-generated method stub
						client.get(urlString, binaryHttpResponseHandler);
		}
		public static void get(String urlString,FileAsyncHttpResponseHandler fileAsyncHttpResponseHandler)
		{
			  client.get(urlString, fileAsyncHttpResponseHandler);
		}
	}