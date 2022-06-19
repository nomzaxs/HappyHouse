package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "집 정보", description = "아파트코드, 건축년도, 도로명, 법정동명, 주소 코두, 위도, 경도를 가진 Domain Class")
public class Houseinfo {
	@ApiModelProperty(value = "아파트코드")
	String aptCode;
	@ApiModelProperty(value = "건축년도")
	int buildYear;
	@ApiModelProperty(value = "도로명 이름")
	String roadName;
	@ApiModelProperty(value = "도로명 본번")
	String roadNameBonbun;
	@ApiModelProperty(value = "도로명 부번")
	String roadNamebubun;
	@ApiModelProperty(value = "도로명순서")
	String roadNameSeq;
	@ApiModelProperty(value = "도로명기본코드")
	String roadNameBasementCode;
	@ApiModelProperty(value = "도로명코드")
	String roadNameCode;
	@ApiModelProperty(value = "법정동")
	String dong;
	@ApiModelProperty(value = "본번")
	String bonbun;
	@ApiModelProperty(value = "부번")
	String bubun;
	@ApiModelProperty(value = "시군구코드")
	String sigunguCode;
	@ApiModelProperty(value = "읍면동코드")
	String eubmyundongCode;
	@ApiModelProperty(value = "동코드")
	String dongCode;
	@ApiModelProperty(value = "국가코드")
	String landCode;
	@ApiModelProperty(value = "아파트이름")
	String apartmentName;
	@ApiModelProperty(value = "지번")
	String jibun;
	@ApiModelProperty(value = "경도")
	String lng;
	@ApiModelProperty(value = "위도")
	String lat;

	public String getAptCode() {
		return aptCode;
	}

	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getRoadNameBonbun() {
		return roadNameBonbun;
	}

	public void setRoadNameBonbun(String roadNameBonbun) {
		this.roadNameBonbun = roadNameBonbun;
	}

	public String getRoadNamebubun() {
		return roadNamebubun;
	}

	public void setRoadNamebubun(String roadNamebubun) {
		this.roadNamebubun = roadNamebubun;
	}

	public String getRoadNameSeq() {
		return roadNameSeq;
	}

	public void setRoadNameSeq(String roadNameSeq) {
		this.roadNameSeq = roadNameSeq;
	}

	public String getRoadNameBasementCode() {
		return roadNameBasementCode;
	}

	public void setRoadNameBasementCode(String roadNameBasementCode) {
		this.roadNameBasementCode = roadNameBasementCode;
	}

	public String getRoadNameCode() {
		return roadNameCode;
	}

	public void setRoadNameCode(String roadNameCode) {
		this.roadNameCode = roadNameCode;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBonbun() {
		return bonbun;
	}

	public void setBonbun(String bonbun) {
		this.bonbun = bonbun;
	}

	public String getBubun() {
		return bubun;
	}

	public void setBubun(String bubun) {
		this.bubun = bubun;
	}

	public String getSigunguCode() {
		return sigunguCode;
	}

	public void setSigunguCode(String sigunguCode) {
		this.sigunguCode = sigunguCode;
	}

	public String getEubmyundongCode() {
		return eubmyundongCode;
	}

	public void setEubmyundongCode(String eubmyundongCode) {
		this.eubmyundongCode = eubmyundongCode;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getLandCode() {
		return landCode;
	}

	public void setLandCode(String landCode) {
		this.landCode = landCode;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Houseinfo [aptCode=" + aptCode + ", buildYear=" + buildYear + ", roadName=" + roadName
				+ ", roadNameBonbun=" + roadNameBonbun + ", roadNamebubun=" + roadNamebubun + ", roadNameSeq="
				+ roadNameSeq + ", roadNameBasementCode=" + roadNameBasementCode + ", roadNameCode=" + roadNameCode
				+ ", dong=" + dong + ", bonbun=" + bonbun + ", bubun=" + bubun + ", sigunguCode=" + sigunguCode
				+ ", eubmyundongCode=" + eubmyundongCode + ", dongCode=" + dongCode + ", landCode=" + landCode
				+ ", apartmentName=" + apartmentName + ", jibun=" + jibun + ", lng=" + lng + ", lat=" + lat + "]";
	}

}
