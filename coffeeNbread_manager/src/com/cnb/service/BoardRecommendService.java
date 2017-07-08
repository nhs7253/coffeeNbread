package com.cnb.service;

import com.cnb.exception.NotInputRecipeBoardWriterException;
import com.cnb.vo.BoardRecommend;
import com.cnb.vo.BoardReply;

/*
 * 김형주 
 * 2017-07-05 생성
 */
public interface BoardRecommendService {

	

  /**
   * 추천수 증가 
   * @param boardRecommend
   * @return
   */
	int modifyPlusBoardRecommendByRecipeNo( BoardRecommend boardRecommend)  throws NotInputRecipeBoardWriterException; 
	

	/**
	 * 추천수 감소.
	 * @param boardRecommend
	 * @return
	 */
	int modifyMinusBoardRecommendByRecipeNo(BoardRecommend boardRecommend)throws NotInputRecipeBoardWriterException;
	
	
  
	
}
