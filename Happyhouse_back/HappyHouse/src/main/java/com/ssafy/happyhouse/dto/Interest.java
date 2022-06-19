package com.ssafy.happyhouse.dto;

public class Interest {
	int interestno;
	String userid; // username으로 등록
	String dongcode;
	String aptName;
	
	public int getInterestno() {
		return interestno;
	}
	public void setInterestno(int interestno) {
		this.interestno = interestno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	@Override
	public String toString() {
		return "Interest [interestno=" + interestno + ", userid=" + userid + ", dongcode=" + dongcode + ", aptName="
				+ aptName + "]";
	}
}
