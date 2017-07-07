package com.cnb.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.NotInputRecipeBoardWriterException;
import com.cnb.exception.UserManageException;
import com.cnb.service.BoardRecommendService;
import com.cnb.vo.BoardRecommend;
import com.cnb.vo.RecipeBoardContents;

/*  댓글달기 서비스 . */
@Component
public class BoardRecommendServiceImplTest {

	@Autowired
	private BoardRecommendService service;

		
	
	public void Test() throws NotInputRecipeBoardWriterException {
   
		
		  //매장을 안거치고 바로 레시피 게시판 글 등록 가능하게 만들어야함.-- 추후작업.
		
		
		
		
		
		System.out.println("----------------------------매장별 레시피 게시판에 있는 추천수 증가 ----------------------");
				System.out.println(service.modifyPlusBoardRecommendByRecipeNo(new BoardRecommend("u-1",8)));
		
		
		System.out.println("---------------------------매장별 레시피 게시판에 있는 추천수 감소------------------");
		   System.out.println(service.modifyMinusBoardRecommendByRecipeNo(new BoardRecommend("u-1",3)));
		
		
		
		
		
	}



	public static void main(String[] args) throws UserManageException, NotInputRecipeBoardWriterException {

		BoardRecommendServiceImplTest brs = (BoardRecommendServiceImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("boardRecommendServiceImplTest");
		brs.Test();
		   
	}

}
