package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductPictureDao;
import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-06-29
 * 생성
 */
@Component
public class ProductPictureDaoImplTest {

	@Autowired
	private ProductPictureDao dao;
	
	private ProductPictureDaoImplTest(ProductPictureDao dao){
		this.dao = dao;
	}
	
	public void examTest() {
		//dao.insertProductPicture(new ProductPicture("제품사진22", "p-1", "s-1"));
		//dao.deleteProductPictureByProductIdAndStoreId("p-3", "s-1");
		//dao.updateProductPicture(new ProductPicture("제품사진21", "p-5", "s-1"));
		System.out.println(dao.selectProductPictureListByProductIdAndStoreId("p-1", "s-1"));
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductPictureDaoImplTest ppd = (ProductPictureDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productPictureDaoImplTest");
		ppd.examTest();
	}
}