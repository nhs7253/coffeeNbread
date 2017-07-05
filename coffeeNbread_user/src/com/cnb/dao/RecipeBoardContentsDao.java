package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.EventProduct;
import com.cnb.vo.NoticeBoardContents;
import com.cnb.vo.RecipeBoardContents;


/*
 * 김형주
 * 2017-07-03
 * 초기생성
 */

public interface RecipeBoardContentsDao {
	/**
	 * 1개의 레시피 게시글 insert
	 * @param recipeBoardContents
	 * @return 처리 개수
	 */
	int insertRecipeBoardContents(RecipeBoardContents recipeBoardContents);
	
	/**
	 * 1개의 레시피 게시글 update
	 * @param recipeBoardContents
	 * @return 처리 개수
	 */
	int updateRecipeBoardContents(RecipeBoardContents recipeBoardContents);
	
	/**
	 * 전체 게시글에서 내가 쓴 레시피 글들 조회한다음 / 1개의 레시피 게시글 delete
	 * @param recipeBoardNo
	 * @return 처리 개수
	 */
	int deleteRecipeBoardContentsByRecipeBoardNo(String userId,int recipeBoardNo);
	 
    
	/**
	 * 유저가 매장들어가서 해당 매장에 있는 내가 적은 글 지우기.
	 * @param userId
	 * @param storeId
	 * @param recipeBoardNo
	 * @return
	 */
	int deleteRecipeBoardContentsByRecipeBoardNoAndStoreId(String userId,String storeId,int recipeBoardNo);
	
	
	/**
	 * 전체 레시피게시글에서 방법과 방법내용으로 찾는 개수.
	 *  회원, 비회원- 전체. - 회원아이디가 있다하더라도 어차피 넣는곳이 없으므로 비회원과 똑같은 개수나온다.
	 * @param method
	 * @param methodContent
	 * @return
	 */
	int countSelectRecipeBoardContentsByMethod(String method, Object methodContent);

	
 /**
  * 매장별 전체게시글을 조회할때 방법적으로 찾는개수.
  *  회원, 비회원
  */
	int countSelectRecipeBoardContentsByStoreIdAndMethod(String storeId,String method,Object methodContent);
	
	/* **********************************************************************/
	
	/**
	 * 유저가 전체게시글에서 자신이 쓴글 조회 개수.
	 * 회원-전체 .
	 * @param method
	 * @return
	 */
	int countSelectRecipeBoardContentsByUserIdAndMethod(String userId,String method, Object methodContent);
	
	
   /**
    * 유저가 매장별 자신이 쓴글 조회 개수.
    * 
    */
	
	int countSelectRecipeBoardContentsByUserIdAndStoreIdAndMethod(String userId,String storeId,String method, Object methodContent);
	
	
	
	
	/**
	 * 비회원, 회원 전체게시글에서 방법별로 보여주는것.
	 * 
	 * @param storeId
	 * @param method
	 * @return
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByMethod(String method,Object methodContent,int startIndex, int endIndex);

	
	 /**
	   * 비회원, 회원 -매장별 방법별로 보여주는것.
	   * @param storeId
	   * @param method
	   * @return
	   */
	List<RecipeBoardContents> selectRecipeBoardContentsListByStoreIdAndMethod(String storeId,String method,Object methodContent,int startIndex,int endIndex);
	

	
	/**
	 * 유저별 방법별로 전체게시글 조회.
	 * @param userId
	 * @param method
	 * @return
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByUserIdAndMethod(String userId,String method,Object methodContent,int startIndex,int endIndex);
	
    	
  /**
   * 유저가 매장에서 방법별 게시글 조회
   * @param storeId
   * @param method
   * @return
   */
	List<RecipeBoardContents> selectRecipeBoardContentsListByUserIdAndStoreIdAndMethod(String userId,String storeId,String method,Object methodContent,int startIndex,int endIndex);
	
	
	
	
	
	
	
	
	/*int selectRecipeBoardListPagingCountByMethod(String method, int startIndex, int endIndex);
	
	*//**
	 * 전체 목록 -방법에 의한 페이징 List
	 * @param method
	 * @param startIndex
	 * @param endIndex
	 * @return
	 *//*
	List<RecipeBoardContents> selectRecipeBoardContentsPagingListByMethod(String method,String methodContent, int startIndex, int endIndex);
	
	
	*//**
	 * 유저든 비회원이든 매장에 들어가서 조건별
	 * 매장- 전체목록-방법에 의한 페이징 개수
	 * @param storeId
	 * @param method
	 * @param startIndex
	 * @param endIndex
	 * @return
	 *//*
	int selectRecipeBoardContentsPagingCountByStoreIdAndMethod(String storeId,String method, int startIndex, int endIndex);
	
	*//**
	 * 매장- 전체목록 -방법에 의한 페이징 List
	 * @param storeId
	 * @param method
	 * @param startIndex
	 * @param endIndex
	 * @return
	 *//*
	List<RecipeBoardContents> selectRecipeBoardContentsListPagingByStoreIdAndMethod(String storeId, String method, int startIndex, int endIndex);*/
}
