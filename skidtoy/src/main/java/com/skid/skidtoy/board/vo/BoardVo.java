package com.skid.skidtoy.board.vo;

import java.sql.Date;

public class BoardVo {
	
	private int bNum;
	
	private String bTitle;
	
	private String bWriter;
	
	private String bContent;
	
	private Date bRegdate;
	
	private int bHit;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int bNum, String bTitle, String bWriter, String bContent, Date bRegdate, int bHit) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bContent = bContent;
		this.bRegdate = bRegdate;
		this.bHit = bHit;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Date getbRegdate() {
		return bRegdate;
	}

	public void setbRegdate(Date bRegdate) {
		this.bRegdate = bRegdate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	@Override
	public String toString() {
		return "BoardVo [bNum=" + bNum + ", bTitle=" + bTitle + ", bWriter=" + bWriter + ", bContent=" + bContent
				+ ", bRegdate=" + bRegdate + ", bHit=" + bHit + "]";
	}
	
	
	
}
