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
	 * 1개의 레시피 게시글 delete
	 * @param recipeBoardNo
	 * @return 처리 개수
	 */
	int deleteRecipeBoardContentsByRecipeBoardNo(String recipeBoardNo);
	

	
	
	/**
	 * 내용으로 레시판 게시글들 select
	 * @param recipeBoardContent
	 * @return 조회된 레시판게시글들
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardContent(String recipeBoardContent);
	
	/**
	 * 제목으로 레시판 게시들 select
	 * @param recipeBoardTitle
	 * @return 조회된 레시판게시글들
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardTitle(String recipeBoardTitle);
	
	/**
	 * 작성일로 레시판 게시글들 select
	 * @param recipeBoardDate
	 * @return 조회된 레시판게시글들
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardDate(Date recipeBoardDate);
	
	/**
	 * 조회수로 레시판 게시글들 select
	 * @param recipeBoardDate
	 * @return 조회된 레시판게시글들
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsListByRecipeBoardHits(int recipeBoardHits);
	
	/**
	 * 모든 레시판 게시글들 select
	 * @param 
	 * @return 처리 개수
	 */
	List<RecipeBoardContents> selectRecipeBoardContentsList();
}
