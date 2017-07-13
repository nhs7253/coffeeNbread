package com.cnb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cnb.dao.BookMarkCardNumDao;
import com.cnb.exception.BookCardNumDuplicationException;
import com.cnb.exception.DeleteBookMarkException;
import com.cnb.service.BookMarkCardNumService;
import com.cnb.vo.BookMarkCardNum;

/*
 * 김형주
 * 2017-06-30 생성
 */
@Service
public class BookMarkCardNumServiceImpl implements BookMarkCardNumService {
	@Autowired
	private BookMarkCardNumDao dao;

	/**
	 * 즐겨찾는 카드 번호 등록할때 - 등록해놓은 bookMarkCardNum 이 없으면 등록 등록해놓은 bookMarkCardNum이
	 * 있다면 등록해놓은것과 비교해서 중복되면 예외처리 , 중복되지 않으면 등록.
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)

	public void addBookMarkCardNum(BookMarkCardNum bookMarkCardNum) throws BookCardNumDuplicationException {

		List<BookMarkCardNum> bookMarkCardNumList = dao.selectCardNumListByUserId(bookMarkCardNum.getUserId());

		if (bookMarkCardNumList.size() == 0) {
			dao.insertCardNum(bookMarkCardNum);
		} else {
			for (int i = 0; i < bookMarkCardNumList.size(); i++) {
				
				if (bookMarkCardNumList.get(i).equals(bookMarkCardNum)) {
					throw new BookCardNumDuplicationException(
							String.format("카드번호 %s 는  이미 등록 되있습니다.", bookMarkCardNum.getCardNum()));
				}
				
			}
			dao.insertCardNum(bookMarkCardNum);
		}
		
	}

	@Override
	public List<BookMarkCardNum> findBookMarkCardNumListByUserId(String userId) {

		return dao.selectCardNumListByUserId(userId);

	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void removeBookMarkCardNumByCardNumAndUserId(String cardNum, String userId) throws DeleteBookMarkException {

		List<BookMarkCardNum> bookMarkCardNumList = findBookMarkCardNumListByUserId(userId);

		if (bookMarkCardNumList.size() == 0) {
			throw new DeleteBookMarkException("삭제할 카드번호가 없습니다.");
		} 
			dao.deleteCardNumByCardNumAndUserId(cardNum,userId);
		

	}

}
