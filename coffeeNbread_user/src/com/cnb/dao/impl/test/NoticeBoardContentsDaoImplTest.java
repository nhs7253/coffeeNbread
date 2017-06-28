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
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
				
  		try {
			dao.insertNoticeBoardContents(new NoticeBoardContents(0, "모두들 안녕", "인사", dt.parse("2017-06-27"), 5));
		} catch (ParseException e) {
			System.out.println("이상발견");
		}
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		NoticeBoardContentsDaoImplTest nbcd = (NoticeBoardContentsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("noticeBoardContentsDaoImplTest");
		nbcd.examProductTest();
	}
}