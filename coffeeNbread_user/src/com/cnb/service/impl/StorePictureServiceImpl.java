package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.StorePictureDao;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.service.StorePictureService;
import com.cnb.vo.StorePicture;

@Service
public class StorePictureServiceImpl implements StorePictureService {

	@Autowired
	private StorePictureDao dao;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addStorePicture(StorePicture storePicture) throws DuplicatedStorePictureException {
		List<StorePicture> storePictureList2 = dao.selectStorePictureListByStoreId(storePicture.getStoreId());


		
				dao.insertStorePicture(storePicture);
			
		}/* else {
			for (int i = 0; i < storePictureList.size(); i++) {
				System.out.println("for문 " + storePictureList.get(i).getStorePicture());

				for (int j = 0; j < storePictureList2.size(); j++) {
					if (dao.selectStorePictureByStoreIdAndStorePicture(storePictureList.get(j).getStorePicture(),
							storePictureList.get(j).getStoreId()) != null) {
						throw new DuplicatedStorePictureException(
								storePictureList.get(j).getStorePicture() + "이미 등록되어 있음");
					}
				}
				dao.insertStorePicture(storePictureList.get(i));
			}
		}*/

	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int modifyStorePictureByStorePicture(StorePicture storePictureVO)
			throws StorePictureNotFoundException {
		if(dao.selectStorePictureByStoreIdAndStorePicture(storePictureVO.getStorePicture(), storePictureVO.getStoreId())!=null){
			dao.deleteStorePicture(dao.selectStorePictureByStoreIdAndStorePicture(storePictureVO.getStorePicture(), storePictureVO.getStoreId()));
			return dao.updateStorePictureByStorePicture(storePictureVO);
		}
		return dao.updateStorePictureByStorePicture(storePictureVO);
	}

	@Override
	public int removeStorePicture(StorePicture storePicture) throws StorePictureNotFoundException {

		return dao.deleteStorePicture(storePicture);
	}



	@Override
	public int removeStorePictureById(String storeId) {
		
		return dao.deleteStorePictureById(storeId);
	}

}
