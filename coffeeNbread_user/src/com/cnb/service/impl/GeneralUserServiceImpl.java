package com.cnb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.UserAuthority;

/*
 * 노현식 
 * 2017-06-23 생성
 */
@Service
public class GeneralUserServiceImpl implements GeneralUserService{
	
	@Autowired
	private GeneralUserDao generalUserDao;
	
	@Autowired
	private UserAuthorityDao userAuthorityDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addUser(GeneralUser generalUser) throws UserManageException {
		if(findUser(generalUser.getUserId())!= null){
			throw new UserManageException("이미 있는 회원입니다.");
		}
		generalUser.setUserPw(passwordEncoder.encode(generalUser.getUserPw()));
		generalUser.setUserActiveState("Y");
		generalUserDao.insertGeneralUser(generalUser);
		userAuthorityDao.insertUserAuthority(new UserAuthority(generalUser.getUserId(),"CNB_USER"));
	}

	@Override
	public GeneralUser findUser(String userId) {
		return generalUserDao.selectGeneralUserByUserId(userId);
	}

	@Override
	public void removeUser(String userId) {
		generalUserDao.deleteGeneralUserByUserId(userId);
		userAuthorityDao.deleteUserAuthorityByUserId(userId);
	}
}
