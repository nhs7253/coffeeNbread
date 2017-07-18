package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.StoreDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.service.AdminService;
import com.cnb.util.PagingBean;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.UserAuthority;

/*
 * 노현식
 * 2017-07-03
 * 페이징 관련 메서드 추가
 * 
 * 노현식 
 * 2017-06-30 
 * 초기 구현
 * 
 * 노현식 
 * 2017-06-23 
 * 생성
 */
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private GeneralUserDao generalUserDao;
	
	@Autowired
	private UserAuthorityDao userAuthorityDao;
	
	@Autowired
	private StoreDao storeDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Map<String, Object> userManagementListService(String select, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = generalUserDao.selectGeneralUserListBySelectToKeywordJoinStoreCount(select, keyword);
		PagingBean pageBean = new PagingBean(tatalCount, page);
		List<GeneralUser> list = generalUserDao.selectGeneralUserListBySelectToKeywordJoinStoreContent(select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}

	@Override
	@Transactional
	public void storeApproveService(String userId, String storeId, String storePermission) {
		String permission = null;
		UserAuthority userAuthority = null;
		if(storePermission.equals("Y")){
			permission = "N";
			userAuthority = new UserAuthority(userId, "ROLE_CNB_USER");
		}else{
			permission = "Y";
			userAuthority = new UserAuthority(userId, "ROLE_CNB_STORE");
		}
		storeDao.updateStorePermission(storeId, permission);
		userAuthorityDao.updateUserAuthorityByUserId(userAuthority);
	}
}
