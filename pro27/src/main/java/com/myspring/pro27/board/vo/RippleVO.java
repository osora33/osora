package com.myspring.pro27.board.vo;

import java.sql.Timestamp;

public class RippleVO {
	private int articleno;
	private int rno;
	private String id;
	private String ripple;
	private Timestamp writedate;
	
	public int getArticleno() {
		return articleno;
	}
	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRipple() {
		return ripple;
	}
	public void setRipple(String ripple) {
		this.ripple = ripple;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp date) {
		this.writedate = date;
	}
}
