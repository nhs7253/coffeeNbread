package com.cnb.dao.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import com.cnb.dao.StoreDao;

import com.cnb.vo.Store;

/*
 * 이진영
 * 2017-06-27
 * 초기 구현

 */
@Component
public class StoreDaoImplTest {

	@Autowired
	private StoreDao dao;

	public StoreDaoImplTest() {
	}

	public StoreDaoImplTest(StoreDao dao) {
		this.dao = dao;
	}

	public void Test() {
		System.out.println("최초 조회");
		
		System.out.println(dao.selectStore("id-1"));

		dao.insertStore(new Store("id-3", "0000", "DOA테스트 소개", "000-0000-0000", "주소", "DaoTest-1@dao.com", 2,
				new Date(), new Date(), "Y"));

		System.out.println("insertStore 후 조회");
		System.out.println(dao.selectStore("id-2"));

		

		dao.updateStore(new Store("id-3", "0001", "DOA테스트 소개수정", "000-0000-0000", "주소", "DaoTest-1@dao.com", 3,
				new Date(), new Date(), "Y"));
		System.out.println("updateStore 후 조회");
		System.out.println(dao.selectStore("id-2"));

	

		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) {
		StoreDaoImplTest gudit = (StoreDaoImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("storeDaoImplTest");
		gudit.Test();

	}
}