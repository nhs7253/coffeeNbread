package com.cnb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.BoardReplyDao;
import com.cnb.dao.GeneralUserDao;
import com.cnb.exception.ProductPictureNotFoundException;
import com.cnb.service.BoardReplyService;
import com.cnb.util.PagingBean;
import com.cnb.vo.BoardReply;
import com.cnb.vo.QnaBoardContents;
import com.cnb.vo.RecipeBoardContents;

/*
 * 김형주
 * 2017-07-05
 * 생성
 */

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	private BoardReplyDao dao;

	private GeneralUserDao gDao;
	/* 레시피 게시판에 댓글 등록 */
	/*  댓글 쓰는 사람은 회원이기만 하면 됨 */
	@Override
	public int addBoardReplyToRecipeBoardNo(BoardReply boardReply) {
          //비회원일경우 댓글달기 버튼이 없게 controller에서 작업할것이므로 서비스쪽에서 따로 처리할 필요없음. 단순 등록작업.
		boardReply.setReplyRegDate(new Date());
		return dao.insertBoardReplyToRecipeBoardNo(boardReply);
	}

	/* qna 게시판에 댓글 등록 */
	@Override
	public int addBoardReplyToQnaBoardNo(BoardReply boardReply) {
		boardReply.setReplyRegDate(new Date());
		return dao.insertBoardReplyToQnaBoardNo(boardReply);
	}

	/* 레시피 게시판에 댓글 수정 */
	@Override
	public int modifyBoardReplyToRecipeBoardNo(BoardReply boardReply) {
        boardReply.setReplyRegDate(new Date());
		return dao.updateBoardReplyToRecipeBoardNo(boardReply);
	}

	/* qna 게시판에 댓글 수정 */
	@Override
	public int modifyBoardReplyToQnaBoardNo(BoardReply boardReply) {
        boardReply.setReplyRegDate(new Date());
		return dao.updateBoardReplyToQnaBoardNo(boardReply);
	}

	/* 레시피 게시판에 댓글 삭제 */
	@Override
	public int removeBoardReplyToRecipeBoardNo(int replyNo, int recipeBoardNo) {
		
		return dao.deleteBoardReplyByRecipeBoardNo(replyNo, recipeBoardNo);
	}

	/* qna 게시판에 댓글 삭제 */
	@Override
	public int removeBoardReplyToQnaBoardNo(int replyNo, int recipeBoardNo) {
		return dao.deleteBoardReplyByQnaBoardNo(replyNo,recipeBoardNo);
	}

	/* 레시피게시판에 적힌 댓글 목록 찾기 */
	@Override
	public HashMap<String, Object> findBoardReplyListByRecipeBoardContent(int page,int recipeBoardNo) {
		HashMap<String, Object> map = new HashMap<>();
		//item 수 - 레시피게시판에 달린 항목당 댓글개수 
        int totalCount= dao.countReplyBoardByRecipeBoardNo(recipeBoardNo);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<BoardReply> list =dao.selectBoardReplyListByRecipeBoardNo(recipeBoardNo, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		System.out.println("Service- 레시피게시판에 달린 댓글 리스트:"+list);
		map.put("list", list);
		return map;
	
	}

	/* qna게시판에 적힌 댓글 목록 찾기 */
	@Override
	public HashMap<String, Object> findBoardReplyListByQnaBoardContent(int page, int qnaBoardNo) {
		HashMap<String, Object> map = new HashMap<>();
		//item 수 - 레시피게시판에 달린 항목당 댓글개수 
        int totalCount= dao.countReplyBoardByQnaBoardNo(qnaBoardNo);
	    System.out.println("totalCount:"+totalCount);    
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);
		System.out.println("list전:");
		List<BoardReply> list =dao.selectBoardReplyListByQnaBoardNo(qnaBoardNo, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		System.out.println("Service- Qna게시판에 달린 댓글 리스트:"+list);
		map.put("list", list);
		return map;
	}

}
