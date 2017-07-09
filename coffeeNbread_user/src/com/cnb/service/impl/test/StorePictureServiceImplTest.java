package com.cnb.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.service.StorePictureService;
import com.cnb.vo.StorePicture;

/*
 * 이진영
 * 2017-07-02
 * 생성
 */

public class StorePictureServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//Service bean 가져오기
		StorePictureService service =  (StorePictureService)ctx.getBean("storePictureServiceImpl");
	
	//매장 사진 등록 
		List<StorePicture> p1 = new ArrayList<StorePicture>();
		p1.add(new StorePicture("매장사진220","s-1"));
		p1.add(new StorePicture("매장사진221","s-1"));
	
	/*	
	try{
		
		service.addStorePicture(p1);
		System.out.println("등록완료");
	}catch(DuplicatedStorePictureException e){
		System.err.println(e.getMessage());
	}*/
	
	/*	
	//매장 사진 수정
	StorePicture p2 = new StorePicture("매장사진수정2","s-2");
	try{
		
		System.out.println(service.modifyStorePictureByStorePicture(p2,"매장사진수정1"));
		System.out.println("수정완료");
	}catch(StorePictureNotFoundException e){
		System.err.println(e.getMessage());
	}*/
	
	
	//매장사진 삭제
	//System.out.println(service.removeStorePicture(new StorePicture("매장사진수정2","s-2")));
	
	}
	
}
