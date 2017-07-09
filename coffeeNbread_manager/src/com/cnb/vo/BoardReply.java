package com.cnb.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 노현식
 * 2017-07-08
 * 레시피 게시판 댓글 달기 용 생성자2 추가
 * 
 * 노현식
 * 2017-07-06
 * getReplyRegDateFormat()
 * 
 * 김형주 
 * 2017-07-03  
 * 초기생성.
 * 
 */
public class BoardReply implements Serializable {

	private int replyNo;
	private String replyContent;
	private String replyName;
	private Date replyRegDate;

	
	private Integer qnaBoardNo; //ForeignKey
	private Integer recipeBoardNo;//ForeignKey
	
	private QnaBoardContents qnaBoardContents; //조인 위한 QNA게시글 
	
	private  RecipeBoardContents recipeBoardContents; //조인 위한 레시피 게시글 

	
	/* 레시피 게시판 댓글 달기 용 생성자2 */
	public BoardReply(String replyContent, String replyName, Date replyRegDate, Integer qnaBoardNo) {
		this.replyContent = replyContent;
		this.replyName = replyName;
		this.replyRegDate = replyRegDate;
		this.qnaBoardNo = qnaBoardNo;
	}



	/* 레시피 게시판 댓글 달기 용 생성아 */
	public BoardReply(int replyNo, String replyContent, String replyName, Date replyRegDate, Integer recipeBoardNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyName = replyName;
		this.replyRegDate = replyRegDate;
		this.recipeBoardNo = recipeBoardNo;
	}

	
	
	/* qna 게시판 댓글달기 생성자 */
	public BoardReply(int replyNo, String replyContent, String replyName,Integer qnaBoardNo, Date replyRegDate) {
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyName = replyName;
		this.replyRegDate = replyRegDate;
		this.qnaBoardNo = qnaBoardNo;
	}

	public BoardReply() {
		super();
	}



	public BoardReply(int replyNo, String replyContent, String replyName, Date replyRegDate, Integer qnaBoardNo,
			Integer recipeBoardNo, QnaBoardContents qnaBoardContents, RecipeBoardContents recipeBoardContents) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyName = replyName;
		this.replyRegDate = replyRegDate;
		this.qnaBoardNo = qnaBoardNo;
		this.recipeBoardNo = recipeBoardNo;
		this.qnaBoardContents = qnaBoardContents;
		this.recipeBoardContents = recipeBoardContents;
	}



	@Override
	public String toString() {
		return "BoardReply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyName=" + replyName
				+ ", replyRegDate=" + replyRegDate + ", qnaBoardNo=" + qnaBoardNo + ", recipeBoardNo=" + recipeBoardNo
				+ ", qnaBoardContents=" + qnaBoardContents + ", recipeBoardContents=" + recipeBoardContents + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qnaBoardContents == null) ? 0 : qnaBoardContents.hashCode());
		result = prime * result + ((qnaBoardNo == null) ? 0 : qnaBoardNo.hashCode());
		result = prime * result + ((recipeBoardContents == null) ? 0 : recipeBoardContents.hashCode());
		result = prime * result + ((recipeBoardNo == null) ? 0 : recipeBoardNo.hashCode());
		result = prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + ((replyName == null) ? 0 : replyName.hashCode());
		result = prime * result + replyNo;
		result = prime * result + ((replyRegDate == null) ? 0 : replyRegDate.hashCode());
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
		BoardReply other = (BoardReply) obj;
		if (qnaBoardContents == null) {
			if (other.qnaBoardContents != null)
				return false;
		} else if (!qnaBoardContents.equals(other.qnaBoardContents))
			return false;
		if (qnaBoardNo == null) {
			if (other.qnaBoardNo != null)
				return false;
		} else if (!qnaBoardNo.equals(other.qnaBoardNo))
			return false;
		if (recipeBoardContents == null) {
			if (other.recipeBoardContents != null)
				return false;
		} else if (!recipeBoardContents.equals(other.recipeBoardContents))
			return false;
		if (recipeBoardNo == null) {
			if (other.recipeBoardNo != null)
				return false;
		} else if (!recipeBoardNo.equals(other.recipeBoardNo))
			return false;
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (replyName == null) {
			if (other.replyName != null)
				return false;
		} else if (!replyName.equals(other.replyName))
			return false;
		if (replyNo != other.replyNo)
			return false;
		if (replyRegDate == null) {
			if (other.replyRegDate != null)
				return false;
		} else if (!replyRegDate.equals(other.replyRegDate))
			return false;
		return true;
	}



	public int getReplyNo() {
		return replyNo;
	}



	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}



	public String getReplyContent() {
		return replyContent;
	}



	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}



	public String getReplyName() {
		return replyName;
	}



	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}



	public Date getReplyRegDate() {
		return replyRegDate;
	}



	public void setReplyRegDate(Date replyRegDate) {
		this.replyRegDate = replyRegDate;
	}



	public Integer getQnaBoardNo() {
		return qnaBoardNo;
	}



	public void setQnaBoardNo(Integer qnaBoardNo) {
		this.qnaBoardNo = qnaBoardNo;
	}



	public Integer getRecipeBoardNo() {
		return recipeBoardNo;
	}



	public void setRecipeBoardNo(Integer recipeBoardNo) {
		this.recipeBoardNo = recipeBoardNo;
	}



	public QnaBoardContents getQnaBoardContents() {
		return qnaBoardContents;
	}



	public void setQnaBoardContents(QnaBoardContents qnaBoardContents) {
		this.qnaBoardContents = qnaBoardContents;
	}



	public RecipeBoardContents getRecipeBoardContents() {
		return recipeBoardContents;
	}



	public void setRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		this.recipeBoardContents = recipeBoardContents;
	}



	/**
	 * sec:authentication를 통해 JSP에서 yyyy-MM-dd형식으로 DATE 타입을 문자열로 출력
	 * <sec:authentication property="principal.userName"/>
	 * 처럼 getReplyRegDateFormat -> replyRegDateFormat 호출 됨(get을 제외한 맨 앞글자 소문자 - is도 가능)
	 * @return new SimpleDateFormat("yyyy-MM-dd").format(replyRegDate);
	 */
	public String getReplyRegDateFormat(){
		return new SimpleDateFormat("yyyy-MM-dd").format(replyRegDate);
	}
	
  
	
	
	
}