package com.cnb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnb.dao.NoticeBoardContentsDao;
import com.cnb.exception.ContentsNotFoundException;
import com.cnb.service.NoticeBoardContentsService;
import com.cnb.util.PagingBean;
import com.cnb.vo.NoticeBoardContents;

/*
 * 노현식 
 * 2017-07-08 
 * 생성, 초기 구현
 */
@Service
public class NoticeBoardContentsServiceImpl implements NoticeBoardContentsService{
	
	@Autowired
	private NoticeBoardContentsDao noticeBoardContentsDao;

	@Override
	public void addNoticeBoardContentsService(NoticeBoardContents noticeBoardContents) {
		noticeBoardContentsDao.insertNoticeBoardContents(noticeBoardContents);
	}

	@Override
	public void modifyNoticeBoardContentsService(NoticeBoardContents noticeBoardContents) {
		noticeBoardContentsDao.updateNoticeBoardContents(noticeBoardContents);
	}

	@Override
	public void removeNoticeBoardContentsService(int noticeBoardNo) {
		noticeBoardContentsDao.deleteNoticeBoardContentsByNoticeBoardNo(noticeBoardNo);
	}

	@Override
	public Map<String, Object> findNoticeBoardContentsPagingListService(String select, String keyword, int page) {
		Map<String, Object> map = new HashMap<>();
		int tatalCount = noticeBoardContentsDao.selectNoticeBoardContentsBySelectAndKeywordPagingCount(select, keyword);
		PagingBean pageBean = new PagingBean(tatalCount, page);
		List<NoticeBoardContents> list = noticeBoardContentsDao.selectNoticeBoardContentsBySelectAndKeywordPagingList(select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
		map.put("pageBean", pageBean);
		map.put("list", list);
		return map;
	}

	@Override
	public NoticeBoardContents findNoticeBoardContentsByNoticeBoardNoService(int noticeBoardNo) throws ContentsNotFoundException {
		NoticeBoardContents noticeBoardContents = noticeBoardContentsDao.selectNoticeBoardContentsByNoticeBoardNo(noticeBoardNo);
		if(noticeBoardContents == null){
			throw new ContentsNotFoundException("해당 공지사항 게시글을 찾을 수 없습니다.");
		}
		return noticeBoardContents;
	}

	@Override
	public NoticeBoardContents viewNoticeBoardContentsByNoticeBoardNoService(int noticeBoardNo) throws ContentsNotFoundException {
		NoticeBoardContents noticeBoardContents = findNoticeBoardContentsByNoticeBoardNoService(noticeBoardNo);
		int hits = noticeBoardContents.getNoticeBoardHits();
		noticeBoardContents.setNoticeBoardHits(hits+1);
		noticeBoardContentsDao.updateNoticeBoardContents(noticeBoardContents);
		return noticeBoardContents;
	}
	
	
	
}
