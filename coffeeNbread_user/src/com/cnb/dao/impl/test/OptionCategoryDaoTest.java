package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionCategoryDao;
import com.cnb.vo.OptionCategory;
/*
 * 이진영
 * 2017-06-28
 * 초기 구현
 */
@Repository
public class OptionCategoryDaoTest {
	@Autowired
	private OptionCategoryDao dao;

	public OptionCategoryDaoTest() {
	}

	public OptionCategoryDaoTest(OptionCategoryDao dao) {
		this.dao = dao;
	}

	public void Test() {
		System.out.println("최초 조회");
		
		

		//옵션 카테고리 등록

//		System.out.println(dao.insertOptionCategory(new OptionCategory(13,"s-2","대분류11")));
//		System.out.println(dao.insertOptionCategory(new OptionCategory(14,"s-2","대분류2")));
		
//		System.out.println("updateStoreEvent 후 조회");
		
		
		//옵션 카테고리 수정
		System.out.println(dao.updateOptionCategory(new OptionCategory(13,"대분류1수정","s-2")));

		
		//옵션 카테고리 삭제
		
		System.out.println(dao.deleteOptionCategory("s-2",13));
		

		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) {
		OptionCategoryDaoTest gudit = (OptionCategoryDaoTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("optionCategoryDaoTest");
		gudit.Test();

	}
}
