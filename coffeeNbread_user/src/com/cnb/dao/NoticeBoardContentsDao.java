package com.cnb.dao;

import java.util.Date;
import java.util.List;

import com.cnb.vo.NoticeBoardContents;

/*
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
	int deleteNoticeBoardContentsByNoticeBoardNo(String noticeBoardNo);
	
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
}
