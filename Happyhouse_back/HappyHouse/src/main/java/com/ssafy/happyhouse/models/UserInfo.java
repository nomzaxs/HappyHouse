package com.ssafy.happyhouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_info")
public class UserInfo {
	
	@Id
	@GeneratedValue
	@Column(name = "userid")
	private Long userid;
	
	@Size(max = 20)
	private String name;
	
	@Size(max = 20)
	private String phone;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "userid")
	private User user;
	
	public UserInfo() {
		
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
