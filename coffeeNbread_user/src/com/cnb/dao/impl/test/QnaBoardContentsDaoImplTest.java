package com.cnb.dao.impl.test;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.dao.QnaBoardContentsDao;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식 
 * 2017-07-05 
 * 생성, 초기 구현
 */
@Component
public class QnaBoardContentsDaoImplTest {
	
	@Autowired
	private QnaBoardContentsDao dao;
	
	public QnaBoardContentsDaoImplTest() {
	}
	
	public QnaBoardContentsDaoImplTest(QnaBoardContentsDao dao) {
		this.dao = dao;
	}

	public void Test(){
		System.out.println("최초 조회");
		System.out.println(dao.selectQnaBoardContentsList());
		System.out.println("전체 조회 개수 = " + dao.selectQnaBoardContentsList().size());
		
		dao.insertQnaBoardContents(new QnaBoardContents(10,"qna-s-1", "qna-u-1", "qna-제목1", "qna-내용1-매장 비밀글", new Date(), "0", "Y"));
		dao.insertQnaBoardContents(new QnaBoardContents(11,"qna-s-1", "qna-u-1", "qna-제목2", "qna-내용2-매장 공개글", new Date(), "0", "N"));
		dao.insertQnaBoardContents(new QnaBoardContents(12,null, "qna-u-1", "qna-제목3", "qna-내용3-전체 비밀글", new Date(), "0", "Y"));
		dao.insertQnaBoardContents(new QnaBoardContents(13,null, "qna-u-1", "qna-제목4", "qna-내용4-전체 공개글", new Date(), "0", "N"));
		System.out.println("insertQnaBoardContents 후 조회");
		System.out.println(dao.selectQnaBoardContentsList());
		System.out.println("전체 조회 개수 = " + dao.selectQnaBoardContentsList().size());
		
		System.out.println("=========================================================");
		
		System.err.println("selectQnaBoardContentsPagingList 조회 : ");
		
		System.err.println("제목");
			System.out.println("제목 - 매장");
				System.out.println("매장 = " + dao.selectQnaBoardContentsPagingList("title", "제목", "qna-s-1", 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", "qna-s-1"));
			System.out.println("제목 - 전체");
				System.out.println("전체 = " + dao.selectQnaBoardContentsPagingList("title", "제목", null, 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", null));

			
		System.err.println("내용");
			System.out.println("내용 - 매장");
				System.out.println(dao.selectQnaBoardContentsPagingList("content", "내용", "qna-s-1", 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", "qna-s-1"));
			System.out.println("내용 - 전체");	
				System.out.println(dao.selectQnaBoardContentsPagingList("content", "내용", null, 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", null));

			
		System.err.println("제목+내용");
			System.out.println("제목+내용 - 매장");
				System.out.println(dao.selectQnaBoardContentsPagingList("titleAndcontent", "qna", "qna-s-1", 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", "qna-s-1"));
			System.out.println("제목+내용 - 전체");	
				System.out.println(dao.selectQnaBoardContentsPagingList("titleAndcontent", "qna", null, 1, 10));
				System.out.println("selectQnaBoardContentsPagingCount : " + dao.selectQnaBoardContentsPagingCount("title", "제목", null));


		dao.deleteQnaBoardContentsAll();
		System.out.println("deleteQnaBoardContentsAll 후 조회");
		System.out.println(dao.selectQnaBoardContentsList());
		System.out.println("전체 조회 개수 = " + dao.selectQnaBoardContentsList().size());
		
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	public void listView(List <QnaBoardContents> list){
		for(QnaBoardContents view : list){
			System.out.println(list);
		}
		System.out.println("=================");
	}


	public static void main(String [] args){
		QnaBoardContentsDaoImplTest gudit = (QnaBoardContentsDaoImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("qnaBoardContentsDaoImplTest");
		gudit.Test();
		 
	}
}
