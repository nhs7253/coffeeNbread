package com.cnb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StorePictureDao;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.service.StorePictureService;
import com.cnb.vo.StorePicture;

@Service
public class StorePictureServiceImpl implements StorePictureService{

	@Autowired
	private StorePictureDao dao;
	
	
	@Override
	public int addStorePicture(StorePicture storePicture) throws DuplicatedStorePictureException {           
		if((dao.selectStorePictureByStoreIdAndStorePicture(storePicture.getStorePicture(),storePicture.getStoreId())) !=null){
			throw new DuplicatedStorePictureException(storePicture.getStorePicture()+"이미 등록되어 있음");
		}
		return dao.insertStorePicture(storePicture);
	}

	@Override
	
	public int modifyStorePictureByStorePicture(StorePicture storePictureVO, String storePicture)
			throws StorePictureNotFoundException {
		if(dao.selectStorePictureByStoreIdAndStorePicture(storePicture, storePictureVO.getStoreId())==null){
			throw new StorePictureNotFoundException(storePicture+"등록되어 있지 않음");
		}
		return dao.updateStorePictureByStorePicture(storePictureVO, storePicture);
	}

	@Override
	public int removeStorePicture(StorePicture storePicture) throws StorePictureNotFoundException {
		
		return dao.deleteStorePicture(storePicture);
	}

}
