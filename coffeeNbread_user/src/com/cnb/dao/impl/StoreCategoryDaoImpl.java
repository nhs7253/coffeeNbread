package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StoreCategoryDao;
import com.cnb.vo.StoreCategory;

/*이진영
 * 2017-07-03 수정
 * 
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class StoreCategoryDaoImpl implements StoreCategoryDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StoreCategoryMapper."+id;
	}
	@Override
	public int insertStoreCategory(StoreCategory storeCategory) {
		return session.insert(makeSqlId("insertStoreCategory"),storeCategory);
		
	}

	@Override
	public int updateStoreCategory(StoreCategory storeCategoryNo) {
		
		return session.update(makeSqlId("updateStoreCategory"),storeCategoryNo);
		
	}

	@Override
	public int deleteStoreCategoryByNo(String storeId,int storeCategoryNo) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("storeCategoryNo", storeCategoryNo);
		
		return session.delete(makeSqlId("deleteStoreCategoryByNo"), info);
	}

	@Override
	public StoreCategory selectStoreCategoryByName(String storeId, String storeCategory) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("storeCategory", storeCategory);
		return session.selectOne(makeSqlId("selectStoreCategoryByName"), info);
	}
	@Override
	public List<StoreCategory> selectStoreCategoryListByStoreId(String storeId) {


		return session.selectList(makeSqlId("selectStoreCategoryListByStoreId"), storeId);
	
	}
}
