package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 최민희
 * 2017-06-29 생성
 * 초기 구현
 */
public class QnaBoardContents implements Serializable {
	private int qnaBoardNo;		//PRIMARY KEY
	private String qnaBoardWriter;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qnaBoardDate;
	private String qnaBoardSecret;
	private String qnaStoreId;
	
	public QnaBoardContents() {
	}

	public QnaBoardContents(int qnaBoardNo, String qnaBoardWriter, String qnaBoardTitle, String qnaBoardContent,
			Date qnaBoardDate, String qnaBoardSecret, String qnaStoreId) {
		this.qnaBoardNo = qnaBoardNo;
		this.qnaBoardWriter = qnaBoardWriter;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardDate = qnaBoardDate;
		this.qnaBoardSecret = qnaBoardSecret;
		this.qnaStoreId = qnaStoreId;
	}

	public int getQnaBoardNo() {
		return qnaBoardNo;
	}

	public void setQnaBoardNo(int qnaBoardNo) {
		this.qnaBoardNo = qnaBoardNo;
	}

	public String getQnaBoardWriter() {
		return qnaBoardWriter;
	}

	public void setQnaBoardWriter(String qnaBoardWriter) {
		this.qnaBoardWriter = qnaBoardWriter;
	}

	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}

	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}

	public String getQnaBoardContent() {
		return qnaBoardContent;
	}

	public void setQnaBoardContent(String qnaBoardContent) {
		this.qnaBoardContent = qnaBoardContent;
	}

	public Date getQnaBoardDate() {
		return qnaBoardDate;
	}

	public void setQnaBoardDate(Date qnaBoardDate) {
		this.qnaBoardDate = qnaBoardDate;
	}

	public String getQnaBoardSecret() {
		return qnaBoardSecret;
	}

	public void setQnaBoardSecret(String qnaBoardSecret) {
		this.qnaBoardSecret = qnaBoardSecret;
	}

	public String getQnaStoreId() {
		return qnaStoreId;
	}

	public void setQnaStoreId(String qnaStoreId) {
		this.qnaStoreId = qnaStoreId;
	}

	@Override
	public String toString() {
		return "QnaBoardContents [qnaBoardNo=" + qnaBoardNo + ", qnaBoardWriter=" + qnaBoardWriter + ", qnaBoardTitle="
				+ qnaBoardTitle + ", qnaBoardContent=" + qnaBoardContent + ", qnaBoardDate=" + qnaBoardDate
				+ ", qnaBoardSecret=" + qnaBoardSecret + ", qnaStoreId=" + qnaStoreId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qnaBoardContent == null) ? 0 : qnaBoardContent.hashCode());
		result = prime * result + ((qnaBoardDate == null) ? 0 : qnaBoardDate.hashCode());
		result = prime * result + qnaBoardNo;
		result = prime * result + ((qnaBoardSecret == null) ? 0 : qnaBoardSecret.hashCode());
		result = prime * result + ((qnaBoardTitle == null) ? 0 : qnaBoardTitle.hashCode());
		result = prime * result + ((qnaBoardWriter == null) ? 0 : qnaBoardWriter.hashCode());
		result = prime * result + ((qnaStoreId == null) ? 0 : qnaStoreId.hashCode());
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
		QnaBoardContents other = (QnaBoardContents) obj;
		if (qnaBoardContent == null) {
			if (other.qnaBoardContent != null)
				return false;
		} else if (!qnaBoardContent.equals(other.qnaBoardContent))
			return false;
		if (qnaBoardDate == null) {
			if (other.qnaBoardDate != null)
				return false;
		} else if (!qnaBoardDate.equals(other.qnaBoardDate))
			return false;
		if (qnaBoardNo != other.qnaBoardNo)
			return false;
		if (qnaBoardSecret == null) {
			if (other.qnaBoardSecret != null)
				return false;
		} else if (!qnaBoardSecret.equals(other.qnaBoardSecret))
			return false;
		if (qnaBoardTitle == null) {
			if (other.qnaBoardTitle != null)
				return false;
		} else if (!qnaBoardTitle.equals(other.qnaBoardTitle))
			return false;
		if (qnaBoardWriter == null) {
			if (other.qnaBoardWriter != null)
				return false;
		} else if (!qnaBoardWriter.equals(other.qnaBoardWriter))
			return false;
		if (qnaStoreId == null) {
			if (other.qnaStoreId != null)
				return false;
		} else if (!qnaStoreId.equals(other.qnaStoreId))
			return false;
		return true;
	}
}
