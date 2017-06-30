package com.cnb.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cnb.exception.BookCardNumDuplicationException;
import com.cnb.exception.DeleteBookMarkException;
import com.cnb.service.BookMarkCardNumService;
import com.cnb.vo.BookMarkCardNum;

/*
 * 김형주 
 * 2017-06-30 생성
 */
@Component
public class BookMarkCardNumServiceImplTest {

	   @Autowired
	   private BookMarkCardNumService service; 
	
     /*  즐겨찾는 카드  새로 등록하는 서비스 */
	   public void Test() throws BookCardNumDuplicationException{
		   
		   System.out.println("--------------------카드번호 새로 등록 --------------");
		   try{
		    service.addBookMarkCardNum(new BookMarkCardNum("card-9","u-1"));
		   service.addBookMarkCardNum(new BookMarkCardNum("card-8","u-1"));
		   }catch(BookCardNumDuplicationException e){
			   e.getMessage();
		   }
		   
		   
	       System.out.println("--------------------카드번호 삭제 -------------------");
		   try{
			   
			   service.deleteBookMarkCardNumByCardNumAndUserId("card-5", "u-1");
			   service.deleteBookMarkCardNumByCardNumAndUserId("card-22", "u-2");
		   }catch(DeleteBookMarkException e){
			   e.getMessage();
		   }
		   
		   System.out.println("------------------- 등록한 카드번호 리스트 조회");
		    service.findBookMarkCardNumListByUserId("u-1");
		 
		   
		   
		   
	   }
	 
	
	
	public static void main(String [] args) throws BookCardNumDuplicationException {
		BookMarkCardNumServiceImplTest serviceTest = (BookMarkCardNumServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean(" bookMarkCardNumServiceImplTest");
		serviceTest.Test();
		 
	}
}
