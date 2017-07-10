package com.cnb.dao.impl.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.NoticeBoardContentsDao;
import com.cnb.vo.NoticeBoardContents;

/*
 * 최민희
 * 2017-06-28 생성
 */
@Component
public class NoticeBoardContentsDaoImplTest {

	@Autowired
	private NoticeBoardContentsDao dao;
	
	private NoticeBoardContentsDaoImplTest(NoticeBoardContentsDao dao){
		this.dao = dao;
	}
	

	public void examProductTest() {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

			
//  		try {
//			dao.insertNoticeBoardContents(new NoticeBoardContents(0, "공지7", "7", dt.parse("2017-06-30"), 7));
//  		
//  			//수정시 조회수는 그대로 유지
//  			//dao.updateNoticeBoardContents(new NoticeBoardContents(3, "공지수정", "수정", dt.parse("2017-07-01")));
//  			
//		} catch (ParseException e) {
//			System.out.println("이상발견");
//		}
//		
//		dao.deleteNoticeBoardContentsByNoticeBoardNo(5);
//  			
//		System.out.println("--------전체----------");
//		System.out.println(dao.selectNoticeBoardContentsList());
//	
//		System.out.println("--------내용----------");
//		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardContent("공지2"));
//		
//		System.out.println("--------작성일자----------");
//		try {
//			System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardDate(dt.parse("2017-06-26")));
//		} catch (ParseException e) {
//			System.out.println("이상발견");
//		}
//		
//		System.out.println("--------조회수----------");
//		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardHits(6));
//		
//		System.out.println("--------제목----------");
//		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardTitle("7"));
//		

		/*		
  		try {
			dao.insertNoticeBoardContents(new NoticeBoardContents(0, "공지7", "7", dt.parse("2017-06-30"), 7));
  		
  			//수정시 조회수는 그대로 유지
  			//dao.updateNoticeBoardContents(new NoticeBoardContents(3, "공지수정", "수정", dt.parse("2017-07-01")));
  			
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		*/
		dao.deleteNoticeBoardContentsByNoticeBoardNo(5);
  			
		System.out.println("--------전체----------");
		System.out.println(dao.selectNoticeBoardContentsList());
	
		System.out.println("--------내용----------");
		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardContent("공지2"));

		System.out.println(dao.selectNoticeBoardContentsBySelectAndKeywordPagingList("title", "7", 2, 3));
		System.out.println(dao.selectNoticeBoardContentsBySelectAndKeywordPagingList("title", "7", 2, 3).size());
		System.out.println(dao.selectNoticeBoardContentsBySelectAndKeywordPagingCount("title", "7"));
		System.out.println(dao.selectNoticeBoardContentsByNoticeBoardNo(30));

		System.out.println("--------작성일자----------");
		try {
			System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardDate(dt.parse("2017-06-26")));
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		
		System.out.println("--------조회수----------");
		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardHits(6));
		
		System.out.println("--------제목----------");
		System.out.println(dao.selectNoticeBoardContentsListByNoticeBoardTitle("6"));
		

		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		NoticeBoardContentsDaoImplTest nbcd = (NoticeBoardContentsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("noticeBoardContentsDaoImplTest");
		nbcd.examProductTest();
	}
}