package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionDetailDao;
import com.cnb.vo.OptionDetail;

/*
 * 이진영
 * 2017-06-28 생성
 */
@Repository
public class OptionDetailDaoImpl implements OptionDetailDao{

	
	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.OptionDetailMapper."+id;
	}
	@Override
	public int insertOptionDetail(OptionDetail optionDetail) {
		return session.insert(makeSqlId("insertOptionDetail"), optionDetail);
	}

	@Override
	public int updateOptionDetail(OptionDetail optionDetail) {
		return session.update(makeSqlId("updateOptionDetail"), optionDetail);

	}

	@Override
	public int deleteOptionDetail(String storeId, int optionId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("optionId", optionId);

		return session.delete(makeSqlId("deleteOptionDetail"), info);

	}

	@Override
	public List<OptionDetail> selectOptionDetailListByOptionCategory(String storeId, int optionId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("optionId", optionId);

		return session.selectList(makeSqlId("selectOptionDetailListByOptionCategory"), info);
	}

	@Override
	public OptionDetail selectOptionDetailByOptionDetailName(String storeId, int optionId,
			String optionCategoryDetail) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("optionId", optionId);
		info.put("optionCategoryDetail", optionCategoryDetail);
		return session.selectOne(makeSqlId("selectOptionDetailByOptionDetailName"), info);
	}

	@Override
	public OptionDetail selectOptionDetailByProductId(String storeId, String productId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.selectOne(makeSqlId("selectOptionDetailByProductId"), info);
	}

	@Override
	public int deleteOptionDetailByProductId(String storeId, String productId) {
		Map info = new HashMap<>();
		info.put("storeId", storeId);
		info.put("productId", productId);
		return session.delete(makeSqlId("deleteOptionDetailByProductId"),info);
	}

}
