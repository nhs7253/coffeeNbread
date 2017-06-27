package com.cnb.vo;

import java.io.Serializable;
import java.util.Date;
/*
* 이진영
* 2017-06-27 생성
* 초기 구현
*/
public class StoreEvent implements Serializable{
	private int eventNo;
	private String eventTitle;
	private Date eventStartDate;
	private Date eventEndDate;
	private String eventOption;
	private String eventDetails;
	private String saleOption;
	private int saleRate;
	private String eventPicture;
	private String newMenuOption;
	private String eventCheck;
	
	/***************************************************
	 * 부모테이블 : Store  자식 테이블 : StoreEvent
	 * 매장이벤트 하나는 하나의 매장을 가짐
	 * 매장이벤트에서 어떤 매장을 참조하고있는지 저장할 인스턴수 변수 선언 
	 ***************************************************/
	private String storeId;
	private Store store;
	
	
	public StoreEvent() {
		super();
	}


	public StoreEvent(int eventNo, String eventTitle, Date eventStartDate, Date eventEndDate, String eventOption,
			String eventDetails, String saleOption, int saleRate, String eventPicture, String newMenuOption,
			String eventCheck, String storeId, Store store) {
		super();
		this.eventNo = eventNo;
		this.eventTitle = eventTitle;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventOption = eventOption;
		this.eventDetails = eventDetails;
		this.saleOption = saleOption;
		this.saleRate = saleRate;
		this.eventPicture = eventPicture;
		this.newMenuOption = newMenuOption;
		this.eventCheck = eventCheck;
		this.storeId = storeId;
		this.store = store;
	}


	public int getEventNo() {
		return eventNo;
	}


	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}


	public String getEventTitle() {
		return eventTitle;
	}


	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}


	public Date getEventStartDate() {
		return eventStartDate;
	}


	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}


	public Date getEventEndDate() {
		return eventEndDate;
	}


	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}


	public String getEventOption() {
		return eventOption;
	}


	public void setEventOption(String eventOption) {
		this.eventOption = eventOption;
	}


	public String getEventDetails() {
		return eventDetails;
	}


	public void setEventDetails(String eventDetails) {
		this.eventDetails = eventDetails;
	}


	public String getSaleOption() {
		return saleOption;
	}


	public void setSaleOption(String saleOption) {
		this.saleOption = saleOption;
	}


	public int getSaleRate() {
		return saleRate;
	}


	public void setSaleRate(int saleRate) {
		this.saleRate = saleRate;
	}


	public String getEventPicture() {
		return eventPicture;
	}


	public void setEventPicture(String eventPicture) {
		this.eventPicture = eventPicture;
	}


	public String getNewMenuOption() {
		return newMenuOption;
	}


	public void setNewMenuOption(String newMenuOption) {
		this.newMenuOption = newMenuOption;
	}


	public String getEventCheck() {
		return eventCheck;
	}


	public void setEventCheck(String eventCheck) {
		this.eventCheck = eventCheck;
	}


	public String getStoreId() {
		return storeId;
	}


	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	@Override
	public String toString() {
		return "StoreEvent [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventStartDate=" + eventStartDate
				+ ", eventEndDate=" + eventEndDate + ", eventOption=" + eventOption + ", eventDetails=" + eventDetails
				+ ", saleOption=" + saleOption + ", saleRate=" + saleRate + ", eventPicture=" + eventPicture
				+ ", newMenuOption=" + newMenuOption + ", eventCheck=" + eventCheck + ", storeId=" + storeId
				+ ", store=" + store + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventCheck == null) ? 0 : eventCheck.hashCode());
		result = prime * result + ((eventDetails == null) ? 0 : eventDetails.hashCode());
		result = prime * result + ((eventEndDate == null) ? 0 : eventEndDate.hashCode());
		result = prime * result + eventNo;
		result = prime * result + ((eventOption == null) ? 0 : eventOption.hashCode());
		result = prime * result + ((eventPicture == null) ? 0 : eventPicture.hashCode());
		result = prime * result + ((eventStartDate == null) ? 0 : eventStartDate.hashCode());
		result = prime * result + ((eventTitle == null) ? 0 : eventTitle.hashCode());
		result = prime * result + ((newMenuOption == null) ? 0 : newMenuOption.hashCode());
		result = prime * result + ((saleOption == null) ? 0 : saleOption.hashCode());
		result = prime * result + saleRate;
		result = prime * result + ((store == null) ? 0 : store.hashCode());
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
		StoreEvent other = (StoreEvent) obj;
		if (eventCheck == null) {
			if (other.eventCheck != null)
				return false;
		} else if (!eventCheck.equals(other.eventCheck))
			return false;
		if (eventDetails == null) {
			if (other.eventDetails != null)
				return false;
		} else if (!eventDetails.equals(other.eventDetails))
			return false;
		if (eventEndDate == null) {
			if (other.eventEndDate != null)
				return false;
		} else if (!eventEndDate.equals(other.eventEndDate))
			return false;
		if (eventNo != other.eventNo)
			return false;
		if (eventOption == null) {
			if (other.eventOption != null)
				return false;
		} else if (!eventOption.equals(other.eventOption))
			return false;
		if (eventPicture == null) {
			if (other.eventPicture != null)
				return false;
		} else if (!eventPicture.equals(other.eventPicture))
			return false;
		if (eventStartDate == null) {
			if (other.eventStartDate != null)
				return false;
		} else if (!eventStartDate.equals(other.eventStartDate))
			return false;
		if (eventTitle == null) {
			if (other.eventTitle != null)
				return false;
		} else if (!eventTitle.equals(other.eventTitle))
			return false;
		if (newMenuOption == null) {
			if (other.newMenuOption != null)
				return false;
		} else if (!newMenuOption.equals(other.newMenuOption))
			return false;
		if (saleOption == null) {
			if (other.saleOption != null)
				return false;
		} else if (!saleOption.equals(other.saleOption))
			return false;
		if (saleRate != other.saleRate)
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
		return true;
	}
	
	

}
