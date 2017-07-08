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
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.vo.RecipeBoardContents;

/*  유저가 예약내역 서비스 */
@Component
public class RecipeBoardContentsServiceImplTest {

	@Autowired
	private RecipeBoardContentsService rbcService;

	public void Test() {

/*		System.out.println("-----------레시판 댓글 등록 서비스--------------");
		List<RecipeBoardContents> list = Arrays.asList(
				new RecipeBoardContents(0, "레시판 댓글내역 추가1", "레시판 제목 추가1", new Date(), 0, "사진", 0, "u-1", "s-7"),
				new RecipeBoardContents(0, "레시판 댓글내역 추가2", "레시판 제목 추가2", new Date(), 0, "사진", 0, "u-1", "s-7"),
				new RecipeBoardContents(0, "레시판 댓글내역 추가3", "레시판 제목 추가3", new Date(), 0, "사진", 0, "u-1", "s-7"),
				new RecipeBoardContents(0, "레시판 댓글내역 추가4", "레시판 제목 추가4", new Date(), 0, "사진", 0, "u-1", "s-7"),
				new RecipeBoardContents(0, "레시판 댓글내역 추가5", "레시판 제목 추가5", new Date(), 0, "사진", 0, "u-1", "s-7")

		);
*/
		
		 System.out.
		 println("------------------ 레시판 게시글 추가 확인 ------------------");
		 
	/* rbcService.addRecipeBoardContents(new RecipeBoardContents(0,"0707내역","0707제목",new Date(),0,"0707사진",0,"u-1","s-1"));*/
		/*rbcService.addRecipeBoardContents(new RecipeBoardContents(0, "레시판 댓글내역 추가6", "레시판 제목 추가6", new Date(), 0, "사진", 0, "u-1"));*/


		/*
		 * System.out.
		 * println("------------------레시판 게시글 업데이트 확인 ----------------------");
		 * rbcService.modifyRecipeBoardContents( new
		 * RecipeBoardContents(9,"레시판 댓글내역 추가1","레시판 제목 이것만 수정1",new
		 * Date(),0,"사진",3,"u-1","s-7"));
		 */

/*		System.out.println("-------------------레시판 게시글---------------------");

		rbcService.findRecipeBoardContentsByUserIdAndMethod(10, "u-1","제","recipeTitle" );*/
		
		/*System.out.println("-------------전체 레시피 게시글에서 내꺼 삭제 -----------");
		
		rbcService.removeRecipeBoardContentsByUserId("u-1", 40);*/
		
		/*System.out.println("-----------------유저가 매장들어가서 매장 레시피 게시판에서 내꺼 지움-------------.");
		
		rbcService.removeRecipeBoardContentsByUserIdAndStoreId("u-2", "s-7", 45);*/
		int page=1;
		
		
	   /*  //회원또는 비회원  전체 레시피 게시판 조회 모두 완료 - 페이징까지.  - 방법 조건 선택안할시 모두 조회까지 완성.
		System.out.println("-------------------회원또는 비회원이 유저아이디와 관계없이 레시피게시판 조회-----------------");
		
			
		HashMap<String, Object> map1 = rbcService.findRecipeBoardContentsByMethod(page, "","" );
        
		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			  
			   if(entry1.getValue() == null) {
				    System.out.println("Test에서의 List의 value:"+entry1.getValue());
				   System.out.println("유저또는 비회원 모두 전체게시판 조회할 목록이 없습니다.");				   
			   }else{
				   System.out.println(entry1.getValue());				   
			   }
		   }
		}
	*/
		
		
	/*	//회원이든 비회원이든 매장들어가서 레시피게시판 방법별로 검색가능.
	 * System.out.println("-------------------회원또는 비회원이 유저아이디와 관계없이 매장에서의  레시피게시판 조회-----------------");
		
		
		HashMap<String, Object> map1 = rbcService.findRecipeBoardContentsByStoreIdAndMethod(page, "s-7", "recipeBoardContent","17" );
        
		Iterator iterator1 = map1.entrySet().iterator();
		while (iterator1.hasNext()) {
		   Entry entry1 = (Entry)iterator1.next();
		   if(entry1.getKey().equals("list")){
			  System.out.println("Test에서의 List:"+entry1.getValue());
			   if(entry1.getValue() == null) {
				    System.out.println("Test에서의 List의 value:"+entry1.getValue());
				   System.out.println("유저또는 비회원 모두 전체게시판 조회할 목록이 없습니다.");				   
			   }else{
				   System.out.println(entry1.getValue());				   
			   }
		   }
		
		}
		*/
		
		
		
		
		
		System.out.println("유저가 전체게시판에서 자신이 쓴글 방법별로 검색.");
		
		
			HashMap<String, Object> map1 = rbcService.findRecipeBoardContentsByUserIdAndMethod(page, "", "", "");
				Iterator iterator1 = map1.entrySet().iterator();
				while (iterator1.hasNext()) {
					
				   Entry entry1 = (Entry)iterator1.next();
				   if(entry1.getKey().equals("list")){
					   if(entry1.getValue() == null) {
						   System.out.println("유저또는 비회원 모두 전체게시판 조회할 목록이 없습니다.");				   
					   }else{
						   
						   System.out.println("결과:"+entry1.getValue());	
						   
					   }
				   }
				}
				
			/*	System.out.println("유저가 매장별 자신이 쓴글 방법별로 검색.");
				
				
				HashMap<String, Object> map1 = rbcService.findRecipeBoardContentsByUserIdAndStoreIdAndMethod(page, "u-1", "s-7", "recommendCount", "");
				                                                                   
					Iterator iterator1 = map1.entrySet().iterator();
					while (iterator1.hasNext()) {
					   Entry entry1 = (Entry)iterator1.next();
					   if(entry1.getKey().equals("list")){
						   if(entry1.getValue() == null) {
							   System.out.println("유저또는 비회원 모두 전체게시판 조회할 목록이 없습니다.");				   
						   }else{
							   System.out.println(entry1.getValue());				   
						   }
					   }
					}*/
					
		
	}

	private void findRecipeBoardContentsByUserIdAndMethod(int i, String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) throws UserManageException {

		RecipeBoardContentsServiceImplTest rbc = (RecipeBoardContentsServiceImplTest) new ClassPathXmlApplicationContext(
				"com/cnb/config/spring/model-context.xml").getBean("recipeBoardContentsServiceImplTest");
		rbc.Test();
		
	}

}
