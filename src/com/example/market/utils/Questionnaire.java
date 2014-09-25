package com.example.market.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Questionnaire {

	@Expose
	@SerializedName("userId")
	private int userId;
	@Expose
	@SerializedName("id")
	private int id;
	@Expose
	@SerializedName("companyName")
	private String companyName;
	@Expose
	@SerializedName("companyNo")
	private String companyNo;
	@Expose
	@SerializedName("person")
	private String person;
	@Expose
	@SerializedName("unit")
	private String unit;
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	@Expose
	@SerializedName("zgCertFlag")
	private boolean zgCertFlag;
	@Expose
	@SerializedName("zgCertDetail")
	private String zgCertDetail;
	@Expose
	@SerializedName("zgBusinessFlag")
	private boolean zgBusinessFlag;
	@Expose
	@SerializedName("zgBusinessDetail")
	private String zgBusinessDetail;
	@Expose
	@SerializedName("zgNameDetail")
	private String zgNameDetail;
	@Expose
	@SerializedName("zgNameFlag")
	private boolean zgNameFlag;
	@Expose
	@SerializedName("zgCertMissFlag")
	private boolean zgCertMissFlag;
	@Expose
	@SerializedName("zgCertMissDetail")
	private String zgCertMissDetail;
	@Expose
	@SerializedName("zgNianJianFlag")
	private boolean zgNianJianFlag;
	@Expose
	@SerializedName("zgNianJianDetail")
	private String zgNianJianDetail;
	@Expose
	@SerializedName("zgQiXianFlag")
	private boolean zgQiXianFlag;
	@Expose
	@SerializedName("zgQiXianDetail")
	private String zgQiXianDetail;
	@Expose
	@SerializedName("zgBianGengFlag")
	private boolean zgBianGengFlag;
	@Expose
	@SerializedName("zgBianGengDetail")
	private String zgBianGengDetail;
	@Expose
	@SerializedName("zgXuBaoFlag")
	private boolean zgXuBaoFlag;
	@Expose
	@SerializedName("zgXuBaoDetail")
	private String zgXuBaoDetail;	
	@Expose
	@SerializedName("xwShenPiFlag")
	private boolean xwShenPiFlag;
	@Expose
	@SerializedName("xwShenPiDetail")
	private String xwShenPiDetail;
	@Expose
	@SerializedName("xwHeZhunFlag")
	private boolean xwHeZhunFlag;
	@Expose
	@SerializedName("xwHeZhunDetail")
	private String xwHeZhunDetail;
	@Expose
	@SerializedName("xwShangBiaoFlag")
	private boolean xwShangBiaoFlag;
	@Expose
	@SerializedName("xwShangBiaoDetail")
	private String xwShangBiaoDetail;
	@Expose
	@SerializedName("xwQinQuanFlag")
	private boolean xwQinQuanFlag;
	@Expose
	@SerializedName("xwQinQuanDetail")
	private String xwQinQuanDetail;
	@Expose
	@SerializedName("xwWeiZhaoFlag")
	private boolean xwWeiZhaoFlag;
	@Expose
	@SerializedName("xwWeiZhaoDetail")
	private String xwWeiZhaoDetail;
	@Expose
	@SerializedName("xwXuJiaFlag")
	private boolean xwXuJiaFlag;
	@Expose
	@SerializedName("xwXuJiaDetail")
	private String xwXuJiaDetail;
	@Expose
	@SerializedName("lxShangPinFlag")
	private boolean lxShangPinFlag;
	@Expose
	@SerializedName("lxShangPinDetail")
	private String lxShangPinDetail;
	@Expose
	@SerializedName("lxJinHuoFlag")
	private boolean lxJinHuoFlag;
	@Expose
	@SerializedName("lxJinHuoDetail")
	private String lxJinHuoDetail;

	@Expose
	@SerializedName("lxChaYanFlag")
	private boolean lxChaYanFlag;
	@Expose
	@SerializedName("lxChaYanDetail")
	private String lxChaYanDetail;
//	lxPinZhengFlag	tinyboolean(1)	3.4凭证
//	lxPinZhengDetail	varchar(255)
	@Expose
	@SerializedName("lxPinZhengFlag")
	private boolean lxPinZhengFlag;
	@Expose
	@SerializedName("lxPinZhengDetail")
	private String lxPinZhengDetail;
//	lxGuanLiFeiFlag	tinyboolean(1)	3.5管理费
//	lxGuanLiFeiDetail	varchar(255)
	@Expose
	@SerializedName("lxGuanLiFeiFlag")
	private boolean lxGuanLiFeiFlag;
	@Expose
	@SerializedName("lxGuanLiFeiDetail")
	private String lxGuanLiFeiDetail;
//	glZhiZeFlag	tinyboolean(1)	4.1职责
//	glZhiZeDetail	varchar(255)
	@Expose
	@SerializedName("glZhiZeFlag")
	private boolean glZhiZeFlag;
	@Expose
	@SerializedName("glZhiZeDetail")
	private String glZhiZeDetail;
//	glLuoShiFlag	tinyboolean(1)	4.2落实
//	glLuoShiDetail	varchar(255)
	@Expose
	@SerializedName("glLuoShiFlag")
	private boolean glLuoShiFlag;
	@Expose
	@SerializedName("glLuoShiDetail")
	private String glLuoShiDetail;
//	glShouXuFlag	tinyboolean(1)	4.3手续
//	glShouXuDetail	varchar(255)
	@Expose
	@SerializedName("glShouXuFlag")
	private boolean glShouXuFlag;
	@Expose
	@SerializedName("glShouXuDetail")
	private String glShouXuDetail;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public boolean isZgCertFlag() {
		return zgCertFlag;
	}
	public void setZgCertFlag(boolean zgCertFlag) {
		this.zgCertFlag = zgCertFlag;
	}
	public String getZgCertDetail() {
		return zgCertDetail;
	}
	public void setZgCertDetail(String zgCertDetail) {
		this.zgCertDetail = zgCertDetail;
	}
	public boolean isZgBusinessFlag() {
		return zgBusinessFlag;
	}
	public void setZgBusinessFlag(boolean zgBusinessFlag) {
		this.zgBusinessFlag = zgBusinessFlag;
	}
	public String getZgBusinessDetail() {
		return zgBusinessDetail;
	}
	public void setZgBusinessDetail(String zgBusinessDetail) {
		this.zgBusinessDetail = zgBusinessDetail;
	}
	public String getZgNameDetail() {
		return zgNameDetail;
	}
	public void setZgNameDetail(String zgNameDetail) {
		this.zgNameDetail = zgNameDetail;
	}
	public boolean isZgNameFlag() {
		return zgNameFlag;
	}
	public void setZgNameFlag(boolean zgNameFlag) {
		this.zgNameFlag = zgNameFlag;
	}
	public boolean isZgCertMissFlag() {
		return zgCertMissFlag;
	}
	public void setZgCertMissFlag(boolean zgCertMissFlag) {
		this.zgCertMissFlag = zgCertMissFlag;
	}
	public String getZgCertMissDetail() {
		return zgCertMissDetail;
	}
	public void setZgCertMissDetail(String zgCertMissDetail) {
		this.zgCertMissDetail = zgCertMissDetail;
	}
	public boolean isZgNianJianFlag() {
		return zgNianJianFlag;
	}
	public void setZgNianJianFlag(boolean zgNianJianFlag) {
		this.zgNianJianFlag = zgNianJianFlag;
	}
	public String getZgNianJianDetail() {
		return zgNianJianDetail;
	}
	public void setZgNianJianDetail(String zgNianJianDetail) {
		this.zgNianJianDetail = zgNianJianDetail;
	}
	public boolean isZgQiXianFlag() {
		return zgQiXianFlag;
	}
	public void setZgQiXianFlag(boolean zgQiXianFlag) {
		this.zgQiXianFlag = zgQiXianFlag;
	}
	public String getZgQiXianDetail() {
		return zgQiXianDetail;
	}
	public void setZgQiXianDetail(String zgQiXianDetail) {
		this.zgQiXianDetail = zgQiXianDetail;
	}
	public boolean isZgBianGengFlag() {
		return zgBianGengFlag;
	}
	public void setZgBianGengFlag(boolean zgBianGengFlag) {
		this.zgBianGengFlag = zgBianGengFlag;
	}
	public String getZgBianGengDetail() {
		return zgBianGengDetail;
	}
	public void setZgBianGengDetail(String zgBianGengDetail) {
		this.zgBianGengDetail = zgBianGengDetail;
	}
	public boolean isZgXuBaoFlag() {
		return zgXuBaoFlag;
	}
	public void setZgXuBaoFlag(boolean zgXuBaoFlag) {
		this.zgXuBaoFlag = zgXuBaoFlag;
	}
	public String getZgXuBaoDetail() {
		return zgXuBaoDetail;
	}
	public void setZgXuBaoDetail(String zgXuBaoDetail) {
		this.zgXuBaoDetail = zgXuBaoDetail;
	}
	public boolean isXwShenPiFlag() {
		return xwShenPiFlag;
	}
	public void setXwShenPiFlag(boolean xwShenPiFlag) {
		this.xwShenPiFlag = xwShenPiFlag;
	}
	public String getXwShenPiDetail() {
		return xwShenPiDetail;
	}
	public void setXwShenPiDetail(String xwShenPiDetail) {
		this.xwShenPiDetail = xwShenPiDetail;
	}
	public boolean isXwHeZhunFlag() {
		return xwHeZhunFlag;
	}
	public void setXwHeZhunFlag(boolean xwHeZhunFlag) {
		this.xwHeZhunFlag = xwHeZhunFlag;
	}
	public String getXwHeZhunDetail() {
		return xwHeZhunDetail;
	}
	public void setXwHeZhunDetail(String xwHeZhunDetail) {
		this.xwHeZhunDetail = xwHeZhunDetail;
	}
	public boolean isXwShangBiaoFlag() {
		return xwShangBiaoFlag;
	}
	public void setXwShangBiaoFlag(boolean xwShangBiaoFlag) {
		this.xwShangBiaoFlag = xwShangBiaoFlag;
	}
	public String getXwShangBiaoDetail() {
		return xwShangBiaoDetail;
	}
	public void setXwShangBiaoDetail(String xwShangBiaoDetail) {
		this.xwShangBiaoDetail = xwShangBiaoDetail;
	}
	public boolean isXwQinQuanFlag() {
		return xwQinQuanFlag;
	}
	public void setXwQinQuanFlag(boolean xwQinQuanFlag) {
		this.xwQinQuanFlag = xwQinQuanFlag;
	}
	public String getXwQinQuanDetail() {
		return xwQinQuanDetail;
	}
	public void setXwQinQuanDetail(String xwQinQuanDetail) {
		this.xwQinQuanDetail = xwQinQuanDetail;
	}
	public boolean isXwWeiZhaoFlag() {
		return xwWeiZhaoFlag;
	}
	public void setXwWeiZhaoFlag(boolean xwWeiZhaoFlag) {
		this.xwWeiZhaoFlag = xwWeiZhaoFlag;
	}
	public String getXwWeiZhaoDetail() {
		return xwWeiZhaoDetail;
	}
	public void setXwWeiZhaoDetail(String xwWeiZhaoDetail) {
		this.xwWeiZhaoDetail = xwWeiZhaoDetail;
	}
	public boolean isXwXuJiaFlag() {
		return xwXuJiaFlag;
	}
	public void setXwXuJiaFlag(boolean xwXuJiaFlag) {
		this.xwXuJiaFlag = xwXuJiaFlag;
	}
	public String getXwXuJiaDetail() {
		return xwXuJiaDetail;
	}
	public void setXwXuJiaDetail(String xwXuJiaDetail) {
		this.xwXuJiaDetail = xwXuJiaDetail;
	}
	public boolean isLxShangPinFlag() {
		return lxShangPinFlag;
	}
	public void setLxShangPinFlag(boolean lxShangPinFlag) {
		this.lxShangPinFlag = lxShangPinFlag;
	}
	public String getLxShangPinDetail() {
		return lxShangPinDetail;
	}
	public void setLxShangPinDetail(String lxShangPinDetail) {
		this.lxShangPinDetail = lxShangPinDetail;
	}
	public boolean isLxJinHuoFlag() {
		return lxJinHuoFlag;
	}
	public void setLxJinHuoFlag(boolean lxJinHuoFlag) {
		this.lxJinHuoFlag = lxJinHuoFlag;
	}
	public String getLxJinHuoDetail() {
		return lxJinHuoDetail;
	}
	public void setLxJinHuoDetail(String lxJinHuoDetail) {
		this.lxJinHuoDetail = lxJinHuoDetail;
	}
	public boolean isLxChaYanFlag() {
		return lxChaYanFlag;
	}
	public void setLxChaYanFlag(boolean lxChaYanFlag) {
		this.lxChaYanFlag = lxChaYanFlag;
	}
	public String getLxChaYanDetail() {
		return lxChaYanDetail;
	}
	public void setLxChaYanDetail(String lxChaYanDetail) {
		this.lxChaYanDetail = lxChaYanDetail;
	}
	public boolean isLxPinZhengFlag() {
		return lxPinZhengFlag;
	}
	public void setLxPinZhengFlag(boolean lxPinZhengFlag) {
		this.lxPinZhengFlag = lxPinZhengFlag;
	}
	public String getLxPinZhengDetail() {
		return lxPinZhengDetail;
	}
	public void setLxPinZhengDetail(String lxPinZhengDetail) {
		this.lxPinZhengDetail = lxPinZhengDetail;
	}
	public boolean isLxGuanLiFeiFlag() {
		return lxGuanLiFeiFlag;
	}
	public void setLxGuanLiFeiFlag(boolean lxGuanLiFeiFlag) {
		this.lxGuanLiFeiFlag = lxGuanLiFeiFlag;
	}
	public String getLxGuanLiFeiDetail() {
		return lxGuanLiFeiDetail;
	}
	public void setLxGuanLiFeiDetail(String lxGuanLiFeiDetail) {
		this.lxGuanLiFeiDetail = lxGuanLiFeiDetail;
	}
	public boolean isGlZhiZeFlag() {
		return glZhiZeFlag;
	}
	public void setGlZhiZeFlag(boolean glZhiZeFlag) {
		this.glZhiZeFlag = glZhiZeFlag;
	}
	public String getGlZhiZeDetail() {
		return glZhiZeDetail;
	}
	public void setGlZhiZeDetail(String glZhiZeDetail) {
		this.glZhiZeDetail = glZhiZeDetail;
	}
	public boolean isGlLuoShiFlag() {
		return glLuoShiFlag;
	}
	public void setGlLuoShiFlag(boolean glLuoShiFlag) {
		this.glLuoShiFlag = glLuoShiFlag;
	}
	public String getGlLuoShiDetail() {
		return glLuoShiDetail;
	}
	public void setGlLuoShiDetail(String glLuoShiDetail) {
		this.glLuoShiDetail = glLuoShiDetail;
	}
	public boolean isGlShouXuFlag() {
		return glShouXuFlag;
	}
	public void setGlShouXuFlag(boolean glShouXuFlag) {
		this.glShouXuFlag = glShouXuFlag;
	}
	public String getGlShouXuDetail() {
		return glShouXuDetail;
	}
	public void setGlShouXuDetail(String glShouXuDetail) {
		this.glShouXuDetail = glShouXuDetail;
	}


}
