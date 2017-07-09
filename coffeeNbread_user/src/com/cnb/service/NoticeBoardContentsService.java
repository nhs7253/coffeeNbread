package com.cnb.service;

import java.util.Map;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.vo.NoticeBoardContents;

/*
 * 노현식 
 * 2017-07-08 
 * 생성, 초기구현
 */
/**
 * 공지사항 게시판  서비스
 */
public interface NoticeBoardContentsService {

	/**
	 * 하나의 공지사항 글을 등록하는 서비스
	 * @param noticeBoardContents 등록할 공지사항 객체
	 */
	void addNoticeBoardContentsService(NoticeBoardContents noticeBoardContents);
	
	/**
	 * 하나의 공지사항 글을 수정하는 서비스
	 * @param noticeBoardContents 수정할 공지사항 객체
	 */
	void modifyNoticeBoardContentsService(NoticeBoardContents noticeBoardContents);
	
	/**
	 * 하나의 공지사항 글을 삭제하는 서비스
	 * @param noticeBoardNo 삭제할 글 번호
	 */
	void removeNoticeBoardContentsService(int noticeBoardNo);
	
	/**
	 * 유저가 입력한 키워드를 통해 조회한 공지사항 게시판 데이터를 페이징하여 보여주는 Service
	 * @param select 검색 종류 - 글 제목(title), 글 내용(content), 제목 + 내용(titleAndcontent)
	 * @param keyword 검색할 키워드
	 * @param page 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	Map<String, Object> findNoticeBoardContentsPagingListService(String select, String keyword, int page);
	
	/**
	 * 해당 글번호의 공지사항 글 객체를 조회하는 서비스
	 * @param noticeBoardNo 조회하고자 하는 글번호
	 * @return NoticeBoardContents 조회된 글번호에 대한 글 객체
	 * @throws ContentsNotFoundException 해당 글번호의 글이 없음
	 */
	NoticeBoardContents findNoticeBoardContentsByNoticeBoardNoService(int noticeBoardNo) throws ContentsNotFoundException;
	
	public NoticeBoardContents viewNoticeBoardContentsByNoticeBoardNoService(int noticeBoardNo) throws ContentsNotFoundException;
}
