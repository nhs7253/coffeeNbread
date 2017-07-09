package com.cnb.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StoreBookmarkDao;
import com.cnb.vo.StoreBookmark;

/*
 * 노현식
 * 2017-07-01
 * selectStoreBookmarkByUserIdJoinStoreListPagingCount
 * selectStoreBookmarkByUserIdJoinStoreListPaging
 * 부분 일치 조회 추가 및 테스트
 * 
 * 노현식
 * 2017-06-29
 * 페이징을 위한 테스트
 * selectStoreBookmarkByUserIdJoinStoreList
 * selectStoreBookmarkByUserIdJoinStoreListCount
 * selectStoreBookmarkByUserIdJoinStoreListPagingCount
 * 
 * 노현식
 * 2017-06-28
 * 생성, 초기 구현
 */
@Component
public class StoreBookmarkDaoImplTest {
	
	@Autowired
	private StoreBookmarkDao dao;
	
	public StoreBookmarkDaoImplTest() {
	}
	
	public StoreBookmarkDaoImplTest(StoreBookmarkDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		
		dao.insertStoreBookmark(new StoreBookmark("u-3", "s-3"));
		dao.insertStoreBookmark(new StoreBookmark("u-4", "s-3"));
		
		System.out.println("insertStoreBookmark 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		dao.updateStoreBookmark(new StoreBookmark("u-3", "s-4"));
		System.out.println("updateStoreBookmark 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		
		System.out.println("selectStoreBookmarkByStoreBookmark = " + dao.selectStoreBookmarkByStoreBookmark(new StoreBookmark("u-3", "s-4")));
		System.out.println("selectStoreBookmarkByStoreBookmark 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		
		System.out.print("selectStoreBookmarkByUserId 조회 : ");
		System.out.println(dao.selectStoreBookmarkListByUserId("u-1"));
		
		
		dao.deleteStoreBookmarkByUserId("u-3");
		System.out.println("deleteStoreBookmarkByUserId 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		
		dao.deleteStoreBookmarkByStoreBookmark(new StoreBookmark("u-4", "s-3"));
		System.out.println("deleteStoreBookmarkByStoreBookmark 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		System.out.print("selectStoreBookmarkByUserIdJoinStoreListCount 조회 = ");
		System.out.println(dao.selectStoreBookmarkByUserIdJoinStoreListCount("u-1"));
		
		System.out.print("selectStoreBookmarkByUserIdJoinStoreListPagingCount 조회 = ");
		System.out.println(dao.selectStoreBookmarkByUserIdJoinStoreListPagingCount("u-1", "장", 2, 5));
		
		System.out.print("selectStoreBookmarkByUserIdJoinStoreListPaging 조회 = ");
		System.out.println(dao.selectStoreBookmarkByUserIdJoinStoreListPaging("u-1", "장", 2, 5));
		
		
		List<String> list = new ArrayList<>();
		list.add("s-1");
		list.add("s-2");
		dao.deleteStoreBookmarkByStoreBookmarkList("u-1", list);
		System.out.println("deleteStoreBookmarkByStoreBookmark 후 조회");
		System.out.println(dao.selectStoreBookmarkList());
		
		System.out.println(dao.selectStoreBookmarkByUserIdJoinStoreList("u-2"));
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		StoreBookmarkDaoImplTest gudit = (StoreBookmarkDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storeBookmarkDaoImplTest");
		gudit.Test();
		 
	}
}
