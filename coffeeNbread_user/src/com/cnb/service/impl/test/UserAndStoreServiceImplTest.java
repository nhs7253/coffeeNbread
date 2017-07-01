package com.cnb.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserAndStoreServiceException;
import com.cnb.exception.UserManageException;
import com.cnb.service.UserAndStoreService;
import com.cnb.vo.StoreBookmark;

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
		
		service.addStoreBookmark(new StoreBookmark("u-4", "s-1"));
		service.addStoreBookmark(new StoreBookmark("u-4", "s-2"));
		service.addStoreBookmark(new StoreBookmark("u-4", "s-3"));
		System.out.println("findStoreBookmarkListByKeyowrd 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyowrd("u-4", 1, "매"));
		
		
		List<String> list = new ArrayList<>();
		list.add("s-1");
		list.add("s-2");	
		service.selectRemoveStoreBookmark("u-4", list);
		System.out.println("selectRemoveStoreBookmark 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyowrd("u-4", 1, "매"));
		
		
		service.removeAllStoreBookmark("u-4");
		System.out.println("removeAllStoreBookmark 실행 후");
		System.out.println(service.findStoreBookmarkListByKeyowrd("u-4", 1, "매"));
	}

	public static void main(String[] args) throws UserAndStoreServiceException {
		
		UserAndStoreServiceImplTest gudit = 
				(UserAndStoreServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("userAndStoreServiceImplTest");
		gudit.Test();
		
	}
}
