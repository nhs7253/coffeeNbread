package com.cnb.vo;

import java.io.Serializable;
/*
* 김형주
* 2017-06-28 생성
* 초기 구현
*/
public class BookMarkCardNum implements Serializable{

	
	private String cardNum; //PRIMARY KEY
	private String userId; //PRIMARY KEY, FOREIGN KEY
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BookMarkCardNum() {
		super();
	}
	
	public BookMarkCardNum(String cardNum, String userId) {
		super();
		this.cardNum = cardNum;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BookMarkCardNum [cardNum=" + cardNum + ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNum == null) ? 0 : cardNum.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		BookMarkCardNum other = (BookMarkCardNum) obj;
		if (cardNum == null) {
			if (other.cardNum != null)
				return false;
		} else if (!cardNum.equals(other.cardNum))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	
}