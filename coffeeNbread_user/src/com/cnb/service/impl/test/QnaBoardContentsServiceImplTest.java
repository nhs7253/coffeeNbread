package com.cnb.service.impl.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cnb.exception.UserManageException;
import com.cnb.service.GeneralUserService;
import com.cnb.service.QnaBoardContentsService;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.QnaBoardContents;

/*
 * 노현식 
 * 2017-07-06 
 * 생성, 초기 구현
 */
@Component
public class QnaBoardContentsServiceImplTest {
	
	@Autowired
	private QnaBoardContentsService service;
	
	public void Test() throws UserManageException {
		
		service.addQnaBoardContents(new QnaBoardContents(10,"service-qna-s-1", "service-qna-u-1", "service-qna-제목1", "service-qna-내용1-매장 비밀글", new Date(), 0, "Y"));
		service.addQnaBoardContents(new QnaBoardContents(11,"service-qna-s-1", "service-qna-u-1", "service-qna-제목2", "service-qna-내용2-매장 공개글", new Date(), 0, "N"));
		service.addQnaBoardContents(new QnaBoardContents(12,null, "service-qna-u-1", "service-qna-제목3", "service-qna-내용3-전체 비밀글", new Date(), 0, "Y"));
		service.addQnaBoardContents(new QnaBoardContents(13,null, "service-qna-u-1", "service-qna-제목4", "service-qna-내용4-전체 공개글", new Date(), 0, "N"));
		
		System.out.println("addQnaBoardContents 사용 후");
		System.out.println(service.findQnaBoardContentsList());
		
		
		
		System.err.println("제목");
		System.out.println("제목 - 매장");
			System.out.println("매장 = " + service.findQnaBoardContentsBySelectToKeyword("title", "제목", "service-qna-s-1", 1));
		System.out.println("제목 - 전체");
			System.out.println("전체 = " + service.findQnaBoardContentsBySelectToKeyword("title", "제목", null, 1));

		
	System.err.println("내용");
		System.out.println("내용 - 매장");
			System.out.println(service.findQnaBoardContentsBySelectToKeyword("content", "내용", "service-qna-s-1", 1));
		System.out.println("내용 - 전체");	
			System.out.println(service.findQnaBoardContentsBySelectToKeyword("content", "내용", null, 1));

		
	System.err.println("제목+내용");
		System.out.println("제목+내용 - 매장");
			System.out.println(service.findQnaBoardContentsBySelectToKeyword("titleAndcontent", "qna", "service-qna-s-1", 1));
		System.out.println("제목+내용 - 전체");	
			System.out.println(service.findQnaBoardContentsBySelectToKeyword("titleAndcontent", "qna", null, 1));
		
		
		
		System.out.println("=========== update =============");
											
		service.modifyQnaBoardContents(new QnaBoardContents(service.findQnaBoardContentsList().get(2).getQnaBoardNo(),"qna-s-1", "qna-u-1", "qna-매장 글로 변경 하는 마법의 제목4", "qna-내용4-매장 글로 변경 하는 마법의 내용", new Date(), 0, "N"));
		
		System.out.println("modifyQnaBoardContents 후 조회");
		System.out.println(service.findQnaBoardContentsList());
		System.out.println("전체 조회 개수 = " + service.findQnaBoardContentsList().size());
		
		System.out.println("=========== update 후 =============");
		
		System.out.println(service.findQnaBoardContentsBySelectToKeyword("titleAndcontent", "qna", "service-qna-s-1", 1));
		
		service.removeQnaBoardContents(service.findQnaBoardContentsList().get(1).getQnaBoardNo());
		service.removeQnaBoardContents(service.findQnaBoardContentsList().get(2).getQnaBoardNo());

		
		System.out.println("removeQnaBoardContents 후 조회");
		System.out.println(service.findQnaBoardContentsList());
		System.out.println("전체 조회 개수 = " + service.findQnaBoardContentsList().size());
		
		
		
		
		
		service.removeQnaBoardContentsAll();
		System.out.println("removeQnaBoardContentsAll 사용 후");
		System.out.println(service.findQnaBoardContentsList());
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!    이상 없음    !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public static void main(String[] args) throws UserManageException {
		
		QnaBoardContentsServiceImplTest gudit = 
				(QnaBoardContentsServiceImplTest)new ClassPathXmlApplicationContext("com/cnb/config/spring/model-context.xml").getBean("qnaBoardContentsServiceImplTest");
		gudit.Test();
		
	}
}
