package com.cnb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cnb.vo.BookMarkCardNum;
import com.cnb.vo.GeneralUser;

/*
 * 김형주
 * 2017-06-28
 * 초기 구현
 * 
 * 김형주
 * 2017-06-28 
 * 생성
 */
/**
 * BookMark_Card_num 테이블을 관리하는 Dao 인터페이스
 */
public interface BookMarkCardNumDao {
	
/**
 * 1개의 즐겨찾는 카드 등록
 * @param cardNum
 * @return
 */
	int insertCardNum(BookMarkCardNum bookMarkCardNum);
	
	  
	/**
	 * 즐겨찾는 카드 등록할때 이미 등록되있는건지 파악해서, 등록되있다면 이미등록되었다고 유저에게 알려주기위해 select
	 * @return
	 */
	List<BookMarkCardNum> selectCardNumListByUserId(String userId);
	

	/**
	 * 등록되있는 카드들을 조회한다음  잘 안쓰는것은 삭제.
	 * @param session
	 * @param isbn
	 * @return
	 */
	
	 int deleteCardNumByCardNumAndUserId(String cardNum,String userId);

	
	

}
