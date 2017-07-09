package com.cnb.dao;


import java.util.List;

import com.cnb.vo.BoardReply;


/*
 *김형주
 * 2017-07-05
 * 생성
 */

public interface BoardReplyDao {

	
	/**
	 * 레시피 댓글 달기
	 * @param reply
	 * @return
	 */
	int insertBoardReplyToRecipeBoardNo(BoardReply boardReply);
	
	/**
	 * QNA게시판 댓글 달기.
	 * @param reply
	 * @param qnaBoardNo
	 * @return
	 */
	int insertBoardReplyToQnaBoardNo(BoardReply boardReply);
	
	
	/**
	 * 레시피게시판 댓글 수정
	 * @param reply
	 * @param recipeBoardNo
	 * @return
	 */
    int updateBoardReplyToRecipeBoardNo(BoardReply boardReply);
    
    
    /**
     * Qna게시판 댓글 수정.
     * @param reply
     * @param qnaBoardNo
     * @return
     */
      int updateBoardReplyToQnaBoardNo(BoardReply boardReply);
	
	

      /**
       * 레시피 게시판 댓글 삭제
       * @param replyNo
       * @param recipeBoardNo
       * @return
       */
      int deleteBoardReplyByRecipeBoardNo(int replyNo, int recipeBoardNo);

            
/**
 * qna게시판 댓글 삭제
 * @param replyNo
 * @param qnaBoardNo
 * @return
 */
      int deleteBoardReplyByQnaBoardNo(int replyNo, int qnaBoardNo);

	
 /**
  * 레시피 게시판별 댓글 개수
  * @param recipeBoardNo
  * @param replyNo
  * @return
  */
  	int countReplyBoardByRecipeBoardNo(int recipeBoardNo);
  	
  	
   /**
    * Qna 게시판별 댓글 개수.
    * @param QnaBoardNo
    * @return
    */
  	int countReplyBoardByQnaBoardNo(int QnaBoardNo);
  	
  	
      /**
       * 댓글 번호로 해당 댓글 조회
       * @param replyNo 댓글 번호
       * @return BoardReply 조회된 댓글
       */
  	BoardReply selectBoardReplyByreplyNo(int replyNo);
      
      
      
      /**
	  * 레시피 게시판 번호로 댓글목록 보여주기.
	  * @param recipeBoardNo
	  * @param startIndex
	  * @param endIndex
	  * @return
	  */
  	List<BoardReply> selectBoardReplyListByRecipeBoardNo(int recipeBoardNo,int startIndex, int endIndex);
  	/**
  	 * QNA 게시판 번호로 댓글 목록 보여주기. 
  	 * @param qnaBoardNo
  	 * @param startIndex
  	 * @param endIndex
  	 * @return
  	 */
  	List<BoardReply> selectBoardReplyListByQnaBoardNo(int qnaBoardNo,int startIndex, int endIndex);
  	
  	
  	
}
