package com.cnb.service.impl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedOptionDetailNameException;
import com.cnb.service.OptionDetailService;
import com.cnb.vo.OptionDetail;

public class OptionDetailServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		OptionDetailService service =  (OptionDetailService)ctx.getBean("optionDetailServiceImpl");
	
		
		//소분류 등록
	
		OptionDetail od1 = new OptionDetail("s-2","p-30",3,"소분류22");

		try{
			service.addOptionDetail(od1);
			System.out.println("등록 성공");
		} catch (DuplicatedOptionDetailNameException e) {
			System.err.println(e.getMessage());
		}
		
		//소분류 수정
	
			
		OptionDetail od2 = new OptionDetail("s-2","p-19",3,"소분류22dddd");
		try{
			service.modifyOptionDetail(od2);
			System.out.println("수정 성공");
		} catch (DuplicatedOptionDetailNameException e) {
			System.err.println(e.getMessage());
		}
		
		//소분류 삭제 ->제품 값 변경할때 
		
		
	
	}
}
