package com.cnb.dao;


import com.cnb.vo.BoardRecommend;
import com.cnb.vo.RecipeBoardContents;


/*김형주
 * 2017-07-06
 * 구현.
 */

/*
 *김형주
 * 2017-07-05
 * 생성
 */

public interface BoardRecommendDao {

	/**
	 * 추천수 늘릴때 쓰일것.
	 * @param boardRecommend
	 * @return
	 */
    int updatePlusBoardRecommend(int recommendCount,int recipeBoardNo ,String recommendWriterId);
    
    /**
     * 추천지울때 쓰일것 .
     * @param boardRecommend
     * @return
     */
	 int updateMinusBoardRecommend(int recommendCount,int recipeBoardNo, String recommendWriterId) ;

}
