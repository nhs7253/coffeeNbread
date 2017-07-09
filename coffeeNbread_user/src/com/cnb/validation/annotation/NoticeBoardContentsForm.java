package com.cnb.validation.annotation;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-07-08
 * 생성, 초기 구현
 */
public class NoticeBoardContentsForm{
	private int noticeBoardNo;		//PRIMARY KEY
	@NotEmpty
	private String noticeBoardContent;
	@NotEmpty
	private String noticeBoardTitle;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date noticeBoardDate;
	private int noticeBoardHits;
	
	public int getNoticeBoardNo() {
		return noticeBoardNo;
	}
	public void setNoticeBoardNo(int noticeBoardNo) {
		this.noticeBoardNo = noticeBoardNo;
	}
	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}
	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}
	public String getNoticeBoardTitle() {
		return noticeBoardTitle;
	}
	public void setNoticeBoardTitle(String noticeBoardTitle) {
		this.noticeBoardTitle = noticeBoardTitle;
	}
	public Date getNoticeBoardDate() {
		return noticeBoardDate;
	}
	public void setNoticeBoardDate(Date noticeBoardDate) {
		this.noticeBoardDate = noticeBoardDate;
	}
	public int getNoticeBoardHits() {
		return noticeBoardHits;
	}
	public void setNoticeBoardHits(int noticeBoardHits) {
		this.noticeBoardHits = noticeBoardHits;
	}
	@Override
	public String toString() {
		return "NoticeBoardContentsForm [noticeBoardNo=" + noticeBoardNo + ", noticeBoardContent=" + noticeBoardContent
				+ ", noticeBoardTitle=" + noticeBoardTitle + ", noticeBoardDate=" + noticeBoardDate
				+ ", noticeBoardHits=" + noticeBoardHits + "]";
	}
		
	
}
