package com.example.market.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
/*
	 "lastTime":"2014-09-16 07:40:22",
	 "userName":"test",
	 "longitude":115.5,
	 "latitude":40.4,
	 "mobilePhone":"12342421412",
	 "userDistance":91000,
	 "userId":52
	 */
	@Expose
	@SerializedName("userId")
	private int userId;
	@Expose
	@SerializedName("userName")
	private String userName;
	@Expose
	@SerializedName("userDistance")
	private String userDistance;
	@Expose
	@SerializedName("mobilePhone")
	private String mobilePhone;
	@Expose
	@SerializedName("latitude")
	private String latitude;
	@Expose
	@SerializedName("longitude")
	private String longitude;
	@Expose
	@SerializedName("lastTime")
	private String lastTime;
	public String getUserDistance() {
		return userDistance;
	}
	public void setUserDistance(String userDistance) {
		this.userDistance = userDistance;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
}
