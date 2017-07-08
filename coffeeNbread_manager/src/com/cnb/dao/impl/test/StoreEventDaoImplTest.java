package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StoreEventDao;

/*
 * 이진영
 * 2017-06-27
 * 초기 구현

 */
@Component
public class StoreEventDaoImplTest {

	@Autowired
	private StoreEventDao dao;

	public StoreEventDaoImplTest() {
	}

	public StoreEventDaoImplTest(StoreEventDao dao) {
		this.dao = dao;
	}

	public void Test() {
/*		System.out.println("최초 조회");
		
		System.out.println(dao.selectStoreEventList("id-3"));

		dao.insertStoreEvent(new StoreEvent(5,"이벤트 제목",new Date(),new Date(),"Y","이벤트 상세","Y",20,"사진","Y","Y","id-3"));

		System.out.println("insertStoreEvent 후 조회");
		System.out.println(dao.selectStoreEventList("id-3"));

		dao.updateStoreEvent(new StoreEvent(5, "이벤트 제목수정", new Date(), new Date(), "Y", "이벤트 상세수정", "Y",20,"사진",
				 "Y", "Y", "id-3"));
		System.out.println("updateStoreEvent 후 조회");
		System.out.println(dao.selectStoreEventList("id-3"));

		dao.deleteStoreEvent(4);
*/
		System.out.println(dao.selectStoreEventList("s-1"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) {
		StoreEventDaoImplTest gudit = (StoreEventDaoImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("storeEventDaoImplTest");
		gudit.Test();

	}
}