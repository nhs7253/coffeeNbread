package com.cnb.vo;

import java.io.Serializable;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기구현
 */
public class StorePosition implements Serializable{
	
	private String storeId; //PRIMARY KEY
	private String X;
	private String Y;
	
	private Store store;
	
	public StorePosition() {
	}

	public StorePosition(String storeId, String x, String y) {
		this.storeId = storeId;
		X = x;
		Y = y;
	}

	public StorePosition(String storeId, String x, String y, Store store) {
		this.storeId = storeId;
		X = x;
		Y = y;
		this.store = store;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((X == null) ? 0 : X.hashCode());
		result = prime * result + ((Y == null) ? 0 : Y.hashCode());
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
		StorePosition other = (StorePosition) obj;
		if (X == null) {
			if (other.X != null)
				return false;
		} else if (!X.equals(other.X))
			return false;
		if (Y == null) {
			if (other.Y != null)
				return false;
		} else if (!Y.equals(other.Y))
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

	@Override
	public String toString() {
		return "StorePosition [storeId=" + storeId + ", X=" + X + ", Y=" + Y + ", store=" + store + "]";
	}
}
