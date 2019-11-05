package com.blog.vo;

import java.sql.Timestamp;

public class TipBoardVO {
	private int num;
	private String id;
	private String passwd;
	private String subject;
	private String content;
	private int readcount;
	private int commcount;
	private String ip;
	private Timestamp regDate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getCommcount() {
		return commcount;
	}
	public void setCommcount(int commcount) {
		this.commcount = commcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipBoardVO [num=").append(num).append(", id=").append(id).append(", passwd=").append(passwd)
				.append(", subject=").append(subject).append(", content=").append(content).append(", readcount=")
				.append(readcount).append(", commcount=").append(commcount).append(", ip=").append(ip)
				.append(", regDate=").append(regDate).append("]");
		return builder.toString();
	}

} // TipBoardVO
