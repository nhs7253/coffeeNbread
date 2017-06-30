package com.cnb.service.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.service.impl.GeneralUserServiceImpl;
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
	private GeneralUserService gus;
	
	public GeneralUserServiceImplTest(){}
	
	public GeneralUserServiceImplTest(GeneralUserService gus){
		this.gus = gus;
	}
	
	public void Test() throws UserManageException {
		
		gus.addUser(new GeneralUser("ServiceTestUser1", 
						            "1111", 
						            "서비스 테스트 유저1", 
						            new Date(), 
						            "남자", 
						            "serviceTest@Test.com",
						            "010-1111-1111", 
						            "서비스테스트1동", 
						            "Y"));
		
		System.out.println(gus.findUser("ServiceTestUser1"));
		
		gus.removeUser("ServiceTestUser1");
	}

	public static void main(String[] args) throws UserManageException {
		
		GeneralUserServiceImplTest gudit = 
				(GeneralUserServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("generalUserServiceImplTest");
		gudit.Test();
		
//		GeneralUserServiceImpl t = 
//				(GeneralUserServiceImpl)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("generalUserServiceImpl");
//		
//		System.out.println(t.findUser("u-1"));
	}
}
