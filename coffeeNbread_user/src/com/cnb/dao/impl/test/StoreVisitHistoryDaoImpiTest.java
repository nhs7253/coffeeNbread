package com.cnb.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StoreVisitHistoryDao;
import com.cnb.vo.StoreVisitHistory;

/*
 * 노현식
 * 2017-06-30
 * 생성, 초기 구현
 */
@Component
public class StoreVisitHistoryDaoImpiTest {
	
	@Autowired
	private StoreVisitHistoryDao dao;
	
	public StoreVisitHistoryDaoImpiTest() {
	}
	
	public StoreVisitHistoryDaoImpiTest(StoreVisitHistoryDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectStoreVisitHistoryList());
		
		dao.insertStoreVisitHistory(new StoreVisitHistory("u-3", "s-3"));
		dao.insertStoreVisitHistory(new StoreVisitHistory("u-4", "s-3"));
		System.out.println("insertStoreVisitHistory 후 조회");
		System.out.println(dao.selectStoreVisitHistoryList());
		
		
		System.out.print("selectStoreVisitHistoryByUserId 조회 : ");
		System.out.println(dao.selectStoreVisitHistoryByUserId("u-1"));
		
		
		dao.deleteStoreVisitHistoryByUserId("u-3");
		System.out.println("deleteStoreVisitHistoryByUserId 후 조회");
		System.out.println(dao.selectStoreVisitHistoryList());
		
		
		dao.deleteStoreVisitHistoryByStoreVisitHistory(new StoreVisitHistory("u-4", "s-3"));
		System.out.println("deleteStoreVisitHistoryByStoreVisitHistory 후 조회");
		System.out.println(dao.selectStoreVisitHistoryList());
		
		System.out.print("selectStoreVisitHistoryByUserIdJoinStoreListCount 조회 = ");
		System.out.println(dao.selectStoreVisitHistoryByUserIdJoinStoreListCount("u-1"));
		
		System.out.print("selectStoreVisitHistoryByUserIdJoinStoreListPagingCount 조회 = ");
		System.out.println(dao.selectStoreVisitHistoryByUserIdJoinStoreListPagingCount("u-1", 2, 5));
		
		System.out.print("selectStoreVisitHistoryByUserIdJoinStoreListPaging 조회 = ");
		System.out.println(dao.selectStoreVisitHistoryByUserIdJoinStoreListPaging("u-1", 2, 5));
		
		
		List<String> list = new ArrayList<>();
		list.add("s-1");
		list.add("s-2");
		dao.deleteStoreVisitHistoryByStoreVisitHistoryList("u-1", list);
		System.out.println("deleteStoreVisitHistoryByStoreVisitHistory 후 조회");
		System.out.println(dao.selectStoreVisitHistoryList());
		
		System.out.println(dao.selectStoreVisitHistoryByUserIdJoinStoreList("u-2"));
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		StoreVisitHistoryDaoImpiTest gudit = (StoreVisitHistoryDaoImpiTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storeVisitHistoryDaoImpiTest");
		gudit.Test();
		 
	}
}
