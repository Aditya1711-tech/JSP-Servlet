package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
	private int pId;
	private String pTitle;
	private String pContent;
	private String pCode;
	private String pPick;
	private Timestamp pDate;
	private int catId;

	public Post(int pId, String pTitle, String pContent, String pCode, String pPick, Timestamp pDate, int catId) {
		super();
		this.pId = pId;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPick = pPick;
		this.pDate = pDate;
		this.catId = catId;
	}

	public Post() {
		super();
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpPick() {
		return pPick;
	}

	public void setpPick(String pPick) {
		this.pPick = pPick;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

}
