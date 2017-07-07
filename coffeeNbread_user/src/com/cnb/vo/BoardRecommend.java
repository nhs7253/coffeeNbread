package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 김형주
 * 2017-07-06 수정
 * 생성.
 * 
 * 
 * 김형주
 * 2017-07-03 생성
 * 초기 구현
 */
public class BoardRecommend implements Serializable {

	private String userId; // FOREIGN KEY , PRIMARY KEY
	private int recipeBoardNo;// FOREIGN KEY, PRIMARY KEY

	private RecipeBoardContents recipeBoardContents;
	private GeneralUser generalUser;
	
	
	
	
	
	
	
	
	
	
	
	 /* 매장별 추천수 작업때문에 만들어둔 생성자 */
	
/*	public BoardRecommend(String userId, int recipeBoardNo, RecipeBoardContents recipeBoardContents,
			GeneralUser generalUser) {
		super();
		this.userId = userId;
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContents = recipeBoardContents;
		this.generalUser = generalUser;
	}*/
	public BoardRecommend(String userId, int recipeBoardNo, RecipeBoardContents recipeBoardContents) {
		super();
		this.userId = userId;
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContents = recipeBoardContents;
	}
	public BoardRecommend(String userId, int recipeBoardNo) {
		super();
		this.userId = userId;
		this.recipeBoardNo = recipeBoardNo;
	}
	public BoardRecommend() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "BoardRecommend [userId=" + userId + ", recipeBoardNo=" + recipeBoardNo + ", recipeBoardContents="
				+ recipeBoardContents + ", generalUser=" + generalUser + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generalUser == null) ? 0 : generalUser.hashCode());
		result = prime * result + ((recipeBoardContents == null) ? 0 : recipeBoardContents.hashCode());
		result = prime * result + recipeBoardNo;
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
		BoardRecommend other = (BoardRecommend) obj;
		if (generalUser == null) {
			if (other.generalUser != null)
				return false;
		} else if (!generalUser.equals(other.generalUser))
			return false;
		if (recipeBoardContents == null) {
			if (other.recipeBoardContents != null)
				return false;
		} else if (!recipeBoardContents.equals(other.recipeBoardContents))
			return false;
		if (recipeBoardNo != other.recipeBoardNo)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRecipeBoardNo() {
		return recipeBoardNo;
	}
	public void setRecipeBoardNo(int recipeBoardNo) {
		this.recipeBoardNo = recipeBoardNo;
	}
	public RecipeBoardContents getRecipeBoardContents() {
		return recipeBoardContents;
	}
	public void setRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		this.recipeBoardContents = recipeBoardContents;
	}
	public GeneralUser getGeneralUser() {
		return generalUser;
	}
	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}
	


}
