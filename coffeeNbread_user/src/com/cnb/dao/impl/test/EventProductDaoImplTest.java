package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.EventProductDao;
/*
 * 최민희
 * 2017-06-29
 */
@Component
public class EventProductDaoImplTest {
	
	@Autowired
	private EventProductDao dao;
	
	private EventProductDaoImplTest(EventProductDao dao){
		this.dao = dao;
	}
	
	public void examTest() {
		//dao.insertEventProduct(new EventProduct("p-1", "s-1", 3));
		//dao.updateEventProduct(new EventProduct("p-6", "s-1", 4), new EventProduct("p-1", "s-1", 4));
		//dao.deleteEventProduct(new EventProduct("p-4", "s-1", 4));
		System.out.println(dao.selectEventProductListByEventNo(3));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		EventProductDaoImplTest epd = (EventProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("eventProductDaoImplTest");
		epd.examTest();
	}
}
