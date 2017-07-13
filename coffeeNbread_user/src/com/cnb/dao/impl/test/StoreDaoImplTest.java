package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StoreDao;

/*
 * 노현식
 * 2017-07-09
 * 페이징 관련 테스트
 * 
 * 이진영
 * 2017-06-30
 * 수정
 * 
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
		System.out.println(dao.deleteStoreById("s-1"));
		//System.out.println(dao.selectStorePicture("s-1"));
//		System.out.println(dao.selectOpionCategoryNDetailByIdList("s-1"));
//		System.out.println(dao.selectStoreById("s-1"));

//		System.out.println(dao.selectStoreEventList("s-1"));
//		System.out.println(dao.selectStoreCategoryList("s-1"));
/*
		dao.insertStore(new Store("id-5", "0000", "DOA테스트 소개", "000-0000-0000", "주소", "DaoTest-1@dao.com", 2,
				new Date(), new Date(), "Y"));

		System.out.println("insertStore 후 조회");
		System.out.println(dao.selectStore("id-5"));

		

		dao.updateStore(new Store("id-5", "0001", "DOA테스트 소개수정", "000-0000-0000", "주소", "DaoTest-1@dao.com", 3,
				new Date(), new Date(), "Y"));
		System.out.println("updateStore 후 조회");
		System.out.println(dao.selectStore("id-5"));

	*/
		System.out.println("1 =" + dao.selectStoreBySelectAndKeywordPagingList("storeName", "매장", 3, 5));
		System.out.println("2 =" + dao.selectStoreBySelectAndKeywordPagingList("storeName", "매장", 3, 5).size());
		System.out.println("3 =" + dao.selectStoreBySelectAndKeywordPagingCount("storeName", "매장"));
		
		System.out.println("4 = " + dao.selectStroeJoinPicture("s-2"));

		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) {
		StoreDaoImplTest gudit = (StoreDaoImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("storeDaoImplTest");
		gudit.Test();

	}
}