package com.myspring.pro27.board.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int articleno;
	private int parentno;
	private String title;
	private String content;
	private String imagefilename;
	private Timestamp writedate;
	private String id;
	
	public BoardVO() {
		
	}
	
	public BoardVO(int articleno, int parentno, String title, String content, String imagefilename, Timestamp writedate, String id) {
		this.articleno = articleno;
		this.parentno = parentno;
		this.title = title;
		this.content = content;
		this.imagefilename = imagefilename;
		this.writedate = writedate;
		this.id = id;
	}
	
	public int getArticleno() {
		return articleno;
	}
	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}
	public int getParentno() {
		return parentno;
	}
	public void setParentno(int parentno) {
		this.parentno = parentno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagefilename() {
		return imagefilename;
	}
	public void setImagefilename(String imagefilename) {
		this.imagefilename = imagefilename;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
