package com.cnb.service.impl.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnb.service.ProductPictureService;
import com.cnb.vo.ProductPicture;

/*
 * 최민희
 * 2017-07-01
 * 수정
 */
/*
 * 최민희
 * 2017-06-30
 * 생성
 */
public class ProductPictureServiceImplTest {
	public static void main(String[] args) throws Exception {
		//TODO ApplicationContext 객체 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml");
		
		//TODO Spring 컨테이너로 부터 ProductService bean 가져오기
		ProductPictureService service =  (ProductPictureService)ctx.getBean("productPictureServiceImpl");

/*		//제품 사진 등록
		//겹치는 거 없는 경우
		ProductPicture p1 = new ProductPicture("제품사진30", "p-7", "s-2");
		//제품 사진 정보 겹치는 경우
		ProductPicture p2 = new ProductPicture("제품사진7", "p-7", "s-2");

		try {
			//service.addProductPicture(p1);
			service.addProductPicture(p2);
			System.out.println("등록 성공");
		} catch (DuplicatedProudctPictureException e) {
			System.err.println(e.getMessage());
		}
*/

/*		//제품 사진 수정
		ProductPicture p3 = new ProductPicture("제품사진31", "p-7", "s-2");
		try {
			//수정할 제품이 있는 경우
			//service.modifyProductPictureByProductPicture(p3, "제품사진7");
			//수정할 제품 사진이 없는 경우
			service.modifyProductPictureByProductPicture(p3, "제품사진40");
			System.out.println("수정 성공");
		}catch(ProductPictureNotFoundException e) {
			System.err.println(e.getMessage());
		}
*/
		//제품 조회
	/*	System.out.println("==========조회==========");
		List<ProductPicture> list = service.findProductPictureListByProductIdAndStoreId("p-1", "s-1");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
	}
}
