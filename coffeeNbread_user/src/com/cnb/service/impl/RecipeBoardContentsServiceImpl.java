package com.cnb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.cnb.dao.BoardReplyDao;
import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.dao.StoreDao;
import com.cnb.exception.ContentsNotFoundException;
import com.cnb.exception.NotInputRecipeBoardPictureException;
import com.cnb.exception.QnaBoardContentsAuthenticationException;
import com.cnb.service.RecipeBoardContentsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.BoardReply;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.QnaBoardContents;
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
	private RecipeBoardContentsDao recipeDao;
	@Autowired
	private BoardReplyDao boardReplyDao;
	/* 유저가 매장에서 단순 등록 */
	@Override
	public int addRecipeBoardContents(RecipeBoardContents recipeBoardContents) {
		
		recipeBoardContents.setRecipeBoardHits(0);
		recipeBoardContents.setRecommendCount(0);
		return recipeDao.insertRecipeBoardContents(recipeBoardContents);
	}

	@Override
	public int modifyRecipeBoardContents(int recipeBoardNo,RecipeBoardContents recipeBoardContents) throws ContentsNotFoundException, NotInputRecipeBoardPictureException {
		RecipeBoardContents content = findRecipeBoardContents(recipeBoardNo);

		if(content == null){
			throw new ContentsNotFoundException("해당 게시글을 찾을 수 없습니다.");
		}
		
		content.setRecipeBoardTitle(recipeBoardContents.getRecipeBoardTitle());
		content.setRecipeBoardContent(recipeBoardContents.getRecipeBoardContent());
	//	content.setRecipeBoardPicture(recipeBoardContents.getRecipeBoardPicture());
	     recipeDao.updateRecipeBoardContents(content);
	    return recipeDao.updateRecipeBoardContents(content);

	}

	@Override
	public void removeRecipeBoardContents(int recipeBoardNo, Authentication authentication) throws ContentsNotFoundException, QnaBoardContentsAuthenticationException {
		RecipeBoardContents recipeBoardContents = findRecipeBoardContents(recipeBoardNo);
		if(!(authentication.getAuthorities().toString().equals("[ROLE_CNB_ADMIN]"))){ //관리자라면 삭제 가능
			GeneralUser generalUser = (GeneralUser)authentication.getPrincipal(); //관리자가 아닐경우 유저 확인을 위해 로그인 정보 받음
			if(!recipeBoardContents.getUserId().equals(generalUser.getUserId()) && !(generalUser.getStoreId() != null || recipeBoardContents.getStoreId().equals(generalUser.getStoreId()))){
				//내가 쓴글 이거나 && 매장 주인이면 삭제 가능 -> 둘 다 만족하지 못 할 시에 삭제 권한 X
				throw new QnaBoardContentsAuthenticationException("삭제 권한이 없습니다.");
			}
		}
		//삭제 권한 O -> 삭제
		System.out.println("------------222222222222222222222222222222222222");
		System.out.println("recipeBoardContents.getUserId():"+recipeBoardContents.getUserId());
		System.out.println("recipeBoardNo:"+recipeBoardNo);
		recipeDao.deleteRecipeBoardContentsByRecipeBoardNo(recipeBoardContents.getUserId(), recipeBoardNo);
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
		int totalCount = recipeDao.countSelectRecipeBoardContentsByMethod(method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<RecipeBoardContents> list =recipeDao.selectRecipeBoardContentsListByMethod(method, methodContent, pageBean.getBeginItemInPage(),pageBean.getEndItemInPage());
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
		int totalCount = recipeDao.countSelectRecipeBoardContentsByStoreIdAndMethod(storeId, method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		List<RecipeBoardContents> list =recipeDao.selectRecipeBoardContentsListByStoreIdAndMethod(storeId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		
		
		
		
		System.out.println("방법에의해 조회:"+list);
		map.put("list", list);
		return map;
	}
	

	@Override
	public HashMap<String, Object> findRecipeBoardContentsByUserIdAndMethod(int page,String userId,String method,Object methodContent) {
		
		HashMap<String, Object> map = new HashMap<>();
	   	int totalCount = recipeDao.countSelectRecipeBoardContentsByUserIdAndMethod(userId, method, methodContent);
	  	PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		map.put("userId", userId);
		List<RecipeBoardContents> list =recipeDao.selectRecipeBoardContentsListByUserIdAndMethod(userId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
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
		int totalCount = recipeDao.countSelectRecipeBoardContentsByUserIdAndStoreIdAndMethod(userId, storeId, method, methodContent);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<RecipeBoardContents> list =recipeDao.selectRecipeBoardContentsListByUserIdAndStoreIdAndMethod(userId, storeId, method, methodContent, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("list", list);
		return map;
	}
	@Override
	public HashMap<String, Object> viewRecipeBoardContentsByReplyListService(int recipeBoardNo, int page) throws ContentsNotFoundException {
		
		GeneralUser generalUser = null;
		RecipeBoardContents recipeBoardContents = findRecipeBoardContents(recipeBoardNo); //해당 게시글 객체 확인
		
		HashMap<String, Object> map = new HashMap<>();
		//item 수 - 레시피게시판에 달린 항목당 댓글개수 
        int totalCount= boardReplyDao.countReplyBoardByRecipeBoardNo(recipeBoardNo);
   
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<BoardReply> list =boardReplyDao.selectBoardReplyListByRecipeBoardNo(recipeBoardNo, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		 map.put("list", list);
		 map.put("content",recipeDao.selectRecipeBoardContentsByrecipeBoardNo(recipeBoardNo));
		 int hits = recipeBoardContents.getRecipeBoardHits();
	      recipeBoardContents.setRecipeBoardHits(hits+1);
		 recipeDao.updateRecipeBoardContents(recipeBoardContents);
		return map;
	}
	
	@Override
	public RecipeBoardContents findRecipeBoardContents(int recipeBoardNo) throws ContentsNotFoundException {
		
		RecipeBoardContents recipeBoardContents = recipeDao.selectRecipeBoardContentsByrecipeBoardNo(recipeBoardNo);
		if(recipeBoardContents == null){
			throw new ContentsNotFoundException("해당 글 정보를 찾을 수 없습니다.");
		}
		return recipeBoardContents;
	}
}
