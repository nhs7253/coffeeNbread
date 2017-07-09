package com.cnb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.BoardRecommendDao;
import com.cnb.dao.RecipeBoardContentsDao;
import com.cnb.exception.NotInputRecipeBoardWriterException;
import com.cnb.service.BoardRecommendService;
import com.cnb.vo.BoardRecommend;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-05
 * 생성
 */

@Service
public class BoardRecommendServiceImpl implements BoardRecommendService {

	@Autowired
	private  BoardRecommendDao dao;

	@Autowired
	private  RecipeBoardContentsDao rbcDao;
	
	//좋아요 색깔이 없을때  이 서비스 부름. 
	@Override
	public int modifyPlusBoardRecommendByRecipeNo(BoardRecommend boardRecommend) throws NotInputRecipeBoardWriterException {
           
		RecipeBoardContents recipeBoardContents=rbcDao.selectRecipeBoardContentsByrecipeBoardNo(boardRecommend.getRecipeBoardNo());
		System.out.println(recipeBoardContents);
		//레시피글을 작성한 사람을 구하려면  no를 통해 레시피 글 가져오기
		System.out.println("boardRecommend.getUserId():"+boardRecommend.getUserId());
		System.out.println("recipeBoardContents.getUserId()):"+recipeBoardContents.getGeneralUser().getUserId());
     
  
		  if(boardRecommend.getUserId().equals(recipeBoardContents.getGeneralUser().getUserId())){
			  throw new NotInputRecipeBoardWriterException("작성자는 본인의 글에 추천을 할수 없습니다.");
			}
		  System.out.println("recipeBoardContents.getRecommendCount():"+recipeBoardContents.getRecommendCount());
		   System.out.println("setter전-recipeBoardContents:"+recipeBoardContents);
 
		  recipeBoardContents.setRecommendCount(recipeBoardContents.getRecommendCount()+1);
		  
		  System.out.println("setter후-recipeBoardContents:"+recipeBoardContents);
		return dao.updatePlusBoardRecommend(recipeBoardContents.getRecommendCount(),boardRecommend.getRecipeBoardNo(),boardRecommend.getUserId());
	}

	
	//추천했다는 색깔이 있을경우만 적용가능 (그것도 자신에 한해서 한개 d감소)  색깔이 없을경우 눌러도 어떠한 컨트롤러로 가지 않게 ~
	@Override
	public int modifyMinusBoardRecommendByRecipeNo(BoardRecommend boardRecommend) throws NotInputRecipeBoardWriterException {
		
		RecipeBoardContents recipeBoardContents=rbcDao.selectRecipeBoardContentsByrecipeBoardNo(boardRecommend.getRecipeBoardNo());
		/*if(modifyPlusBoardRecommendByRecipeNo(boardRecommend)!=0){
			}  <--- 이방법은 UI적으로 구현하고자 하는게 힘들경우  쓸 조건식 */
		  System.out.println("setter전-recipeBoardContents:"+recipeBoardContents);

		recipeBoardContents.setRecommendCount(recipeBoardContents.getRecommendCount()-1);
		  System.out.println("setter후-recipeBoardContents:"+recipeBoardContents);

		return dao.updateMinusBoardRecommend(recipeBoardContents.getRecommendCount(),boardRecommend.getRecipeBoardNo(), boardRecommend.getUserId());
	}

	//유저가 추천한 레시피 게시글들 조회 가능하게 적용 ---추후 작업..

}
