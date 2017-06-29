package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductGapDao;
import com.cnb.vo.ProductGap;

/*
 * 최민희
 * 2017-06-29
 * 수정
 */
/*
 * 최민희
 * 2017-06-28 생성
 */
@Component
public class ProductGapDaoImplTest {

	@Autowired
	private ProductGapDao dao;
	
	private ProductGapDaoImplTest(ProductGapDao dao){
		this.dao = dao;
	}
	
	public void examTest() {
		System.out.println("---------식별코드----------");
		System.out.println(dao.selectProductGapListByIdentifyCode("U"));
		
		System.out.println("----------전체----------");
		System.out.println(dao.selectProductGapList());
		
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductGapDaoImplTest pgd = (ProductGapDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productGapDaoImplTest");
		pgd.examTest();
	}
}