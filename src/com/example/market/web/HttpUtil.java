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
	    private static     AsyncHttpClient client =new AsyncHttpClient();    //实例话对象
	    static
	    {
	        client.setTimeout(11000);   //设置链接超时，如果不设置，默认为10s
	    }
	    public static void get(String urlString,RequestParams params,AsyncHttpResponseHandler res)   //url里面带参数
	    {
	        client.get(urlString, params,res);
	    }
		public static void get(String urlString,JsonHttpResponseHandler res)   //不带参数，获取json对象或者数组
	    {
	        client.get(urlString, res);
	    }
	    public static void get(String urlString,RequestParams params,JsonHttpResponseHandler res)   //带参数，获取json对象或者数组
	    {
	        client.get(urlString, params,res);
	    }
	    public static void get(String urlString, BinaryHttpResponseHandler bHandler)   //下载数据使用，会返回byte数据
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