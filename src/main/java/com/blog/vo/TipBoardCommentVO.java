package com.blog.vo;

import java.sql.Timestamp;

public class TipBoardCommentVO {
	private int reNum;
	private String id;
	private String content;
	private Timestamp regDate;
	private int num;
	
	public int getReNum() {
		return reNum;
	}
	public void setReNum(int reNum) {
		this.reNum = reNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipBoardCommentVO [reNum=").append(reNum).append(", id=").append(id).append(", content=")
				.append(content).append(", regDate=").append(regDate).append(", num=").append(num).append("]");
		return builder.toString();
	}
	
} // TipBoardCommentVO
