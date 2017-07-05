package com.cnb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cnb.vo.PaymentDetails;
import com.cnb.vo.RecipeBoardContents;
import com.cnb.vo.ReservationDetails;

/*김형주
 * 2017-07-04
 * 새로 생성
 * 
 * 
 */
public interface RecipeBoardContentsService {
	
	
/*---------------------------------------------------------------------------------------------*/
  /**
   * 유저가 매장이 갖고있는 레시피 게시판에 들어가서 레시피게시글 등록.
   * @param userId
   * @param storeId
   * @return
   */
	int addRecipeBoardContents(RecipeBoardContents recipeBoardContents);
	
  /**
   * 유저가 매장에 매장에 등록한것을 수정하려고 한다.
   * @param userId
   * @param storeId
   * @return
   */
	int modifyRecipeBoardContents(RecipeBoardContents recipeBoardContents);
	

	/**
	 * 유저가 전체 글쓰는 곳에서 레시피게시글 지우기.
	 * 매장들어가서 지운다면 매장아이디를 받아서 매장 게시판 지우기.
	 */
	int removeRecipeBoardContentsByUserId(String userId,int recipeBoardNo);
	 
	/**
	 * 유저가 전체 글쓰는 곳에서 레시피게시글 지우기.
	 * 매장들어가서 지운다면 매장아이디를 받아서 매장 게시판 지우기.
	 */
	int removeRecipeBoardContentsByUserIdAndStoreId(String userId,String storeId,int recipeBoardNo);
	
	
	
	/**
	 * 회원이든 비회원이든 전체게시판에서 조회 -유저아이디 있든말든 상관없음.
	 * @param page
	 * @param method
	 * @param methodContent
	 * @return
	 */
	HashMap<String, Object> findRecipeBoardContentsByMethod(int page,String method,Object methodContent);
	
	
	/**
	 * 회원이든 비회원이든 매장별 게시판에서 조회 -유저아이디 상관없음.
	 * @param page
	 * @param storeId
	 * @param method
	 * @param methodContent
	 * @return
	 */
	
	HashMap<String, Object> findRecipeBoardContentsByStoreIdAndMethod(int page,String storeId,String method, Object methodContent);
	
	
	
	
	
	
	
	/**
	 * 회원이 전체게시판에서 내가 쓴글 조회 -방법별
	 * 
	 */
	HashMap<String, Object> findRecipeBoardContentsByUserIdAndMethod(int page, String userId,String method,Object methodContent);
   
	
	/**
	 * 회원이 매장별 내가 쓴 글 조회 - 방법별
	 * @param page
	 * @param userId
	 * @param storeId
	 * @param method
	 * @param methodContent
	 * @return
	 */
	HashMap<String, Object> findRecipeBoardContentsByUserIdAndStoreIdAndMethod(int page,String userId,String storeId,String method,Object methodContent);

   
}
