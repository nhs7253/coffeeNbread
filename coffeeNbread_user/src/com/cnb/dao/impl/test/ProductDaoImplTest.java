package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductDao;
import com.cnb.vo.Product;

/*
 * 최민희
 * 2017-06-27 생성
 */
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

		//dao.insertProduct(new Product("p-3", "m-1", "소보루빵", 3000, "빵", "소보루빵", "Y", 10, 10));
		//dao.deleteProductById("m-1", "p-1");
		//dao.updateProduct(new Product("p-3", "m-1", "몽블랑", 5000, "빵", "몽블랑랑", "N", 20, 20));
		//System.out.println(dao.selectProductByCategory("s-1", "빵"));		
		System.out.println(dao.selectProductByName("s-1", "제품1"));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductDaoImplTest pd = (ProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productDaoImplTest");
		pd.examProductTest();
	}
}
