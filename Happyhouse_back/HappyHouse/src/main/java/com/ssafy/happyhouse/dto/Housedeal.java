package com.ssafy.happyhouse.dto;

import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "집 거래정보", description = "번호, 거래량, 거래년도, 거래월, 거래일, 지역, 층, 아파트코드를 가진 Domain Class")
public class Housedeal {
	@ApiModelProperty(value = "동코드 +Autoincrement")
	long no;
	@ApiModelProperty(value = "거래금액")
	String dealAmount;
	@ApiModelProperty(value = "거래년도")
	int dealYear;
	@ApiModelProperty(value = "거래월")
	int dealMonth;
	@ApiModelProperty(value = "거래일")
	int dealDay;
	@ApiModelProperty(value = "면적")
	String area;
	@ApiModelProperty(value = "층")
	String floor;
	@ApiModelProperty(value = "해제여부")
	String cancelDealType;
	@ApiModelProperty(value = "아파트코드")
	BigInteger aptCode;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getCancelDealType() {
		return cancelDealType;
	}

	public void setCancelDealType(String cancelDealType) {
		this.cancelDealType = cancelDealType;
	}

	public BigInteger getAptCode() {
		return aptCode;
	}

	public void setAptCode(BigInteger aptCode) {
		this.aptCode = aptCode;
	}

	@Override
	public String toString() {
		return "Housedeal [no=" + no + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear + ", dealMonth="
				+ dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + ", cancelDealType="
				+ cancelDealType + ", aptCode=" + aptCode + "]";
	}

}
