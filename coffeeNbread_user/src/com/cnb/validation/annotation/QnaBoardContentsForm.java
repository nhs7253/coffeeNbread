package com.cnb.validation.annotation;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * 노현식
 * 2017-07-06
 * 생성, 초기 구현
 */
public class QnaBoardContentsForm{
	
	@NotNull
	private int qnaBoardNo;		//PRIMARY KEY
	private String qnaStoreId = null;;

	private String qnaBoardWriter;
	@NotEmpty
	private String qnaBoardTitle;
	@NotEmpty
	private String qnaBoardContent;
	@DateTimeFormat(pattern="yyyy-MM-dd")

	private Date qnaBoardDate;
	private int qnaBoardHits;
	@NotEmpty
	private String qnaBoardSecret="N";
	
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
		if(qnaStoreId == null || qnaStoreId.trim().isEmpty()){
			this.qnaStoreId = null;
		}
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
		return "QnaBoardContentsForm [qnaBoardNo=" + qnaBoardNo + ", qnaStoreId=" + qnaStoreId + ", qnaBoardWriter="
				+ qnaBoardWriter + ", qnaBoardTitle=" + qnaBoardTitle + ", qnaBoardContent=" + qnaBoardContent
				+ ", qnaBoardDate=" + qnaBoardDate + ", qnaBoardHits=" + qnaBoardHits + ", qnaBoardSecret="
				+ qnaBoardSecret + "]";
	}
	
	
}
