package com.cnb.dao.impl.test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.BookMarkCardNumDao;
import com.cnb.vo.BookMarkCardNum;

/*
 * 김형주
 * 2017-06-28
 * 초기 구현
 * 
 * 김형주 
 * 2017-06-28 
 * 생성
 */
@Component
public class BookMarkCardNumDaoImplTest {
	
	@Autowired
	private BookMarkCardNumDao dao;
	
	public BookMarkCardNumDaoImplTest() {
	}
	
	public BookMarkCardNumDaoImplTest(BookMarkCardNumDao dao) {
		this.dao = dao;
	}

	public void Test(){
/*		System.out.println("최초 조회");
		System.out.println(dao.selectCardNumListByUserId("u-1"));
	System.out.println("--------------------------------------------------------------------------------------");	
		
	
	    System.out.println("추가후조회");
		int count=dao.insertCardNum(new BookMarkCardNum("card-9","u-1"));
       System.out.printf("%d행이 추가되었습니다.",count);
		
		System.out.println("insertCardNum 후 조회");
		System.out.println(dao.selectCardNumListByUserId("u-1"));
		
		*/
		System.out.println(dao.selectCardNumListByUserId("u-1"));

		System.out.println("삭제후 조회");
		dao.deleteCardNumByCardNumAndUserId("card-1","u-1");
		System.out.println(dao.selectCardNumListByUserId("u-1"));
		
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


	public static void main(String [] args){
		BookMarkCardNumDaoImplTest gudit = (BookMarkCardNumDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("bookMarkCardNumDaoImplTest");
		gudit.Test();
		 
	}
}
