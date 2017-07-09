package com.cnb.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.exception.NotInputRecipeBoardPictureException;
import com.cnb.exception.QnaBoardContentsAuthenticationException;
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
  *  수정하려는 레시피 게시글의 번호
  * @param recipeBoardNo
  * @param recipeBoardContents
  * @return
  */
	int modifyRecipeBoardContents(int recipeBoardNo, RecipeBoardContents recipeBoardContents)throws ContentsNotFoundException, NotInputRecipeBoardPictureException ;
	

	/**
	 * 유저가 전체 글쓰는 곳에서 레시피게시글 지우기.
	 * 매장들어가서 지운다면 매장아이디를 받아서 매장 게시판 지우기.
	 */
	void removeRecipeBoardContents(int recipeBoardNo,Authentication authentication)throws ContentsNotFoundException, QnaBoardContentsAuthenticationException;
	 

	/*int removeRecipeBoardContentsByUserIdAndStoreId(String userId,String storeId,int recipeBoardNo);*/
	
	
	
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

	
	
	/**
	 * 레시피게시글마다 댓글리스트 달기.
	 * 
	 * @param recipeBoardNo
	 * @param page
	 * @return
	 */
	HashMap<String, Object> viewRecipeBoardContentsByReplyListService(int recipeBoardNo, int page) throws ContentsNotFoundException;
	
	
	/**
	 * 레시피 게시글번호로 레시피게시글 객체 
	 * @param recipeBoardNo
	 * @return
	 * @throws ContentsNotFoundException
	 */
    RecipeBoardContents findRecipeBoardContents(int recipeBoardNo) throws ContentsNotFoundException;
	
	
    
    
    
}
