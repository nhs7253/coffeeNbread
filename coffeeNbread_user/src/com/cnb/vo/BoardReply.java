package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
/*
 * 김형주 
 * 2017-07-03  
 * 초기생성.
 * 
 */
public class BoardReply implements Serializable {

	
	private int replyNo;
	private int replyContent;
	private String replyName;
	private Date replyRegDate;

	private String storeId;
	
	private int quaBoardNo; //ForeignKey
	private int recipeBoardNo;//ForeignKey
	
	private QnaBoardContents qnaBoardContents; //조인 위한 QNA게시글 
	
	private  RecipeBoardContents recipeBoardContents; //조인 위한 레시피 게시글 

	public BoardReply(int replyNo, int replyContent, String replyName, Date replyRegDate, String storeId,
			int quaBoardNo, int recipeBoardNo, QnaBoardContents qnaBoardContents,
			RecipeBoardContents recipeBoardContents) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyName = replyName;
		this.replyRegDate = replyRegDate;
		this.storeId = storeId;
		this.quaBoardNo = quaBoardNo;
		this.recipeBoardNo = recipeBoardNo;
		this.qnaBoardContents = qnaBoardContents;
		this.recipeBoardContents = recipeBoardContents;
	}

	public BoardReply() {
		super();
	}

	@Override
	public String toString() {
		return "BoardReply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyName=" + replyName
				+ ", replyRegDate=" + replyRegDate + ", storeId=" + storeId + ", quaBoardNo=" + quaBoardNo
				+ ", recipeBoardNo=" + recipeBoardNo + ", qnaBoardContents=" + qnaBoardContents
				+ ", recipeBoardContents=" + recipeBoardContents + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qnaBoardContents == null) ? 0 : qnaBoardContents.hashCode());
		result = prime * result + quaBoardNo;
		result = prime * result + ((recipeBoardContents == null) ? 0 : recipeBoardContents.hashCode());
		result = prime * result + recipeBoardNo;
		result = prime * result + replyContent;
		result = prime * result + ((replyName == null) ? 0 : replyName.hashCode());
		result = prime * result + replyNo;
		result = prime * result + ((replyRegDate == null) ? 0 : replyRegDate.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		if (quaBoardNo != other.quaBoardNo)
			return false;
		if (recipeBoardContents == null) {
			if (other.recipeBoardContents != null)
				return false;
		} else if (!recipeBoardContents.equals(other.recipeBoardContents))
			return false;
		if (recipeBoardNo != other.recipeBoardNo)
			return false;
		if (replyContent != other.replyContent)
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
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(int replyContent) {
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

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public int getQuaBoardNo() {
		return quaBoardNo;
	}

	public void setQuaBoardNo(int quaBoardNo) {
		this.quaBoardNo = quaBoardNo;
	}

	public int getRecipeBoardNo() {
		return recipeBoardNo;
	}

	public void setRecipeBoardNo(int recipeBoardNo) {
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
	
	
	
	
}