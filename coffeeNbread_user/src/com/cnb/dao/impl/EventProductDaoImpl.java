package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.EventProductDao;
import com.cnb.vo.EventProduct;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
@Repository
public class EventProductDaoImpl implements EventProductDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.EventProductMapper."+id;
	}

	@Override
	public int insertEventProduct(EventProduct eventProduct) {
		return session.insert(makeSqlId("insertEventProduct"), eventProduct);
	}

	@Override
	public int updateEventProduct(EventProduct eventProductAfter, EventProduct eventProductBefore) {
		Map<String, Object> info = new HashMap<>();
		info.put("beforeProductId", eventProductBefore.getProductId());
		info.put("beforeStoreId", eventProductBefore.getStoreId());
		info.put("beforeEventNo", eventProductBefore.getEventNo());
		info.put("afterProductId", eventProductAfter.getProductId());
		info.put("afterStoreId", eventProductAfter.getStoreId());
		info.put("afterEventNo", eventProductAfter.getEventNo());
		return session.update(makeSqlId("updateEventProduct"), info);
	}

	@Override
	public int deleteEventProduct(EventProduct eventProduct) {
		return session.delete(makeSqlId("deleteEventProduct"), eventProduct);
	}

	@Override
	public List<EventProduct> selectEventProductListByEventNo(int eventNo) {
		return session.selectList(makeSqlId("selectEventProductListByEventNo"), eventNo);
	}
	
}
