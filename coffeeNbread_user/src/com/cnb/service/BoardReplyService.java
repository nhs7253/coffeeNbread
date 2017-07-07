package com.cnb.service;

import java.util.HashMap;

import com.cnb.exception.ProductPictureNotFoundException;
import com.cnb.vo.BoardReply;
import com.cnb.vo.QnaBoardContents;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주 
 * 2017-07-05 생성
 */
public interface BoardReplyService {

	
	/**
	 * 1개의 레시피 게시판 댓글 추가 .
	 * @param reply
	 * @return
	 */
	int addBoardReplyToRecipeBoardNo(BoardReply boardReply); 
	
		
	/**
	 * 1개의 qna 게시판 댓글추가.
	 * 
	 */
	int addBoardReplyToQnaBoardNo( BoardReply boardReply); 

	/**
	 * 레시피게시판에 상세정보들어가서 댓글번호로 수정하여 업데이트.
	 * @param recipeBoardNo
	 * @param reply
	 * @return
	 */
	int modifyBoardReplyToRecipeBoardNo( BoardReply boardReply); 
	
	/**
	 *  qna게시판에 들어가서 댓글 번호로 수정하여 업데이트.
	 * @param productPicture
	 */
	int modifyBoardReplyToQnaBoardNo( BoardReply boardReply);
	
	
   /**
    * 레시피 게시판의 번호로 들어가서 댓글번호로  댓글 지우기.
    * @return
    */
	int removeBoardReplyToRecipeBoardNo(int replyNo, int recipeBoardNo) ;
	
	/**
	 * qna게시판의 번호로 들어가서  댓글번호로 댓글 지우기.
	 * @param qnaBoardNo
	 * @param replyNo
	 * @return
	 * @throws ProductPictureNotFoundException
	 */
	int removeBoardReplyToQnaBoardNo(int replyNo, int recipeBoardNo );

	  
	/**
	 * 레시피 게시판의 댓글 목록 찾기 -> 레시피 게시판마다 댓글들이 여러개 있는걸 찾기.
	 * @param page
	 * @param recipeBoardContents
	 * @return
	 */
      HashMap<String, Object> findBoardReplyListByRecipeBoardContent(int page, int recipeBoardNo);
	
	/**
	 * qna게시판의 댓글목록 찾기 -> qna게시판마다의 댓글들이 여러개 있는걸 찾기.
	 * @param userId
	 */
	  HashMap<String, Object> findBoardReplyListByQnaBoardContent(int page, int qnaBoardNo);
	
}
