package com.cnb.dao;

import java.util.List;

import com.cnb.vo.QnaBoardContents;

/*
 * 노현식
 * 2017-07-05
 * 초기 구현
 * 
 * 김형주
 * 2017-06-29
 * 생성
 */
/**
 * QnaBoardContent 테이블을 관리하는 Dao 인터페이스
 *
 */
/**
 * 질의게시판을 관리하는 DAO
 * qnaBoardSecret
 * 비밀글 o : Y
 * 비밀글 x : N
 */
public interface QnaBoardContentsDao {
	
	/**
	 * Q&A 게시판에 글을 등록
	 * @param qnaBoardContents 등록한 Q&A 게시글 객체
	 * @return int 처리 개수
	 */
	int insertQnaBoardContents(QnaBoardContents qnaBoardContents);
	
	/**
	 * 해당 게시글 삭제
	 * @param qnaBoardNo int - 게시글 번호
	 * @return int 처리 개수
	 */
	int deleteQnaBoardContents(int qnaBoardNo);
	
	/**
	 * Test용 전체 삭제
	 * @return int 처리 개수
	 */
	int deleteQnaBoardContentsAll();
	
	/**
	 * Q&A 게시판 등록한 글을 수정
	 * @param qnaBoardContents 수정된 Q&A 게시글 객체
	 * @return int 처리 개수
	 */
	int updateQnaBoardContents(QnaBoardContents qnaBoardContents);
	
	/**
	 * Test를 위한 전체 조회
	 * @return List<QnaBoardContents> 전체 반환
	 */
	List<QnaBoardContents> selectQnaBoardContentsList();
	
	/**
	 * Q&A 게시판의 게시글 페이징을 위한 검색 결과 개수를 리턴 (paging)
	 * @param select 검색 종류 - 글 제목, 글 내용, 제목 + 내용
	 * @param keyword 검색할 키워드
	 * @param storeId ID가 있다면 해당 매장 글, 없다면 전체 Q&A글
	 * @return int 검색 결과 개수
	 */
	int selectQnaBoardContentsPagingCount(String select, String keyword, String storeId);
	
	/**
	 * Q&A 게시판의 게시글 페이징을 위한 검색 결과 개수를 리턴 (paging)
	 * @param select 검색 종류 - 글 제목, 글 내용, 제목 + 내용
	 * @param keyword 검색할 키워드
	 * @param storeId ID가 있다면 해당 매장 글, 없다면 전체 Q&A글
	 * @param startIndex 시작 컬럼 번호
	 * @param endIndex 끝 컬럼 번호
	 * @return 지정한 수만큼의 페이징한 결과
	 */
	List<QnaBoardContents> selectQnaBoardContentsPagingList(String select, String keyword, String storeId, int startIndex, int endIndex);
}

