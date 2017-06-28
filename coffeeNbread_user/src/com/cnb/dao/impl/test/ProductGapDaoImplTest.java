package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductGapDao;
import com.cnb.vo.ProductGap;

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
	
	public ProductGapDaoImplTest() {
	}
	
	public void examProductTest() {
		//dao.insertProductGap(new ProductGap("D", "5", "p-1", "m-1"));
		//dao.insertProductGap(new ProductGap("K", "2", "p-2", "m-1"));
		//dao.updateProductGap(new ProductGap("U", "10", "p-2", "m-1"));
		
		//System.out.println(dao.selectProductGapByIdentifyCode("U"));
		System.out.println(dao.selectProductGap());
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductGapDaoImplTest pgd = (ProductGapDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productGapDaoImplTest");
		pgd.examProductTest();
	}
}