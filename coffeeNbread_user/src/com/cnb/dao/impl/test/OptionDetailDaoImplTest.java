package com.cnb.dao.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cnb.dao.OptionDetailDao;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.OptionDetail;
/*
 * 이진영
 * 2017-06-28
 * 초기 구현
 */
@Repository
public class OptionDetailDaoImplTest {
	@Autowired
	private OptionDetailDao dao;

	public OptionDetailDaoImplTest() {
	}

	public OptionDetailDaoImplTest(OptionDetailDao dao) {
		this.dao = dao;
	}

	public void Test() {
		System.out.println("최초 조회");
		
		

/*		

		System.out.println("optionDetail 등록 ");
		System.out.println(dao.insertOptionDetail(new OptionDetail("s-2","p-7",3,"소분류2")));
//		System.out.println(dao.insertOptionCategory(new OptionCategory(12,"s-2","대분류2")));
	*/	
		
		
		System.out.println("optionDetail 수정");
	//System.out.println(dao.updateOptionDetail(new OptionDetail("s-2","p-7",3,"소분류2수정")));

//		System.out.println(dao.deleteOptionDetail(12));
		
	
	System.out.println("optionDetail 조회");
//	System.out.println(dao.selectOptionDetailListByOptionCategory("s-2",3));
//	System.out.println(dao.selectOptionDetailByOptionDetailName("s-2",3,"e"));
//	System.out.println(dao.selectOptionDetailByProductId("s-2","p-7"));
	
	System.out.println("optionDetail 삭제");

	//	System.out.println(dao.deleteOptionDetail("s-2",3));
		System.out.println(dao.deleteOptionDetailByProductId("s-2", "p-12"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) {
		OptionDetailDaoImplTest gudit = (OptionDetailDaoImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("optionDetailDaoImplTest");
		gudit.Test();

	}
}
