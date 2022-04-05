package com.mBoard.entity;

import java.time.LocalDateTime;

public class Board { //ORM을 사용하기 위헤선 테이블과 1:1 매칭되기 위한 클래스가 필요. 

	private int seqno;
	private String userid;
	private String mwriter;
	private String mtitle;
	private LocalDateTime mregdate; // 자바의 현재 날짜 시간을 나타내는 클래스. Time stamp 받기 위한 친구.
	private String mcontent;
	private String filename;
	private Long filesize;
	
	
	
	
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMwriter() {
		return mwriter;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public LocalDateTime getMregdate() {
		return mregdate;
	}
	public void setMregdate(LocalDateTime mregdate) {
		this.mregdate = mregdate;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	

	
}
