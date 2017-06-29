package com.cnb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cnb.dao.StorePictureDao;
import com.cnb.vo.StorePicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
@Repository
public class StorePictureDaoImpl implements StorePictureDao {

	@Autowired
	private SqlSessionTemplate session;
	
	private String makeSqlId(String id){
		return "com.cnb.config.mybatis.mapper.StorePictureMapper."+id;
	}
	
	@Override
	public int insertStorePicture(StorePicture storePicture) {
		return session.insert(makeSqlId("insertStorePicture"), storePicture);
	}

	@Override
	public int updateStorePictureByStorePicture(StorePicture storePictureVO, String storePicture) {
		Map<String, String> info = new HashMap<>();
		info.put("storePictureByVO", storePictureVO.getStorePicture());
		info.put("storeIdByVO", storePictureVO.getStoreId());
		info.put("storePicture", storePicture);
		return session.update(makeSqlId("updateStorePictureByStorePicture"), info);
	}

	@Override
	public int deleteStorePicture(StorePicture storePicture) {
		return session.delete(makeSqlId("deleteStorePicture"), storePicture);
	}

	@Override
	public List<StorePicture> selectStorePictureListByStoreId(String storeId) {
		return session.selectList(makeSqlId("selectStorePictureListByStoreId"), storeId);
	}

}
