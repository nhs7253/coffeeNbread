package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 최민희
 * 2017-06-28 생성
 * 초기 구현
 */
public class NoticeBoardContents implements Serializable {
	private int noticeBoardNo;		//PRIMARY KEY
	private String noticeBoardContent;
	private String noticeBoardTitle;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date noticeBoardDate;
	private int noticeBoardHits;
		
	public NoticeBoardContents() {
		super();
	}

	public NoticeBoardContents(int noticeBoardNo, String noticeBoardContent, String noticeBoardTitle,
			Date noticeBoardDate, int noticeBoardHits) {
		super();
		this.noticeBoardNo = noticeBoardNo;
		this.noticeBoardContent = noticeBoardContent;
		this.noticeBoardTitle = noticeBoardTitle;
		this.noticeBoardDate = noticeBoardDate;
		this.noticeBoardHits = noticeBoardHits;
	}

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
		return "NoticeBoardContents [noticeBoardNo=" + noticeBoardNo + ", noticeBoardContent=" + noticeBoardContent
				+ ", noticeBoardTitle=" + noticeBoardTitle + ", noticeBoardDate=" + noticeBoardDate
				+ ", noticeBoardHits=" + noticeBoardHits + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noticeBoardContent == null) ? 0 : noticeBoardContent.hashCode());
		result = prime * result + ((noticeBoardDate == null) ? 0 : noticeBoardDate.hashCode());
		result = prime * result + noticeBoardHits;
		result = prime * result + noticeBoardNo;
		result = prime * result + ((noticeBoardTitle == null) ? 0 : noticeBoardTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeBoardContents other = (NoticeBoardContents) obj;
		if (noticeBoardContent == null) {
			if (other.noticeBoardContent != null)
				return false;
		} else if (!noticeBoardContent.equals(other.noticeBoardContent))
			return false;
		if (noticeBoardDate == null) {
			if (other.noticeBoardDate != null)
				return false;
		} else if (!noticeBoardDate.equals(other.noticeBoardDate))
			return false;
		if (noticeBoardHits != other.noticeBoardHits)
			return false;
		if (noticeBoardNo != other.noticeBoardNo)
			return false;
		if (noticeBoardTitle == null) {
			if (other.noticeBoardTitle != null)
				return false;
		} else if (!noticeBoardTitle.equals(other.noticeBoardTitle))
			return false;
		return true;
	}
}
