package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StoreCategoryDao;
import com.cnb.dao.StoreDao;
import com.cnb.vo.StoreCategory;

/*
 * 이진영
 * 2017-06-28
 * 초기 구현

 */
@Component
public class StoreCategoryDaoImplTest {

	@Autowired
	private StoreCategoryDao dao;

	public StoreCategoryDaoImplTest() {
	}

	public StoreCategoryDaoImplTest(StoreCategoryDao dao) {
		this.dao = dao;
	}

	public void Test() {
		System.out.println("최초 조회");
		


//		System.out.println(dao.insertStoreCategory(new StoreCategory(10,"빵","s-2")));
//		System.out.println(dao.updateStoreCategory(new StoreCategory(10,"대분류1","s-2")));
//		System.out.println(dao.deleteStoreCategoryByNo("s-2",1));
		System.out.println(dao.selectStoreCategoryByName("s-2","커피집"));

		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	
	}

	public static void main(String[] args) {
		StoreCategoryDaoImplTest gudit = 
				(StoreCategoryDaoImplTest) new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storeCategoryDaoImplTest");
		gudit.Test();

	}
}
