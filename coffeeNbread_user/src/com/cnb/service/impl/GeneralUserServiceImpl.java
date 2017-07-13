package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
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
		userAuthorityDao.insertUserAuthority(new UserAuthority(generalUser.getUserId(),"ROLE_CNB_USER"));
	}

	@Override
	public GeneralUser findUser(String userId) {
		return generalUserDao.selectGeneralUserByUserId(userId);
	}

	@Override
	@Transactional
	public void RealRemoveUser(String userId) {
		generalUserDao.deleteGeneralUserByUserId(userId);
		userAuthorityDao.deleteUserAuthorityByUserId(userId);
	}

	@Override
	public void modifyUser(GeneralUser generalUser) throws UserManageException {
		if(findUser(generalUser.getUserId())== null){
			throw new UserManageException("수정하고자 하는 유저가 없습니다.");
		}
		generalUser.setUserPw(passwordEncoder.encode(generalUser.getUserPw()));
		generalUserDao.updateGeneralUserByUserIdToInfo(generalUser);
	}

	@Override
	public void removeUser(String userId) throws UserManageException {
		if(findUser(userId)== null){
			throw new UserManageException("탈퇴 오류 발생");
		}
		generalUserDao.updateGeneralUserByUserIdToUserActiveState(userId); //유저 탈퇴
	}

	@Override
	public Map<String, Object> findUserListBySelectToKeyword(String select, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		
		int tatalCount = generalUserDao.selectGeneralUserListBySelectToKeywordCount(select, keyword);
		PagingBean pageBean = new PagingBean(tatalCount, page); //(tatalCount, page) - (전체 페이지 수, 보려는 페이지 번호)
		List<GeneralUser> list = generalUserDao.selectGeneralUserListBySelectToKeyword(select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		//실제 표여줄 내용을 페이징하여 일정 개수 읽음  - select, keyword - 검색 조건, getBeginItemInPage() 보여줄 시작 페이지 번호 , getEndItemInPage() 보여줄 끝페이지 번호
		map.put("pageBean", pageBean);
		map.put("list", list);
		
		return map;
	}
	
	
}
