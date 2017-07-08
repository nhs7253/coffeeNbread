package com.cnb.service.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.vo.GeneralUser;

/*
 * 노현식 
 * 2017-06-30 
 * 초기 구현
 * 
 * 노현식 
 * 2017-06-23 
 * 생성
 */
@Component
public class GeneralUserServiceImplTest {
	
	@Autowired
	private GeneralUserService service;
	
	public void Test() throws UserManageException {
		
		service.addUser(new GeneralUser("ServiceTestUser1", 
						            "1111", 
						            "서비스 테스트 유저1", 
						            new Date(), 
						            "남자", 
						            "serviceTest@Test.com",
						            "010-1111-1111", 
						            "서비스테스트1동", 
						            "Y",
						            "STORE-01"));
		
		System.out.println("findUser = " + service.findUser("ServiceTestUser1"));
		
		System.out.println("addUser 사용 후");
		System.out.println(service.findUserListBySelectToKeyword("userId", "Service", 1));
		
		service.modifyUser(new GeneralUser("ServiceTestUser1", 
	            "222", 
	            "서비스 테스트 유저1", 
	            new Date(), 
	            "여자", 
	            "serviceTest2@Test.com",
	            "010-2222-2222", 
	            "서비스테스트2동", 
	            "Y",
	            "STORE-02"));
		
		System.out.println("modifyUser 사용 후");
		System.out.println(service.findUserListBySelectToKeyword("userId", "ServiceTestUser1", 1));
		
		
		service.removeUser("ServiceTestUser1");
		System.out.println("service 사용 후");
		System.out.println(service.findUserListBySelectToKeyword("userId", "Service", 1));
		
		service.RealRemoveUser("ServiceTestUser1");
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) throws UserManageException {
		
		GeneralUserServiceImplTest gudit = 
				(GeneralUserServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("generalUserServiceImplTest");
		gudit.Test();
		
	}
}
