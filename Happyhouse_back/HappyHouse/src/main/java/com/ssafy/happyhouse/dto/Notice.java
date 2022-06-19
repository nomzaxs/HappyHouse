package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Notice (공지사항)", description = "글 번호, 작성자아이디, 제목, 내용, 조회 수, 작성일을 가진   Domain Class")
public class Notice {
	
	@ApiModelProperty(value = "글번호")
	int articleno; // 글 번호
	@ApiModelProperty(value = "작성자아이디")
	String userid; // 작성자 아이디
	@ApiModelProperty(value = "제목")
	String subject; // 제목
	@ApiModelProperty(value = "내용")
	String content; // 내용
	@ApiModelProperty(value = "조회수")
	int hit; // 조회 수
	@ApiModelProperty(value = "작성일")
	String regtime; // 작성일
	
	public Notice() {
		super();
	}

	public Notice(String userid, String subject, String content) {
		this(0, userid, subject, content, 0, null);
	}

	public Notice(int articleno, String userid, String subject, String content, int hit, String regtime) {
		super();
		this.articleno = articleno;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
	}

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Notice [articleno=" + articleno + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", hit=" + hit + ", regtime=" + regtime + "]";
	}
}