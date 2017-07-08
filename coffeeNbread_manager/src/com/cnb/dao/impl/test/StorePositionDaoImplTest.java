package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StorePositionDao;
import com.cnb.vo.StorePosition;

/*
 * 노현식
 * 2017-06-28
 * 생성, 초기 구현
 */
@Component
public class StorePositionDaoImplTest {
	
	@Autowired
	private StorePositionDao dao;
	
	public StorePositionDaoImplTest() {
	}
	
	public StorePositionDaoImplTest(StorePositionDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectStorePositionJoinStoreList());
		
		
		dao.insertStorePosition(new StorePosition("s-1", "822834", "234802"));
		System.out.println("insertStorePosition 후 조회");
		System.out.println(dao.selectStorePositionJoinStoreList());
		
		dao.updateStorePosition(new StorePosition("s-1", "111111", "111111"));
		System.out.println("updateStorePosition 후 조회");
		System.out.println(dao.selectStorePositionJoinStoreList());
		
		
		System.out.print("selectStorePositionByStoreIdJoinStore 조회 = ");
		System.out.println(dao.selectStorePositionByStoreIdJoinStore("s-1"));
		
		System.out.println(dao.deleteStorePositionByStoreId("s-1"));
		System.out.println("deleteStorePositionByStoreId 후 조회");
		System.out.println(dao.selectStorePositionJoinStoreList());
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		StorePositionDaoImplTest gudit = (StorePositionDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storePositionDaoImplTest");
		gudit.Test();
		 
	}
}
