package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.NoticeBoardContentsDao;
import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.vo.NoticeBoardContents;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-03 생성
 */
@Component
public class RecipeBoardContentsDaoImplTest {

	@Autowired
	private RecipeBoardContentsDao dao;
	

	
	public void Test() {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
	 // 레시피 글 등록과 수정 성공( 유저아이디와 매장아이디를 통해)			
  		try {
			dao.insertRecipeBoardContents(new RecipeBoardContents(10, "레시피글추천수높음", "레시피제목추천수높음", dt.parse("2017-06-30"), 12,"레시피사진",15,"u-1"));
  		
  			// 유저 입장에서 수정시 조회수는 그대로 유지
  			//dao.updateRecipeBoardContents(new RecipeBoardContents(4,"레시피글7-수정", "레시피제목7-수정", dt.parse("2017-07-02"),"레시피사진","u-1","s-7"));
  			
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		
		/*  레시피 글 삭제 */
		/*dao.deleteRecipeBoardContentsByRecipeBoardNo("10");*/
  			
		/* 비회원 로그인 할시 총 레시피 게시판 조회 - 조회만 가능 (매장이름이랑 조인함)*/
		/*System.out.println("--------전체----------");
		System.out.println(dao.selectRecipeBoardContentsList());*/
	
     /*	System.out.println("--------내용으로 조회----------");
		System.out.println(dao.selectRecipeBoardContentsListByRecipeBoardContent("피"));
		
		
		System.out.println("--------작성일자----------");
		try {
			System.out.println(dao.selectRecipeBoardContentsListByRecipeBoardDate(dt.parse("2017-06-27")));
		} catch (ParseException e) {
			System.out.println("이상발견");
		}*/
		
		/*System.out.println("--------조회수----------");
		System.out.println(dao.selectRecipeBoardContentsListByRecipeBoardHits(12));*/
		
		/*System.out.println("--------제목----------");
		System.out.println(dao.selectRecipeBoardContentsListByRecipeBoardTitle("12"));*/
		
  		
  		/* System.out.println("---------추천수가 높은순서대로 조회--------");
 		System.out.println(dao.selectRecipeBoardContentsListOrderByRecommendCount());*/

  		
  		
		System.out.println("이상없음");
	}
    
	public static void main(String[] args) throws IOException {
		RecipeBoardContentsDaoImplTest rbcd = (RecipeBoardContentsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("recipeBoardContentsDaoImplTest");
		rbcd.Test();
	}
}