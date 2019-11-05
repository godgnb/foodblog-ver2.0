package com.blog.vo;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String phone;
	private String email;
	private Timestamp regDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRegdate() {
		return regDate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regDate = regdate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberVO [id=").append(id).append(", passwd=").append(passwd).append(", name=").append(name)
				.append(", phone=").append(phone).append(", email=").append(email).append(", regdate=").append(regDate)
				.append("]");
		return builder.toString();
	}
} // // MemberVO
