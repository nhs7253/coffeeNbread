package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.StoreDao;
import com.cnb.dao.StorePaymentOptionListDao;
import com.cnb.dao.StoreVisitHistoryDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.dao.UserPreferenceStoreDao;
import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.service.OptionCategoryService;
import com.cnb.service.StoreCategoryService;
import com.cnb.service.StorePictureService;
import com.cnb.service.StoreService;
import com.cnb.service.UserAndStoreService;
import com.cnb.util.PagingBean;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.NoticeBoardContents;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePaymentOptionList;
import com.cnb.vo.StorePicture;
import com.cnb.vo.StoreVisitHistory;
import com.cnb.vo.UserAuthority;
import com.cnb.vo.UserPreferenceStore;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDao storedao; 
	
	@Autowired
	private StoreVisitHistoryDao storeVisitHistoryDao;
	
	@Autowired
	private StoreCategoryService storeCategoryService;
	
	@Autowired 
	private OptionCategoryService optionCategoryService;
	
	@Autowired
	private StorePictureService storePictureService;
	
	@Autowired
	private UserAndStoreService userAndStoreService;
	
	@Autowired
	private GeneralUserDao generalUserDao;
	
	@Autowired
	private StorePaymentOptionListDao storePaymentOptionListDao;
	
	@Autowired
	private UserAuthorityDao userAuthorityDao;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Store addStore(Store store, List<OptionCategory> optionCategory,StorePicture storePicture, String userId, List<String> paymentIdList) throws DuplicatedStoreIdException, DuplicatedOptionCategoryNameException, DuplicatedStoreCategorytNameException, DuplicatedStorePictureException{
		//storeId 중복확인
		if(storedao.selectStoreById(store.getStoreId())!=null){
			throw new DuplicatedStoreIdException(store.getStoreId()+" 는 이미 등록된 ID입니다.");
		}
		//store 추가
		storedao.insertStore(store);
		
		//매장 분류 추가
		optionCategoryService.addOptionCategory(optionCategory);

		//매장 사진 추가 
		storePictureService.addStorePicture(storePicture);
		
		//로그인한 유저에 매장 ID 추가
		generalUserDao.updateGeneralUserByUserIdToStoreId(userId, store.getStoreId());
		
		if(paymentIdList!=null){
			//매장 지원 결제 내역
			StorePaymentOptionList storePaymentOptionList = new StorePaymentOptionList();
			storePaymentOptionList.setStoreId(store.getStoreId());
			for(int i=0;i<paymentIdList.size();i++){
				storePaymentOptionList.setPaymentId(paymentIdList.get(i));				
				storePaymentOptionListDao.insertStorePaymentOptionList(storePaymentOptionList);
			}
		}
		Store st = storedao.selectStroeJoinPicture(store.getStoreId());
		
		
		System.out.println("stststs = " + st);
		
		return storedao.selectStroeJoinPicture(store.getStoreId());
		
		
	}

	/*@Override
	public int modifyStore(Store store) {
		return storedao.updateStore(store);
		
	}*/
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Store modifyStore(Store store,List<OptionCategory> optionCategory,List<StorePicture> storePicture, List<String> paymentIdList) throws DuplicatedStoreIdException, StorePictureNotFoundException, DuplicatedOptionCategoryNameException {
		 if(storedao.selectStoreById(store.getStoreId())!=null){
			 System.out.println("modifyStore = " + optionCategory);
			 storedao.updateStore(store);
		 }else{
				throw new DuplicatedStoreIdException(store.getStoreId()+" 는 없는 ID입니다.");
		 }
		 
		 optionCategoryService.modifyOptionCategory(optionCategory, store.getStoreId());
		 
		 storePictureService.modifyStorePictureByStorePicture(storePicture.get(0));
		 
		 if(paymentIdList!=null){
				//매장 지원 결제 내역
			storePaymentOptionListDao.deleteStorePaymentOptionListByStoreId(store.getStoreId());
			StorePaymentOptionList storePaymentOptionList = new StorePaymentOptionList();
			storePaymentOptionList.setStoreId(store.getStoreId());
			for(int i=0;i<paymentIdList.size();i++){
				storePaymentOptionList.setPaymentId(paymentIdList.get(i));				
				storePaymentOptionListDao.insertStorePaymentOptionList(storePaymentOptionList);
			}
		}else{
			storePaymentOptionListDao.deleteStorePaymentOptionListByStoreId(store.getStoreId());
		}
		 return storedao.selectStroeJoinPicture(store.getStoreId());
	}
		
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int removeStoretById(String storeId, String userId) {
		optionCategoryService.removeOptionCategoryByStoreId(storeId);
		storePictureService.removeStorePictureById(storeId);
		//로그인한 유저에 매장 ID 추가
		generalUserDao.updateGeneralUserByUserIdToStoreId(userId, null);
		int cnt = storedao.deleteStoreById(storeId);
		userAuthorityDao.updateUserAuthorityByUserId(new UserAuthority(userId, "ROLE_CNB_USER"));
		return cnt;
		
	}

	@Override
	public Store findStoreById(String storeId) {
		
		return storedao.selectStoreById(storeId);
	}

	@Override
	public List<Store> findStorePicture(String storeId) {
		
		return storedao.selectStorePicture(storeId);
	}

	@Override
	public List<Store> findStoreEventList(String storeId) {
		
		return storedao.selectStoreEventList(storeId);
	}

	@Override
	public List<Store> findStoreCategoryList(String storeId) {
		
		return storedao.selectStoreCategoryList(storeId);
	}

	@Override
	public List<Store> findOpionCategoryNDetailByIdList(String storeId) {
		
		return storedao.selectOpionCategoryNDetailByIdList(storeId);
	}

	@Override
	public Map<String, Object> findStorePagingList(String select, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = storedao.selectStoreBySelectAndKeywordPagingCount(select, keyword);
		PagingBean pageBean = new PagingBean(tatalCount, page);
		List<Store> list = storedao.selectStoreBySelectAndKeywordPagingList(select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}

	@Override
	public Store viewStore(String storeId, Authentication authentication) {
		String userInfo = authentication.getAuthorities().toString();
		if(!(userInfo.equals("[ROLE_ANONYMOUS]") || userInfo.equals("[ROLE_CNB_ADMIN]"))){
			storeVisitHistoryDao.insertStoreVisitHistory(new StoreVisitHistory(((GeneralUser)authentication.getPrincipal()).getUserId(), storeId));
			userAndStoreService.addUserPreferenceStore(new UserPreferenceStore(((GeneralUser)authentication.getPrincipal()).getUserId(), storeId));
		}
		Store store = storedao.selectStroeJoinPicture(storeId);
		int hits = store.getStoreHits();
		store.setStoreHits(hits+1);
				
		storedao.updateStore(store);
		return store;
	}
	
	
}
