package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * 김형주
 * 2017-07-06
 * 생성, 초기 구현
 */
public class RecipeBoardContentsForm implements Serializable{
	
	@NotNull
	private int recipeBoardNo;
	@NotEmpty
	private String recipeBoardContent;
	@NotEmpty
	private String recipeBoardTitle;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date recipeBoardDate;
	
	private int recipeBoardHits;
    @NotEmpty
	private String recipeBoardPicture;
	private int recommendCount;
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
	
	
	
}
