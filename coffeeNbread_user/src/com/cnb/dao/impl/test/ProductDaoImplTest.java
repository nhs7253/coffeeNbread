package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductDao;

@Component
public class ProductDaoImplTest {

	@Autowired
	private ProductDao dao;
	
	private ProductDaoImplTest(ProductDao dao){
		this.dao = dao;
	}
	
	public ProductDaoImplTest() {
	}
	
	public void examProductTest() {

		dao.deleteProductById("m-1", "p-1");
		System.out.println(dao.deleteProductById("m-1", "p-1"));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductDaoImplTest pd = (ProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productDaoImplTest");
		pd.examProductTest();
	}
	
}
