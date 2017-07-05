package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 김형주
 * 2017- 07-03 생성
 * 초기 생성.
 */

public class RecipeBoardContents implements Serializable {

	private int recipeBoardNo;
	private String recipeBoardContent;
	private String recipeBoardTitle;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date recipeBoardDate;
	private int recipeBoardHits;
	private String recipeBoardPicture;
	private int recommendCount;

	private String userId; //FOREIGN KEY
	private String storeId;// FOREIGN KEY

	private GeneralUser generalUser; //조인 위한 참조객체
	private Store store; //조인 위한 참조객체.
	
	
	
	
	
	
	
	
	
	
	
	
	 public RecipeBoardContents(int recipeBoardNo, String recipeBoardContent, String recipeBoardTitle,
			Date recipeBoardDate, int recipeBoardHits, String recipeBoardPicture, int recommendCount, String userId,
			String storeId) {
		super();
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContent = recipeBoardContent;
		this.recipeBoardTitle = recipeBoardTitle;
		this.recipeBoardDate = recipeBoardDate;
		this.recipeBoardHits = recipeBoardHits;
		this.recipeBoardPicture = recipeBoardPicture;
		this.recommendCount = recommendCount;
		this.userId = userId;
		this.storeId = storeId;
	}


	/* 레시피 게시판에 넣을 생성자   - store을 가져와서 store_name을 찍을것임.*/
	public RecipeBoardContents(int recipeBoardNo, String recipeBoardContent, String recipeBoardTitle,
			Date recipeBoardDate, int recipeBoardHits, String recipeBoardPicture, int recommendCount, String userId,
			Store store) {
		super();
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContent = recipeBoardContent;
		this.recipeBoardTitle = recipeBoardTitle;
		this.recipeBoardDate = recipeBoardDate;
		this.recipeBoardHits = recipeBoardHits;
		this.recipeBoardPicture = recipeBoardPicture;
		this.recommendCount = recommendCount;
		this.userId = userId;
		this.store = store;
	}
	
	
	    /*  조회수와 추천수 빼고 남은 생성자 -  update할떄 조회수와 추천수는 고정이므로 */
	public RecipeBoardContents(int recipeBoardNo, String recipeBoardContent, String recipeBoardTitle,
			Date recipeBoardDate, int recipeBoardHits, String recipeBoardPicture, int recommendCount) {
		super();
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContent = recipeBoardContent;
		this.recipeBoardTitle = recipeBoardTitle;
		this.recipeBoardDate = recipeBoardDate;
		this.recipeBoardHits = recipeBoardHits;
		this.recipeBoardPicture = recipeBoardPicture;
		this.recommendCount = recommendCount;
	}
	
		/* 조인 합친 생성자 */
	public RecipeBoardContents(int recipeBoardNo, String recipeBoardContent, String recipeBoardTitle,
			Date recipeBoardDate, int recipeBoardHits, String recipeBoardPicture, int recommendCount, String userId,
			String storeId, GeneralUser generalUser, Store store) {
		super();
		this.recipeBoardNo = recipeBoardNo;
		this.recipeBoardContent = recipeBoardContent;
		this.recipeBoardTitle = recipeBoardTitle;
		this.recipeBoardDate = recipeBoardDate;
		this.recipeBoardHits = recipeBoardHits;
		this.recipeBoardPicture = recipeBoardPicture;
		this.recommendCount = recommendCount;
		this.userId = userId;
		this.storeId = storeId;
		this.generalUser = generalUser;
		this.store = store;
	}
	public RecipeBoardContents() {
		super();
	}
	@Override
	public String toString() {
		return "RecipeBoardContents [recipeBoardNo=" + recipeBoardNo + ", recipeBoardContent=" + recipeBoardContent
				+ ", recipeBoardTitle=" + recipeBoardTitle + ", recipeBoardDate=" + recipeBoardDate
				+ ", recipeBoardHits=" + recipeBoardHits + ", recipeBoardPicture=" + recipeBoardPicture
				+ ", recommendCount=" + recommendCount + ", userId=" + userId + ", storeId=" + storeId
				+ ", generalUser=" + generalUser + ", store=" + store + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generalUser == null) ? 0 : generalUser.hashCode());
		result = prime * result + ((recipeBoardContent == null) ? 0 : recipeBoardContent.hashCode());
		result = prime * result + ((recipeBoardDate == null) ? 0 : recipeBoardDate.hashCode());
		result = prime * result + recipeBoardHits;
		result = prime * result + recipeBoardNo;
		result = prime * result + ((recipeBoardPicture == null) ? 0 : recipeBoardPicture.hashCode());
		result = prime * result + ((recipeBoardTitle == null) ? 0 : recipeBoardTitle.hashCode());
		result = prime * result + recommendCount;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		RecipeBoardContents other = (RecipeBoardContents) obj;
		if (generalUser == null) {
			if (other.generalUser != null)
				return false;
		} else if (!generalUser.equals(other.generalUser))
			return false;
		if (recipeBoardContent == null) {
			if (other.recipeBoardContent != null)
				return false;
		} else if (!recipeBoardContent.equals(other.recipeBoardContent))
			return false;
		if (recipeBoardDate == null) {
			if (other.recipeBoardDate != null)
				return false;
		} else if (!recipeBoardDate.equals(other.recipeBoardDate))
			return false;
		if (recipeBoardHits != other.recipeBoardHits)
			return false;
		if (recipeBoardNo != other.recipeBoardNo)
			return false;
		if (recipeBoardPicture == null) {
			if (other.recipeBoardPicture != null)
				return false;
		} else if (!recipeBoardPicture.equals(other.recipeBoardPicture))
			return false;
		if (recipeBoardTitle == null) {
			if (other.recipeBoardTitle != null)
				return false;
		} else if (!recipeBoardTitle.equals(other.recipeBoardTitle))
			return false;
		if (recommendCount != other.recommendCount)
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public int getRecipeBoardNo() {
		return recipeBoardNo;
	}
	public void setRecipeBoardNo(int recipeBoardNo) {
		this.recipeBoardNo = recipeBoardNo;
	}
	public String getRecipeBoardContent() {
		return recipeBoardContent;
	}
	public void setRecipeBoardContent(String recipeBoardContent) {
		this.recipeBoardContent = recipeBoardContent;
	}
	public String getRecipeBoardTitle() {
		return recipeBoardTitle;
	}
	public void setRecipeBoardTitle(String recipeBoardTitle) {
		this.recipeBoardTitle = recipeBoardTitle;
	}
	public Date getRecipeBoardDate() {
		return recipeBoardDate;
	}
	public void setRecipeBoardDate(Date recipeBoardDate) {
		this.recipeBoardDate = recipeBoardDate;
	}
	public int getRecipeBoardHits() {
		return recipeBoardHits;
	}
	public void setRecipeBoardHits(int recipeBoardHits) {
		this.recipeBoardHits = recipeBoardHits;
	}
	public String getRecipeBoardPicture() {
		return recipeBoardPicture;
	}
	public void setRecipeBoardPicture(String recipeBoardPicture) {
		this.recipeBoardPicture = recipeBoardPicture;
	}
	public int getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public GeneralUser getGeneralUser() {
		return generalUser;
	}
	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}

	
	
	
	
	
	
	
	
	
	
}