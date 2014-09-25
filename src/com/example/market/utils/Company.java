package com.example.market.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Company {

	/*
	 *Company
	ID:数字
	Name:XXX，
	Number:XXXX，
	Type：XXXX，
	Owner（投资人）:XXX，
	Address:XXXX，
	Scope (经营范围):xxxxx，
	Gear（登记机关）:XXX，
	IssueDate:XXXX-XX-XX，
	BuildDate:XXXX-XX-XX，
	Status:XXX，
	private Integer id;
	private String name;
	private String number;
	private String type;
    private String owner;
	private String address;
	private String scope;
    private String gear;
	private Date issueDate;
	private Date buildDate;
	private String status;
	 */
	@Expose
	@SerializedName("id")
	private int id;
	@Expose
	@SerializedName("name")
	private String name;
	@Expose
	@SerializedName("number")
	private String number;
	@Expose
	@SerializedName("type")
	private String type;
	@Expose
	@SerializedName("owner")
	private String owner;
	@Expose
	@SerializedName("address")
	private String address;
	@Expose
	@SerializedName("scope")
	private String scope;
	@Expose
	@SerializedName("issueDate")
	private String issueDate;
	@Expose
	@SerializedName("gear")
	private String gear;
	@Expose
	@SerializedName("buildDate")
	private String buildDate;
	@Expose
	@SerializedName("status")
	private String status;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
