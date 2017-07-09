package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductGapDao;

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
		
		System.out.println("=======등록========");
		//System.out.println(dao.insertProductGap(new ProductGap("K", "5", "p-4", "s-1")));
		
		System.out.println("---------식별코드----------");
		System.out.println(dao.selectProductGapListByIdentifyCodeByStoreIdAndIdentifyCode("s-2", "U", 1, 2));
		
		System.out.println("----------전체----------");
		System.out.println(dao.selectProductGapListByStoreId("s-1", 1, 2));
		
		System.out.println("이상없음");
	}
     
	public static void main(String[] args) throws IOException {
		ProductGapDaoImplTest pgd = (ProductGapDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productGapDaoImplTest");
		pgd.examTest();
	}
}