package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void addStorePicture(List<StorePicture> storePictureList) throws DuplicatedStorePictureException {
		List<StorePicture> storePictureList2 = dao.selectStorePictureListByStoreId(storePictureList.get(0).getStoreId());


		if (storePictureList2.size() == 0) {
			for (int i = 0; i < storePictureList.size(); i++) {
				dao.insertStorePicture(storePictureList.get(i));
			}
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

	}

	@Override

	public int modifyStorePictureByStorePicture(StorePicture storePictureVO, String storePicture)
			throws StorePictureNotFoundException {
		if (dao.selectStorePictureByStoreIdAndStorePicture(storePicture, storePictureVO.getStoreId()) == null) {
			throw new StorePictureNotFoundException(storePicture + "등록되어 있지 않음");
		}
		return dao.updateStorePictureByStorePicture(storePictureVO, storePicture);
	}

	@Override
	public int removeStorePicture(StorePicture storePicture) throws StorePictureNotFoundException {

		return dao.deleteStorePicture(storePicture);
	}

}
