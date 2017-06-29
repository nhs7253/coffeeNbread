package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.QnaBoardContentsDao;

/*
 * 최민희
 * 2017-06-29 생성
 * 초기 구현
 */
@Component
public class QnaBoardContentsDaoImplTest {
	
	@Autowired
	private QnaBoardContentsDao dao;
	
	private QnaBoardContentsDaoImplTest(QnaBoardContentsDao dao){
		this.dao = dao;
	}
	
	public void examTest() {

		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		QnaBoardContentsDaoImplTest qbcd = (QnaBoardContentsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("qnaBoardContentsDaoImplTest");
		qbcd.examTest();
	}
}