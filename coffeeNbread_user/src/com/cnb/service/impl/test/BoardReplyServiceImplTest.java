package com.cnb.service.impl.test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserManageException;
import com.cnb.service.BoardReplyService;
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.vo.BoardReply;
import com.cnb.vo.RecipeBoardContents;

/*  댓글달기 서비스 . */
@Component
public class BoardReplyServiceImplTest {

	@Autowired
	private BoardReplyService brService;

	
	
	
	public void Test() {

		/*System.out.println("-----------레시피 게시판에 댓글 등록 --------------");
	
		
		brService.addBoardReplyToRecipeBoardNo(new BoardReply(3,"댓글내용1","김형주1",new Date(),1));
		*/
		
/*	   System.out.println("----------qna게시판에 댓글 등록-----------------");	
		brService.addBoardReplyToQnaBoardNo(new BoardReply(13,"댓글내용-테스트","김형주1-테스트",2,new Date()));*/

	   /*  System.out.println("----------레시피 게시판 댓글 수정-------------");
		 brService.modifyBoardReplyToRecipeBoardNo(new BoardReply(3,"댓글내용수정","김형주수정1",new Date(),1));
		*/
		
/*
	     System.out.println("----------qna 게시판 댓글 수정-------------");
		 brService.modifyBoardReplyToQnaBoardNo(new BoardReply(6,"qna댓글내용수정","김형주qna수정1",2,new Date()));
		*/
		/*
		System.out.println("-----------레시피 게시판 댓글 삭제-------------");
		brService.removeBoardReplyToRecipeBoardNo(5, 2);
		
		System.out.println("-----------qna 게시판 댓글 삭제-------------");
		brService.removeBoardReplyToQnaBoardNo(11, 1);*/
		
		int page=1;
/*		System.out.println("-----------레시피게시판에 적힌 댓글 목록 찾기------");
	
     HashMap<String, Object> map1 = brService.findBoardReplyListByRecipeBoardContent(page, 1);
        
		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			  
			   if(entry1.getValue() == null) {
				   System.out.println("레시피 게시판에 조회할 목록이 없습니다.");				   
			   }else{
				   System.out.println("Test에서의 게시판 목록:"+entry1.getValue());				   
			   }
		   }
		}*/

		System.out.println("-----------Qna게시판에 적힌 댓글 목록 찾기------");
	
     HashMap<String, Object> map1 = brService.findBoardReplyListByQnaBoardContent(page, 2);
        
		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			  
			   if(entry1.getValue() == null) {
				   System.out.println("Qna게시판에  조회할 목록이 없습니다.");				   
			   }else{
				   System.out.println("Test에서의 QNA 게시판 목록:"+entry1.getValue());				   
			   }
		   }
		}
		
		
		
		
		
		
		
		
		
		
		
	}



	public static void main(String[] args) throws UserManageException {

		BoardReplyServiceImplTest rbc = (BoardReplyServiceImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("boardReplyServiceImplTest");
		rbc.Test();
		
	}

}
