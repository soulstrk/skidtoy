package com.skid.skidtoy.upload.vo;

public class FileUploadVo {
	
	private int fileSeq;
	
	private int bNum;
	
	private String orgNm;
	
	private String svgNm;
	
	private String fileSize;
	
	public FileUploadVo() {}

	public FileUploadVo(int fileSeq, int bNum, String orgNm, String svgNm, String fileSize) {
		super();
		this.fileSeq = fileSeq;
		this.bNum = bNum;
		this.orgNm = orgNm;
		this.svgNm = svgNm;
		this.fileSize = fileSize;
	}

	public int getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getSvgNm() {
		return svgNm;
	}

	public void setSvgNm(String svgNm) {
		this.svgNm = svgNm;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileUploadVo [fileSeq=" + fileSeq + ", bNum=" + bNum + ", orgNm=" + orgNm + ", svgNm=" + svgNm
				+ ", fileSize=" + fileSize + "]";
	}
	
	
}
