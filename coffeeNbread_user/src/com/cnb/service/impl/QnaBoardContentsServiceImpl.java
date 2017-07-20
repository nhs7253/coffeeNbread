package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.BoardReplyDao;
import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.QnaBoardContentsDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.exception.ContentsNotFoundException;
import com.cnb.exception.QnaBoardContentsAuthenticationException;
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
	public void removeQnaBoardContents(int qnaBoardNo, Authentication authentication) throws ContentsNotFoundException, QnaBoardContentsAuthenticationException {
		QnaBoardContents qnaBoardContents = findQnaBoardContents(qnaBoardNo); //해당 게시글 객체 확인
		if(!(authentication.getAuthorities().toString().equals("[ROLE_CNB_ADMIN]"))){ //관리자라면 삭제 가능
			GeneralUser generalUser = (GeneralUser)authentication.getPrincipal(); //관리자가 아닐경우 유저 확인을 위해 로그인 정보 받음
			if(!qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()) && !(generalUser.getStoreId() != null || qnaBoardContents.getQnaStoreId().equals(generalUser.getStoreId()))){
				//내가 쓴글 이거나 && 매장 주인이면 삭제 가능 -> 둘 다 만족하지 못 할 시에 삭제 권한 X
				throw new QnaBoardContentsAuthenticationException("삭제 권한이 없습니다.");
			}
		}
		//삭제 권한 O -> 삭제
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
	public void modifyQnaBoardContents(int qnaBoardNo, QnaBoardContents qnaBoardContents) throws ContentsNotFoundException {
		QnaBoardContents content = qnaBoardContentsDao.selectQnaBoardContents(qnaBoardNo);
		if(content == null){
			throw new ContentsNotFoundException("해당 게시글을 찾을 수 없습니다.");
		}
		
		content.setQnaBoardTitle(qnaBoardContents.getQnaBoardTitle());
		content.setQnaBoardContent(qnaBoardContents.getQnaBoardContent());
		content.setQnaBoardSecret(qnaBoardContents.getQnaBoardSecret());
		qnaBoardContentsDao.updateQnaBoardContents(content);
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
	public Map<String, Object> viewQnaBoardContentsByReplyListService(int qnaBoardNo, int page, Authentication authentication) throws ContentsNotFoundException, QnaBoardContentsAuthenticationException {
				
		GeneralUser generalUser = null;
		QnaBoardContents qnaBoardContents = findQnaBoardContents(qnaBoardNo); //해당 게시글 객체 확인
		if(qnaBoardContents.getQnaBoardSecret().equals("Y")){
			if((authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))){
				throw new QnaBoardContentsAuthenticationException("비밀글 조회 권한이 없습니다.");
			}
			if(!(authentication.getAuthorities().toString().equals("[ROLE_CNB_ADMIN]"))){ 
				generalUser = (GeneralUser)authentication.getPrincipal(); //관리자가 아닐경우 유저 확인을 위해 로그인 정보 받음
				//전체 비밀글일 떼 && 본인이나 관리자가 아니라면
				if((qnaBoardContents.getQnaStoreId() == null) && !(qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId()) )){
					throw new QnaBoardContentsAuthenticationException("비밀글 조회 권한이 없습니다.");
				}
				//매장 비밀글일 때 && 본인이나 매장 주인이 아니라면		
				if(    (qnaBoardContents.getQnaStoreId() != null) && !(   qnaBoardContents.getQnaBoardWriter().equals(generalUser.getUserId())  ) && !(  generalUser.getStoreId() != null && qnaBoardContents.getQnaStoreId().equals(generalUser.getStoreId())   )  ){
								throw new QnaBoardContentsAuthenticationException("비밀글 조회 권한이 없습니다.");
				}
			}
			else if(qnaBoardContents.getQnaStoreId() != null){
				throw new QnaBoardContentsAuthenticationException("비밀글 조회 권한이 없습니다.");
			}
		}
		
		/////////////////// 권한 처리 ////////////////////////////
		HashMap<String, Object> map = new HashMap<>();
		//item 수 - 레시피게시판에 달린 항목당 댓글개수 
        int totalCount= boardReplyDao.countReplyBoardByQnaBoardNo(qnaBoardNo);
   
		PagingBean pageBean = new PagingBean(totalCount, page);
		map.put("pageBean", pageBean);

		List<BoardReply> list =boardReplyDao.selectBoardReplyListByQnaBoardNo(qnaBoardNo, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
	
		map.put("list", list);
		map.put("content", qnaBoardContentsDao.selectQnaBoardContents(qnaBoardNo));
		int hits = qnaBoardContents.getQnaBoardHits();
		qnaBoardContents.setQnaBoardHits(hits+1);
		qnaBoardContentsDao.updateQnaBoardContents(qnaBoardContents);
		return map;
	}

	@Override
	public QnaBoardContents findQnaBoardContents(int qnaBoardNo) throws ContentsNotFoundException {
		
		QnaBoardContents qnaBoardContents = qnaBoardContentsDao.selectQnaBoardContents(qnaBoardNo);
		if(qnaBoardContents == null){
			throw new ContentsNotFoundException("해당 글 정보를 찾을 수 없습니다.");
		}
		return qnaBoardContents;
	}
}
