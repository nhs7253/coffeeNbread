package com.cnb.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.service.UserAndStoreService;
import com.cnb.vo.StoreBookmark;
import com.cnb.vo.StoreVisitHistory;
import com.cnb.vo.UserPreferenceStore;

/*
 * 노현식 
 * 2017-07-01 
 * 생성, 초기 구현
 */
@Component
public class UserAndStoreServiceImplTest {
	
	@Autowired
	private UserAndStoreService service;
	
	public void Test() throws UserAndStoreServiceException {
		
		/************** 즐겨찾기 **************/		
		System.out.println("\n************** 즐겨찾기 **************");
		
		service.addStoreBookmark(new StoreBookmark("u-4", "s-1"));
		service.addStoreBookmark(new StoreBookmark("u-4", "s-2"));
		service.addStoreBookmark(new StoreBookmark("u-4", "s-3"));
		System.out.println("addStoreBookmark 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyword("u-4", 1, "매"));
		                           
		List<String> list = new ArrayList<>();
		list.add("s-1");
		list.add("s-2");	
		service.selectRemoveStoreBookmark("u-4", list);
		System.out.println("selectRemoveStoreBookmark 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyword("u-4", 1, "매"));
		
		service.removeAllStoreBookmark("u-4");
		System.out.println("removeAllStoreBookmark 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyword("u-4", 1, "매"));
		
		/************** 즐겨찾기 **************/
		
		
		/************** 최근 조회 매장 **************/
		System.out.println("\n************** 최근 조회 매장 **************");
		
		service.addStoreVisitHistory(new StoreVisitHistory("u-4", "s-1"));
		service.addStoreVisitHistory(new StoreVisitHistory("u-4", "s-2"));
		service.addStoreVisitHistory(new StoreVisitHistory("u-4", "s-3"));
		System.out.println("addStoreVisitHistory 실행 후");
		System.out.println(service.findStoreVisitHistoryListByKeyword("u-4", 1, "매"));
		
		List<String> list2 = new ArrayList<>();
		list2.add("s-1");
		list2.add("s-2");
		service.selectRemoveStoreVisitHistory("u-4", list2);
		System.out.println("selectRemoveStoreVisitHistory 실행 후");
		System.out.println(service.findStoreVisitHistoryListByKeyword("u-4", 1, "매"));
		
		service.removeAllStoreVisitHistory("u-4");
		System.out.println("removeAllStoreVisitHistory 실행 후");
		System.out.println(service.findStoreVisitHistoryListByKeyword("u-4", 1, "매"));
		
		/************** 최근 조회 매장 **************/
		
		
		/************** 조회 수별 추천 가게 **************/
		System.out.println("\n************** 조회 수별 추천 가게 **************");
		
		service.addUserPreferenceStore(new UserPreferenceStore("u-4", "s-1")); //최초 등록
		System.out.println("addUserPreferenceStore 실행 - INSERT 실행");
		System.out.println(service.viewUserPreferenceStoreList("u-4"));
		
		service.addUserPreferenceStore(new UserPreferenceStore("u-4", "s-1")); //업데이트
		System.out.println("addUserPreferenceStore 실행 - UPDATE 실행");
		System.out.println(service.viewUserPreferenceStoreList("u-4"));
		
		service.addUserPreferenceStore(new UserPreferenceStore("u-4", "s-2"));
		service.addUserPreferenceStore(new UserPreferenceStore("u-4", "s-3"));
		System.out.println("addUserPreferenceStore 실행 - 추가 INSERT 실행");
		System.out.println(service.viewUserPreferenceStoreList("u-4"));
		System.err.println("size = "+((List<UserPreferenceStore>)service.viewUserPreferenceStoreList("u-4")).size());
				
//		service.removeAllUserPreferenceStore("u-4");
//		System.out.println("removeAllUserPreferenceStore 실행 후");
//		System.out.println(service.viewUserPreferenceStoreList("u-4"));
		
		
		/************** 조회 수별 추천 가게 **************/
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) throws UserAndStoreServiceException {
		
		UserAndStoreServiceImplTest gudit = 
				(UserAndStoreServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("userAndStoreServiceImplTest");
		gudit.Test();
		
	}
}
