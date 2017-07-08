package com.cnb.validation.annotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/*
 * 김형주
 * 2017-07-06
 * 생성, 초기 구현
 */
public class RecipeBoardContentsForm implements Serializable{
	
	
	private int recipeBoardNo=1;
	@NotEmpty
	private String recipeBoardContent;
	@NotEmpty
	private String recipeBoardTitle;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date recipeBoardDate;
	
	private int recipeBoardHits=0;
    
	private MultipartFile recipeBoardPicture;
	
	private int recommendCount=0;

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

	public MultipartFile getRecipeBoardPicture() {
		return recipeBoardPicture;
	}

	public void setRecipeBoardPicture(MultipartFile recipeBoardPicture) {
		this.recipeBoardPicture = recipeBoardPicture;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	
	
	
}
