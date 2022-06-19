package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "동코드", description = "동코드, 시도이름, 구군이름, 동이름을 가진   Domain Class")
public class Dongcode {
	
	@ApiModelProperty(value = "동코드")
	String dongCode;
	@ApiModelProperty(value = "시도이름")
	String sidoName;
	@ApiModelProperty(value = "구군이름")
	String gugunName;
	@ApiModelProperty(value = "동이름")
	String dongName;

	public Dongcode() {
		super();
	}

	public Dongcode(String dongCode, String sidoName, String gugunName, String dongName) {
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	@Override
	public String toString() {
		return "Dongcode [dongCode=" + dongCode + ", sidoName=" + sidoName + ", gugunName=" + gugunName + ", dongName="
				+ dongName + "]";
	}
}
