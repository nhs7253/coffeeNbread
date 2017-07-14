package com.cnb.dao.impl.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.ProductDao;

/*
 * 노현식
 * 2017-07-13
 * POS용  selectProductListToPOS() 테스트
 */
/*
 * 최민희
 * 2017-07-01
 * 수정
 */
/*
 * 최민희
 * 2017-06-30
 * 수정
 */
/*
 * 최민희
 * 2017-06-29
 * 수정
 */
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
	
	public void examTest() {

		//dao.insertProduct(new Product("p-3", "m-1", "소보루빵", 3000, "빵", "소보루빵", "Y", 10, 10));
		//dao.updateProduct(new Product("p-3", "m-1", "몽블랑", 5000, "빵", "몽블랑랑", "N", 20, 20));
		
		/*System.out.println("===============List==================");
		System.out.println("1 = " + dao.selectProductListByCategory("s-2", "빵", 1, 4));		
		System.out.println("2 = " + dao.selectProductListByName("s-2", "제품", 1, 4));
		//System.out.println(dao.selectProductById("s-1", "p-1"));
		System.out.println("3 = " + dao.selectProductListBySellingOption("s-2", "Y", 1, 4));
		System.out.println(dao.selectProductList("s-2", 1, 15));
		
		System.out.println("===============Count===================");
		System.out.println("총 제품 개수 : " + dao.selectProductListCount("s-2"));
*/		///System.out.println("category : " + dao.selectProductListCountByMethod("s-1", "category", "빵"));
		//System.out.println("name : " + dao.selectProductListCountByMethod("s-1", "name", "제품1"));
		//System.out.println("id : " + dao.selectProductListCountByMethod("s-1", "id", "p-2"));
		//System.out.println("sellingOption : " + dao.selectProductListCountByMethod("s-1", "sellingOption", "Y"));
	/*	System.out.println("이상없음");
		
		System.out.println("4 : " + dao.selectProductListToPOS("s-4", "productName", ""));
*/                                                                                     
		                                
	 System.out.println(dao.selectProductListPagingByMethod("category","빵", "s-1", 1, 1000));

	
	}
    
	public static void main(String[] args) throws IOException {
		ProductDaoImplTest pd = (ProductDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("productDaoImplTest");
		pd.examTest();
	}
}
