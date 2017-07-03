package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.UserPreferenceStoreDao;
import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식
 * 2017-06-29
 * 생성, 초기 구현
 */
@Component
public class UserPreferenceStoreDaoImpiTest {
	
	@Autowired
	private UserPreferenceStoreDao dao;
	
	public UserPreferenceStoreDaoImpiTest() {
	}
	
	public UserPreferenceStoreDaoImpiTest(UserPreferenceStoreDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectUserPreferenceList());
		
		dao.insertUserPreferenceStore(new UserPreferenceStore("u-1", "s-3"));
		dao.insertUserPreferenceStore(new UserPreferenceStore("u-1", "s-4"));
		dao.insertUserPreferenceStore(new UserPreferenceStore("u-1", "s-5"));
		dao.insertUserPreferenceStore(new UserPreferenceStore("u-1", "s-6"));
		System.out.println("insertGeneralUser 후 조회");
		System.out.println(dao.selectUserPreferenceList());
		
		dao.updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits(new UserPreferenceStore("u-1", "s-4"));
		System.out.println("updateUserPreferenceStoreByUserPreferenceStoreUpPreferenceHits 후 조회");
		System.out.println(dao.selectUserPreferenceList());
		
		System.out.print("selectUserPreferenceJoinStoreSort 로 조회 = ");
		System.out.println(dao.selectUserPreferenceJoinStoreSort("u-1"));
		
		dao.deleteUserPreferenceStore("u-1");
		System.out.println("deleteUserPreferenceStore 후 조회");
		System.out.println(dao.selectUserPreferenceList());
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		UserPreferenceStoreDaoImpiTest gudit = (UserPreferenceStoreDaoImpiTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("userPreferenceStoreDaoImpiTest");
		gudit.Test();
		 
	}
}
