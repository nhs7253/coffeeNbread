package com.cnb.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-07-05
 * 생성자 추가 생성, 
 * 
 * 김형주
 * 2017-06-29 
 * 생성, 초기 구현
 */
public class QnaBoardContents implements Serializable {
	private int qnaBoardNo;		//PRIMARY KEY
	private String qnaStoreId;
	private String qnaBoardWriter;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date qnaBoardDate;
	private int qnaBoardHits;
	private String qnaBoardSecret;
	
	
	public QnaBoardContents() {
	}
	
	
	
	public QnaBoardContents(String qnaStoreId, String qnaBoardWriter, String qnaBoardTitle, String qnaBoardContent,
			Date qnaBoardDate, int qnaBoardHits, String qnaBoardSecret) {
		this.qnaStoreId = qnaStoreId;
		this.qnaBoardWriter = qnaBoardWriter;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardDate = qnaBoardDate;
		this.qnaBoardHits = qnaBoardHits;
		this.qnaBoardSecret = qnaBoardSecret;
	}

	

	public QnaBoardContents(int qnaBoardNo, String qnaStoreId, String qnaBoardWriter, String qnaBoardTitle,
			String qnaBoardContent, Date qnaBoardDate, int qnaBoardHits, String qnaBoardSecret) {
		this.qnaBoardNo = qnaBoardNo;
		this.qnaStoreId = qnaStoreId;
		this.qnaBoardWriter = qnaBoardWriter;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardDate = qnaBoardDate;
		this.qnaBoardHits = qnaBoardHits;
		this.qnaBoardSecret = qnaBoardSecret;
	}



	/**
	 * JSP에서 qnaBoardDateFormat으로 호출 - qnaBoardDate를 지정 포멧으로 반환한다.
	 * @return yyyy-MM-dd형식의 DATE 문자열 - ex - (2017-07-05)
	 */
	public String getQnaBoardDateFormat(){
		return new SimpleDateFormat("yyyy-MM-dd").format(qnaBoardDate);
	}

	

	public int getQnaBoardNo() {
		return qnaBoardNo;
	}



	public void setQnaBoardNo(int qnaBoardNo) {
		this.qnaBoardNo = qnaBoardNo;
	}



	public String getQnaStoreId() {
		return qnaStoreId;
	}



	public void setQnaStoreId(String qnaStoreId) {
		this.qnaStoreId = qnaStoreId;
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



	public int getQnaBoardHits() {
		return qnaBoardHits;
	}



	public void setQnaBoardHits(int qnaBoardHits) {
		this.qnaBoardHits = qnaBoardHits;
	}



	public String getQnaBoardSecret() {
		return qnaBoardSecret;
	}



	public void setQnaBoardSecret(String qnaBoardSecret) {
		this.qnaBoardSecret = qnaBoardSecret;
	}



	@Override
	public String toString() {
		return "QnaBoardContents [qnaBoardNo=" + qnaBoardNo + ", qnaStoreId=" + qnaStoreId + ", qnaBoardWriter="
				+ qnaBoardWriter + ", qnaBoardTitle=" + qnaBoardTitle + ", qnaBoardContent=" + qnaBoardContent
				+ ", qnaBoardDate=" + qnaBoardDate + ", qnaBoardHits=" + qnaBoardHits + ", qnaBoardSecret="
				+ qnaBoardSecret + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qnaBoardContent == null) ? 0 : qnaBoardContent.hashCode());
		result = prime * result + ((qnaBoardDate == null) ? 0 : qnaBoardDate.hashCode());
		result = prime * result + qnaBoardHits;
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
		if (qnaBoardHits != other.qnaBoardHits)
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
