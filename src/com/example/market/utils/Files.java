package com.example.market.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.R.integer;

public class Files {
	@Expose
	@SerializedName("id")
	private int id;
	@Expose
	@SerializedName("name")
	private String name;
	@Expose
	@SerializedName("path")
	private String path;
	@Expose
	@SerializedName("creatTime")
	private String creatTime;
	@Expose
	@SerializedName("type")
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsVaild() {
		return isVaild;
	}
	public void setIsVaild(String isVaild) {
		this.isVaild = isVaild;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Expose
	@SerializedName("isVaild")
	private String isVaild;
	@Expose
	@SerializedName("userId")
	private String userId;
	
	
}
