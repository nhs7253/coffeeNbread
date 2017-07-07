package com.cnb.service;

import java.util.List;
import java.util.Map;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식 
 * 2017-07-05
 * 생성, 초기 구현
 */
public interface QnaBoardContentsService {

	/**
	 * 하나의 Q&A게시글을 등록해 주는 서비스
	 * @param qnaBoardContents 추가할 게시글
	 */
	void addQnaBoardContents(QnaBoardContents qnaBoardContents);
	
	/**
	 * 하나의 게시글을 삭제해주는 서비스
	 * @param qnaBoardNo int 삭제할 게시글 번호
	 */
	void removeQnaBoardContents(int qnaBoardNo);
	
	
	/**
	 * 전체 게시글을 삭제하는 서비스 (테스트 용)
	 */
	void removeQnaBoardContentsAll();
	
	/**
	 *  
	 * @param qnaBoardContents 수정할 게시글 내용
	 */
	
	/**
	 * 하나의 게시글을 수정해주는 서비스 
	 * @param qnaBoardNo 수정 하고자 하는 객체 조회를 위한 키
	 * @param qnaBoardContents 수정할 게시글 내용 담긴 객체
	 * @throws ContentsNotFoundException 해당 게시글을 찾을 수 없음
	 */
	void modifyQnaBoardContents(int qnaBoardNo, QnaBoardContents qnaBoardContents) throws ContentsNotFoundException;
	
	/**
	 * 전체 Q&A 목록을 모두 반환하는 서비스 (테스트 용)
	 */
	List<QnaBoardContents> findQnaBoardContentsList();
	
	/**
	 * Q&A 게시판의 게시글에 대해 유저가 입력한 키워드를 통해 조회한 데이터를 페이징하여 보여주는 Service - 매장과 전체 Q&A 접근은 컨트롤러에서 storeId가 있고 없고로 구분 할것 
	 * @param select 검색 종류 - 글 제목(title), 글 내용(content), 제목 + 내용(titleAndcontent)
	 * @param keyword 검색할 키워드
	 * @param storeId ID가 있다면 해당 매장 글, 없다면 전체 Q&A글
	 * @param page 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	Map<String, Object> findQnaBoardContentsBySelectToKeyword(String select, String keyword, String storeId, int page);
	
	/**
	 * Q&A 게시글의 내용과 댓글 목록을 조회하는 서비스
	 * @param qnaBoardNo int 글 번호
	 * @param page int 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	Map<String, Object> viewQnaBoardContentsByReplyListService(int qnaBoardNo, int page);
	
	/**
	 * 글 번호를 통해 해당 글을 조회하는 서비스
	 * @param qnaBoardNo int 조회할 글 번호
	 * @return 조회된 글번호
	 * @throws ContentsNotFoundException 해당 글을 찾을 수 없는 경우 발생
	 */
	QnaBoardContents findQnaBoardContents(int qnaBoardNo) throws ContentsNotFoundException;
}
