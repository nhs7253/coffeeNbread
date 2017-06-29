package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.StorePictureDao;
import com.cnb.vo.StorePicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
@Component
public class StorePictureDaoImplTest {

	@Autowired
	private StorePictureDao dao;
	
	private StorePictureDaoImplTest(StorePictureDao dao){
		this.dao = dao;
	}
	
	public void examTest() {
		//dao.insertStorePicture(new StorePicture("매장사진7", "s-2"));
		//dao.updateStorePictureByStorePicture(new StorePicture("매장사진8", "s-2"), "매장사진4");
		dao.deleteStorePicture(new StorePicture("매장사진2", "s-1"));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		StorePictureDaoImplTest spd = (StorePictureDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("storePictureDaoImplTest");
		spd.examTest();
	}
}