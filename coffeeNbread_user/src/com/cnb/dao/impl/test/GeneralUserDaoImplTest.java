package com.cnb.dao.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.GeneralUserDao;
import com.cnb.vo.GeneralUser;

/*
 * 노현식
 * 2017-06-27
 * 초기 구현
 * 
 * 노현식 
 * 2017-06-23 
 * 생성
 */
@Component
public class GeneralUserDaoImplTest {
	
	@Autowired
	private GeneralUserDao dao;
	
	public GeneralUserDaoImplTest() {
	}
	
	public GeneralUserDaoImplTest(GeneralUserDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectGeneralUserList());
		
		
		dao.insertGeneralUser(new GeneralUser("DAO-0", 
											  "0000", 
											  "DOA테스트 유저1", 
											  new Date(), 
											  "남자", 
											  "DaoTest-1@dao.com", 
											  "000-0000-0000", 
											  "DAO시1", 
											  "Y"));
		
		System.out.println("insertGeneralUser 후 조회");
		System.out.println(dao.selectGeneralUserList());
		
		dao.updateGeneralUserByUserIdToInfo(new GeneralUser("DAO-0", 
				  											"5555", 
				  											"DOA테스트 유저5", 
				  											new Date(), 
				  											"남자", 
				  											"DaoTest-5@dao.com", 
				  											"5555-5555-5555", 
				  											"DAO시5", 
															"Y"));
		System.out.println("updateGeneralUserByUserIdToInfo 후 조회");
		System.out.println(dao.selectGeneralUserList());
		
		dao.updateGeneralUserByUserIdToUserActiveState("DAO-0");
		System.out.println("updateGeneralUserByUserIdToUserActiveState 후 조회");
		System.out.println(dao.selectGeneralUserList());
		
		System.out.println(dao.selectGeneralUserByUserActiveState("Y"));
		System.out.println("selectGeneralUserByUserActiveState Y로 조회");
		System.out.println(dao.selectGeneralUserList());
		
		dao.selectGeneralUserByUserId("DAO-0");
		System.out.println("selectGeneralUserByUserId 후 조회");
		System.out.println(dao.selectGeneralUserList());
		
		
		
		System.out.print("selectGeneralUserCount 조회 : ");
		System.out.println(dao.selectGeneralUserCount());
		
		System.out.print("selectGeneralUserByUserActiveStateCount 조회 : ");
		System.out.println(dao.selectGeneralUserByUserActiveStateCount("Y"));
		
		
		dao.deleteGeneralUserByUserId("DAO-0");
		System.out.println("deleteGeneralUserByUserId 후 조회");
		System.out.println(dao.selectGeneralUserList());
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		GeneralUserDaoImplTest gudit = (GeneralUserDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("generalUserDaoImplTest");
		gudit.Test();
		 
	}
}
