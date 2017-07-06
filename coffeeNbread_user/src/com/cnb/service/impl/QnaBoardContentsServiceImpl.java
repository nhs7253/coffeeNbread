package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.BoardReplyDao;
import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.QnaBoardContentsDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.service.QnaBoardContentsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.BoardReply;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.QnaBoardContents;
import com.cnb.vo.UserAuthority;

/*
 * 노현식 
 * 2017-07-05 
 * 생성, 초기 구현
 */
@Service
public class QnaBoardContentsServiceImpl implements QnaBoardContentsService{
	
	@Autowired
	private QnaBoardContentsDao qnaBoardContentsDao;
	
	@Autowired
	private BoardReplyDao boardReplyDao;

	@Override
	public void addQnaBoardContents(QnaBoardContents qnaBoardContents) {
		qnaBoardContentsDao.insertQnaBoardContents(qnaBoardContents);
	}

	@Override
	public void removeQnaBoardContents(int qnaBoardNo) {
		qnaBoardContentsDao.deleteQnaBoardContents(qnaBoardNo);
	}
	
	@Override
	public void removeQnaBoardContentsAll() {
		qnaBoardContentsDao.deleteQnaBoardContentsAll();
	}
	
	@Override
	public List<QnaBoardContents> findQnaBoardContentsList() {
		return qnaBoardContentsDao.selectQnaBoardContentsList();
	}

	@Override
	public void modifyQnaBoardContents(QnaBoardContents qnaBoardContents) {
		qnaBoardContentsDao.updateQnaBoardContents(qnaBoardContents);
	}

	@Override
	public Map<String, Object> findQnaBoardContentsBySelectToKeyword(String select, String keyword, String storeId, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = qnaBoardContentsDao.selectQnaBoardContentsPagingCount(select, keyword, storeId);
		PagingBean pageBean = new PagingBean(tatalCount, page); //(tatalCount, page) - (전체 페이지 수, 보려는 페이지 번호)
		List<QnaBoardContents> list = qnaBoardContentsDao.selectQnaBoardContentsPagingList(select, keyword, storeId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> viewQnaBoardContentsByReplyListService(int qnaBoardNo, int page) {
		HashMap<String, Object> map = new HashMap<>();
		//item 수 - 레시피게시판에 달린 항목당 댓글개수 
        int totalCount= boardReplyDao.countReplyBoardByQnaBoardNo(qnaBoardNo);
   
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<BoardReply> list =boardReplyDao.selectBoardReplyListByQnaBoardNo(qnaBoardNo, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
	
		map.put("list", list);
		map.put("content", qnaBoardContentsDao.selectQnaBoardContents(qnaBoardNo));
		return map;
	}
}
