package com.cnb.service;

import java.util.List;

import com.cnb.exception.BookCardNumDuplicationException;
import com.cnb.exception.DeleteBookMarkException;
import com.cnb.vo.BookMarkCardNum;

/*
 * 김형주 
 * 2017-06-30 생성
 */
public interface BookMarkCardNumService {

	
	
	void  addBookMarkCardNum(BookMarkCardNum cardNum) throws BookCardNumDuplicationException;
	
	
	
	List<BookMarkCardNum> findBookMarkCardNumListByUserId(String userId);
	
	
	void removeBookMarkCardNumByCardNumAndUserId(String cardNum,String userId)throws DeleteBookMarkException;
}
