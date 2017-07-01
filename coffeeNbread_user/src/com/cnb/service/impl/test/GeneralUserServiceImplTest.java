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
						            "Y"));
		
		System.out.println(service.findUser("ServiceTestUser1"));
		
		service.removeUser("ServiceTestUser1");
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) throws UserManageException {
		
		GeneralUserServiceImplTest gudit = 
				(GeneralUserServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("generalUserServiceImplTest");
		gudit.Test();
		
	}
}
