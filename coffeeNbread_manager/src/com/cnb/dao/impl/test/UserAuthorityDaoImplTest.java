package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.UserAuthorityDao;
import com.cnb.vo.UserAuthority;

/*
 * 노현식
 * 2017-06-27
 * 생성, 초기 구현
 */
@Component
public class UserAuthorityDaoImplTest {
	
	@Autowired
	private UserAuthorityDao dao;
	
	public UserAuthorityDaoImplTest() {
	}
	
	public UserAuthorityDaoImplTest(UserAuthorityDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectUserAuthorityList());
		
		
		dao.insertUserAuthority(new UserAuthority("UA-1", "CNB_USER"));
		dao.insertUserAuthority(new UserAuthority("UA-2", "CNB_ADMIN"));
		
		System.out.println("insertUserAuthority 후 조회");
		System.out.println(dao.selectUserAuthorityList());
		
		dao.updateUserAuthorityByUserId(new UserAuthority("UA-1", "CNB_STORE"));
		System.out.println("updateUserAuthorityByUserId 후 조회");
		System.out.println(dao.selectUserAuthorityList());
		
		
		System.out.print("selectUserAuthorityByUserId 조회 : ");
		System.out.println(dao.selectUserAuthorityByUserId("UA-1"));
		
		System.out.println(dao.deleteUserAuthorityByUserId("UA-1"));
		System.out.println("deleteUserAuthorityByUserId 후 조회");
		System.out.println(dao.selectUserAuthorityList());
		
		
		dao.deleteUserAuthorityByUserAuthorityData(new UserAuthority("UA-2", "CNB_ADMIN"));
		System.out.println("deleteUserAuthorityByUserAuthorityData 후 조회");
		System.out.println(dao.selectUserAuthorityList());
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		UserAuthorityDaoImplTest gudit = (UserAuthorityDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("userAuthorityDaoImplTest");
		gudit.Test();
		 
	}
}
