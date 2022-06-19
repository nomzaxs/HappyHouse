package com.ssafy.happyhouse.dto;

// Swagger 제공 X

public class Answer{
	int commentno;
	int articleno; // 댓글 달린 글의 번호
	String userid;
	String content;
	String regtime;
	
	public int getCommentno() {
		return commentno;
	}
	public void setCommentno(int commentno) {
		this.commentno = commentno;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		return "Answer [commentno=" + commentno + ", articleno=" + articleno + ", userid=" + userid + ", content="
				+ content + ", regtime=" + regtime + "]";
	}
}