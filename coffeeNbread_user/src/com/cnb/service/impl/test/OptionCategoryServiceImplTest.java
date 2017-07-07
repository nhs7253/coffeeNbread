package com.cnb.service.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.service.OptionCategoryService;
import com.cnb.vo.OptionCategory;

public class OptionCategoryServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		OptionCategoryService service =  (OptionCategoryService)ctx.getBean("optionCategoryServiceImpl");
	
	
		
		//option category 등록
		
		OptionCategory oc1 = new OptionCategory(7,"s-2","대분류100");
		List<OptionCategory> list = new ArrayList<OptionCategory>();
		list.add(new OptionCategory (17,"s-2","대"));
		list.add(new OptionCategory (18,"s-2","대2"));
		try{
			service.addOptionCategory(list);
			System.out.println("등록 성공");
		} catch (DuplicatedOptionCategoryNameException e) {
			System.err.println(e.getMessage());
		}
	
	/*	//option category 수정
		OptionCategory oc2 = new OptionCategory(3,"s-2","대분류2");
		
		
			service.modifyOptionCategory(oc2);
			System.out.println("수정완료");
		
		//option category 삭제
			
			service.removeOptionCategory("s-2",9);
			System.out.println("삭제완료");
	
	*/
	}
}
