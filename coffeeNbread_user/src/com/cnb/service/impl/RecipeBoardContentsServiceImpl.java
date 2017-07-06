package com.cnb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.dao.StoreDao;
import com.cnb.exception.NotInputRecipeBoardPictureException;
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.RecipeBoardContents;
import com.cnb.vo.Store;

/*
 * 김형주
 * 2017-07-04
 * 생성
 */
@Service
public class RecipeBoardContentsServiceImpl implements RecipeBoardContentsService {

	@Autowired
	private RecipeBoardContentsDao dao;
	
	@Autowired
	private StoreDao sDao;

	/* 유저가 매장에서 단순 등록 */
	@Override
	public int addRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		return dao.insertRecipeBoardContents(new RecipeBoardContents(recipeBoardContents.getRecipeBoardNo(),
				recipeBoardContents.getRecipeBoardContent(), recipeBoardContents.getRecipeBoardTitle(), new Date(), 0,
				recipeBoardContents.getRecipeBoardPicture(), 0,recipeBoardContents.getUserId(),recipeBoardContents.getStoreId()));
	}

	@Override
	public int modifyRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		if (recipeBoardContents.getRecipeBoardPicture().equals(null)) {
			// 나머지는 controller에서 적용 할 생각.
			new NotInputRecipeBoardPictureException("반드시 사진을 등록하세요");
		}
		recipeBoardContents.setRecipeBoardDate(new Date());
		return dao.updateRecipeBoardContents(recipeBoardContents);
	}

	@Override
	public int removeRecipeBoardContentsByUserId(String userId ,int recipeBoardNo) {
       return dao.deleteRecipeBoardContentsByRecipeBoardNo(userId, recipeBoardNo);
		
	}
	
	
   public int removeRecipeBoardContentsByUserIdAndStoreId(String userId,String storeId,int recipeBoardNo){
	   
	  return  dao.deleteRecipeBoardContentsByRecipeBoardNoAndStoreId(userId, storeId, recipeBoardNo);
   }

	/**
	 * 회원이든 비회원이든 레시피게시판 전체조회가능. method 가 없다면 전체조회.
	 * 
	 */
	@Override
	public HashMap<String, Object> findRecipeBoardContentsByMethod(int page,String method,Object methodContent) {
		
		HashMap<String, Object> map = new HashMap<>();
		// item 수

         /* 회원이든 비회원이든 방법에따라 전부다 조회 했을떄 나오는 개수 */
		int totalCount = dao.countSelectRecipeBoardContentsByMethod(method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<RecipeBoardContents> list =dao.selectRecipeBoardContentsListByMethod(method, methodContent, pageBean.getBeginItemInPage(),pageBean.getEndItemInPage());
		System.out.println("방법에의해 조회:"+list);
		map.put("list", list);
		return map;
	}

	 /**
	  *  회원이든 비회원이든 매장에서의 레시피게시판 조회가능 - method가 없다면 전체조회.
	  */
	@Override
	public HashMap<String, Object> findRecipeBoardContentsByStoreIdAndMethod(int page,String storeId,String method, Object methodContent) {
		
		HashMap<String, Object> map = new HashMap<>();
		// item 수
		System.out.println("method:"+method);
		System.out.println("methodContent:"+methodContent);
         /* 회원이든 비회원이든 방법에따라 전부다 조회 했을떄 나오는 개수 */
		int totalCount = dao.countSelectRecipeBoardContentsByStoreIdAndMethod(storeId, method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<RecipeBoardContents> list =dao.selectRecipeBoardContentsListByStoreIdAndMethod(storeId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		System.out.println("방법에의해 조회:"+list);
		map.put("list", list);
		return map;
	}
	
	/**
	 * 회원이 전체게시판에서 자신이 쓴글 조회가능. method 가 없다면 전체조회.
	 * 
	 */
	@Override
	public HashMap<String, Object> findRecipeBoardContentsByUserIdAndMethod(int page,String userId,String method,Object methodContent) {
		
		HashMap<String, Object> map = new HashMap<>();
		// item 수
		
         /* 회원이든 비회원이든 방법에따라 전부다 조회 했을떄 나오는 개수 */
		int totalCount = dao.countSelectRecipeBoardContentsByUserIdAndMethod(userId, method, methodContent);
	      
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		
		List<RecipeBoardContents> list =dao.selectRecipeBoardContentsListByUserIdAndMethod(userId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}

	 /**
	  *  회원이  매장에서의 자신이 쓴글 레시피게시판 조회가능 - method가 없다면 전체조회.
	  */
	@Override
	public HashMap<String, Object> findRecipeBoardContentsByUserIdAndStoreIdAndMethod(int page, String userId,String storeId,String method, Object methodContent) {
		
		HashMap<String, Object> map = new HashMap<>();
		// item 수
		System.out.println("method:"+method);
		System.out.println("methodContent:"+methodContent);
         /* 회원이든 비회원이든 방법에따라 전부다 조회 했을떄 나오는 개수 */
		int totalCount = dao.countSelectRecipeBoardContentsByUserIdAndStoreIdAndMethod(userId, storeId, method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<RecipeBoardContents> list =dao.selectRecipeBoardContentsListByUserIdAndStoreIdAndMethod(userId, storeId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	

}
