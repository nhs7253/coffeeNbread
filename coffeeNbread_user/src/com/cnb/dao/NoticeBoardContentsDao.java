package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.NoticeBoardContents;

/*
 * 노현식
 * 2017-07-08
 * 페이징 추가
 * 
 * 최민희
 * 2017-06-28
 * 생성
 */
/**
 * NoticeBoardContents 테이블을 관리하는 Dao 인터페이스
 * @author minhee
 *
 */
public interface NoticeBoardContentsDao {
	/**
	 * 1개의 공지글 insert
	 * @param noticeBoardContents
	 * @return 처리 개수
	 */
	int insertNoticeBoardContents(NoticeBoardContents noticeBoardContents);
	
	/**
	 * 1개의 공지글 update
	 * @param noticeBoardContents
	 * @return 처리 개수
	 */
	int updateNoticeBoardContents(NoticeBoardContents noticeBoardContents);
	
	/**
	 * 1개의 공지글 delete
	 * @param noticeBoardNo
	 * @return 처리 개수
	 */
	int deleteNoticeBoardContentsByNoticeBoardNo(int noticeBoardNo);
	
	/**
	 * 내용으로 공지글들 select
	 * @param noticeBoardContent
	 * @return 조회된 공지글들
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardContent(String noticeBoardContent);
	
	/**
	 * 제목으로 공지글들 select
	 * @param noticeBoardTitle
	 * @return 조회된 공지글들
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardTitle(String noticeBoardTitle);
	
	/**
	 * 작성일로 공지글들 select
	 * @param noticeBoardDate
	 * @return 조회된 공지글들
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardDate(Date noticeBoardDate);
	
	/**
	 * 조회수로 공지글들 select
	 * @param noticeBoardHits
	 * @return 조회된 공지글들
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsListByNoticeBoardHits(int noticeBoardHits);
	
	/**
	 * 모든 공지글 select
	 * @param 
	 * @return 처리 개수
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsList();
	
	/**
	 * 공지사항 게시판의 게시글을 페이징 하여, 그 범위 만큼 내용을 반환  (paging) - content
	 * @param select 검색 종류 - 글 제목(title), 글 내용(content), 제목 + 내용(titleAndcontent)
	 * @param keyword 검색할 키워드
	 * @param startIndex 시작 컬럼 번호
	 * @param endIndex 끝 컬럼 번호
	 * @return 지정한 수만큼의 페이징한 결과
	 */
	List<NoticeBoardContents> selectNoticeBoardContentsBySelectAndKeywordPagingList(String select, String keyword, int startIndex, int endIndex);
	
	/**
	 * 공지사항 게시판의 게시글 페이징을 위한 검색 결과 개수를 리턴 (paging) - count
	 * @param select 검색 종류 - 글 제목(title), 글 내용(content), 제목 + 내용(titleAndcontent)
	 * @param keyword 검색할 키워드
	 * @return int 검색 결과 개수
	 */
	int selectNoticeBoardContentsBySelectAndKeywordPagingCount(String select, String keyword);
	
	/**
	 * 해당 noticeBoardNo번호로 해당 객체를 리턴
	 * @param noticeBoardNo 찾고자 하는 noticeBoardNo번호 (PK)
	 * @return NoticeBoardContents 찾은 객체
	 */
	NoticeBoardContents selectNoticeBoardContentsByNoticeBoardNo(int noticeBoardNo);
}
