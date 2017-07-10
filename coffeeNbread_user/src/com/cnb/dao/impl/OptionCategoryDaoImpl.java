package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionCategoryDao;
import com.cnb.vo.OptionCategory;

/*
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class OptionCategoryDaoImpl implements OptionCategoryDao{
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.OptionCategoryMapper."+id;
	}
	@Override
	public int insertOptionCategory(OptionCategory optionCategory) {
		return session.insert(makeSqlId("insertOptionCategory"), optionCategory);
	}

	@Override
	public int updateOptionCategory(OptionCategory optionCategory) {
		return session.update(makeSqlId("updateOptionCategory"), optionCategory);
	}

	@Override
	public int deleteOptionCategory(String storeId,int optionId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("optionId", optionId);
		return session.delete(makeSqlId("deleteOptionCategory"), info);
	}
	@Override
	public OptionCategory selectOptionCategoryByName(String storeId, String optionCategory) {
		Map info = new HashMap<>();
		info.put("optionCategory", optionCategory);
		info.put("storeId", storeId);
		return session.selectOne(makeSqlId("selectOptionCategoryByName"),info);
	}
	/*@Override
	public List<OptionCategory> selectOptionDetailListByOptionCategory(String storeId, int optionId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("optionId", optionId);
		
		return session.selectList(makeSqlId("selectOptionDetailListByOptionCategory"),info);
	}*/
	@Override
	public List<OptionCategory> selectOptionCategoryListByStoreId(String storeId) {
		return session.selectList(makeSqlId("selectOptionCategoryListByStoreId"),storeId);
	}
	@Override
	public String selectOptionCategoryByOptionId(int optionId) {
		return session.selectOne(makeSqlId("selectOptionCategoryByOptionId"), optionId);
	}
	@Override
	public int deleteOptionCategoryByStoreId(String storeId) {
		return session.delete(makeSqlId("deleteOptionCategoryByStoreId"), storeId);

	}
	
	
}
