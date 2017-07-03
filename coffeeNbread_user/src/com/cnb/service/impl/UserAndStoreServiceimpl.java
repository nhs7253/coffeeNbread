package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.StoreBookmarkDao;
import com.cnb.dao.StoreVisitHistoryDao;
import com.cnb.dao.UserPreferenceStoreDao;
import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.service.UserAndStoreService;
import com.cnb.util.PagingBean;
import com.cnb.vo.StoreBookmark;
import com.cnb.vo.StoreVisitHistory;
import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식
 * 2017-07-01
 * 생성, 최초 구현
 */
@Service
public class UserAndStoreServiceimpl implements UserAndStoreService{
	
	@Autowired
	private StoreBookmarkDao storeBookmarkDao;
	
	@Autowired
	private StoreVisitHistoryDao storeVisitHistoryDao;
	
	@Autowired
	private UserPreferenceStoreDao userPreferenceStoreDao;

	/************** 즐겨찾기 **************/	
	
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
	public Map<String, Object> findStoreBookmarkListByKeyword(String userId, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = storeBookmarkDao.selectStoreBookmarkByUserIdJoinStoreListCount(userId); //검색 결과 개수
		PagingBean pageBean = new PagingBean(tatalCount, page); //(tatalCount, page) - (전체 페이지 수, 보려는 페이지 번호)
		List<StoreBookmark> list = storeBookmarkDao.selectStoreBookmarkByUserIdJoinStoreListPaging(userId, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		//실제 표여줄 내용을 페이징하여 일정 개수 읽음  - userId, keyword - 검색 조건, getBeginItemInPage() 보여줄 시작 페이지 번호 , getEndItemInPage() 보여줄 끝페이지 번호
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}
	
	/************** 즐겨찾기 **************/	
	
	
	/************** 최근 조회 매장 **************/

	@Override
	public void addStoreVisitHistory(StoreVisitHistory storeVisitHistory) {
		storeVisitHistoryDao.insertStoreVisitHistory(storeVisitHistory);
	}

	@Override
	public void removeAllStoreVisitHistory(String userId) {
		storeVisitHistoryDao.deleteStoreVisitHistoryByUserId(userId);
	}

	@Override
	public void selectRemoveStoreVisitHistory(String userId, List<String> storeIdList) {
		storeVisitHistoryDao.deleteStoreVisitHistoryByStoreVisitHistoryList(userId, storeIdList);
	}

	@Override
	public Map<String, Object> findStoreVisitHistoryListByKeyword(String userId, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = storeVisitHistoryDao.selectStoreVisitHistoryByUserIdJoinStoreListCount(userId); //검색 결과 개수
		PagingBean pageBean = new PagingBean(tatalCount, page); //(tatalCount, page) - (전체 페이지 수, 보려는 페이지 번호)
		List<StoreVisitHistory> list = storeVisitHistoryDao.selectStoreVisitHistoryByUserIdJoinStoreListPaging(userId, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		//실제 표여줄 내용을 페이징하여 일정 개수 읽음  - userId, keyword - 검색 조건, getBeginItemInPage() 보여줄 시작 페이지 번호 , getEndItemInPage() 보여줄 끝페이지 번호
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}
	
	/************** 최근 조회 매장 **************/
	
	
	
	/************** 조회 수별 추천 가게 **************/

	@Override
	public void addUserPreferenceStore(UserPreferenceStore userPreferenceStore) {
		if(userPreferenceStoreDao.selectUserPreferenceByUserPreferenceStore(userPreferenceStore) == null){
			userPreferenceStoreDao.insertUserPreferenceStore(userPreferenceStore);
		}else{
			userPreferenceStoreDao.updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits(userPreferenceStore);
		}
	}

	@Override
	public void removeAllUserPreferenceStore(String userId) {
		userPreferenceStoreDao.deleteUserPreferenceStore(userId);
	}

	@Override
	public List<UserPreferenceStore> viewUserPreferenceStoreList(String userId) {
		return userPreferenceStoreDao.selectUserPreferenceJoinStoreSort(userId);
	}
	
	/************** 조회 수별 추천 가게 **************/
	
}
