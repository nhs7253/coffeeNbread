package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StoreBookmarkDao;
import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.service.UserAndStoreService;
import com.cnb.util.PagingBean;
import com.cnb.vo.StoreBookmark;

/*
 * 노현식
 * 2017-07-01
 * 생성, 최초 구현
 */
@Service
public class UserAndStoreServiceimpl implements UserAndStoreService{
	
	@Autowired
	private StoreBookmarkDao storeBookmarkDao;

	@Override
	public void addStoreBookmark(StoreBookmark storeBookmark) throws UserAndStoreServiceException {
		if(storeBookmarkDao.selectStoreBookmarkByStoreBookmark(storeBookmark) != null){
			throw new UserAndStoreServiceException("이미 즐겨찾기 하신 매장입니다.");
		}
		storeBookmarkDao.insertStoreBookmark(storeBookmark);
	}

	@Override
	public void removeAllStoreBookmark(String userId) {
		storeBookmarkDao.deleteStoreBookmarkByUserId(userId);
	}

	@Override
	public void selectRemoveStoreBookmark(String userId, List<String> storeIdList) {
		storeBookmarkDao.deleteStoreBookmarkByStoreBookmarkList(userId, storeIdList);
	}

	@Override
	public Map<String, Object> findStoreBookmarkListByKeyowrd(String userId, int page, String keyword) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = storeBookmarkDao.selectStoreBookmarkByUserIdJoinStoreListCount(userId); //검색 결과 개수
		PagingBean pageBean = new PagingBean(tatalCount, page); //(tatalCount, page) - (전체 페이지 수, 보려는 페이지 번호)
		List<StoreBookmark> list = storeBookmarkDao.selectStoreBookmarkByUserIdJoinStoreListPaging(userId, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		//실제 표여줄 내용을 페이징하여 일정 개수 읽음  - userId, keyword - 검색 조건, getBeginItemInPage() 보여줄 시작 페이지 번호 , getEndItemInPage() 보여줄 끝페이지 번호
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}
	
}
