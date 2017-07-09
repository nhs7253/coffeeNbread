package com.cnb.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cnb.exception.ContentsNotFoundException;
import com.cnb.service.NoticeBoardContentsService;
import com.cnb.validation.annotation.NoticeBoardContentsForm;
import com.cnb.validation.annotation.NoticeBoardContentsViewForm;
import com.cnb.vo.NoticeBoardContents;

/*
 * 노현식 
 * 2017-07-08
 * 생성, 초기 구현
 */

@Controller
public class NoticeBoardContentsController {

	@Autowired
	private NoticeBoardContentsService noticeBoardContentsService;
	
	/**
	 * 1개의 공지사항을 추가하는 컨드롤러
	 * @param noticeBoardContentsForm 유저로 부터 입력받은 공지사항 제목과 내용
	 * @param errors 요청파라미터 에러
	 * @return 반환 경로
	 */
	@RequestMapping("/admin/addNoticeBoardContentsController")
	public String addNoticeBoardContentsController(@ModelAttribute("noticeBoardContents") @Valid NoticeBoardContentsForm noticeBoardContentsForm, BindingResult errors){		
		if(errors.hasErrors()){
			return "redirect:/common/findNoticeBoardContentsPagingListController.do";
		}
		
		NoticeBoardContents noticeBoardContents = new NoticeBoardContents();
		BeanUtils.copyProperties(noticeBoardContentsForm, noticeBoardContents);
		noticeBoardContents.setNoticeBoardDate(new Date());
				
		noticeBoardContentsService.addNoticeBoardContentsService(noticeBoardContents);
		
		return "redirect:/common/findNoticeBoardContentsPagingListController.do";
	}
	
	/**
	 * 1개의 공지사항을 수정하는 컨드롤러
	 * @param noticeBoardContentsForm 수정할 공지사항 제목과 내용
	 * @param errors 요청파라미터 에러
	 * @return 반환 경로
	 */
	@RequestMapping("/admin/modifyNoticeBoardContentsController")
	public String modifyNoticeBoardContentsController(@ModelAttribute("noticeBoardContents") @Valid NoticeBoardContentsForm noticeBoardContentsForm, BindingResult errors){
		if(errors.hasErrors()){
			return "redirect:/common/viewNoticeBoardContentsController.do?noticeBoardNo="+noticeBoardContentsForm.getNoticeBoardNo();
		}
		try {
			NoticeBoardContents noticeBoardContents = noticeBoardContentsService.findNoticeBoardContentsByNoticeBoardNoService(noticeBoardContentsForm.getNoticeBoardNo());
			noticeBoardContents.setNoticeBoardTitle(noticeBoardContentsForm.getNoticeBoardTitle());
			noticeBoardContents.setNoticeBoardContent(noticeBoardContentsForm.getNoticeBoardContent());
			noticeBoardContentsService.modifyNoticeBoardContentsService(noticeBoardContents);
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/viewNoticeBoardContentsController.do?noticeBoardNo="+noticeBoardContentsForm.getNoticeBoardNo();
		}
		return "redirect:/common/viewNoticeBoardContentsController.do?noticeBoardNo="+noticeBoardContentsForm.getNoticeBoardNo();
	}
	
	/**
	 * 공지사항을 수정하기 위해, 해당 글 객체를 request에 바인딩 해주는 컨드롤러
	 * @param noticeBoardNo 조회할 해 당 글 번호
	 * @param request 바인딩 할 객체
	 * @return 반환 경로
	 */
	@RequestMapping("/admin/modifySettingNoticeBoardContentsController")
	public String modifySettingNoticeBoardContentsController(@RequestParam(value="noticeBoardNo", required=false) Integer noticeBoardNo, HttpServletRequest request){
		if(noticeBoardNo == null){
			return "redirect:/common/viewNoticeBoardContentsController.do?noticeBoardNo="+noticeBoardNo;
		}
		try {
			request.setAttribute("noticeBoardContents", noticeBoardContentsService.findNoticeBoardContentsByNoticeBoardNoService(noticeBoardNo));
		} catch (ContentsNotFoundException e) {
			return "redirect:/common/viewNoticeBoardContentsController.do?noticeBoardNo="+noticeBoardNo;
		}
	
		return "admin/notice_board_update_form.tiles";
	}
	
	/**
	 * 1개의 글을 삭제해주는 컨드롤러
	 * @param noticeBoardNo 삭제할 공지사항의 글 번호 
	 * @return 반환 경로
	 */
	@RequestMapping("/admin/removeNoticeBoardContentsController")
	public String removeNoticeBoardContentsController(@RequestParam(value="noticeBoardNo", required=false) Integer noticeBoardNo){
		if(noticeBoardNo == null){
			return "redirect:/common/findNoticeBoardContentsPagingListController.do";
		}
		noticeBoardContentsService.removeNoticeBoardContentsService(noticeBoardNo);
		return "redirect:/common/findNoticeBoardContentsPagingListController.do";
	}
	
	/**
	 * 공지사항 목록을 페이징 하여 보여주는 컨드롤러
	 * @param noticeBoardContentsViewForm (select 검색 종류 - 글 제목(title), 글 내용(content), 제목 + 내용(titleAndcontent) keyword 검색 내용, 볼 페이지) 
	 * @param errors 요청파라미터 에러
	 * @return 반환 경로
	 */
	@RequestMapping("/common/findNoticeBoardContentsPagingListController")
	public ModelAndView findNoticeBoardContentsPagingListController(@ModelAttribute("noticeBoardContentsView") @Valid NoticeBoardContentsViewForm noticeBoardContentsViewForm, BindingResult errors){
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("index.tiles");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		
		Map<String, Object> map = noticeBoardContentsService.findNoticeBoardContentsPagingListService(noticeBoardContentsViewForm.getSelect(), noticeBoardContentsViewForm.getKeyword(), noticeBoardContentsViewForm.getPage());
		
		modelAndView.setViewName("common/notice_board_list.tiles");
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("pageBean", map.get("pageBean"));
		modelAndView.addObject("keyword", noticeBoardContentsViewForm.getKeyword());
		modelAndView.addObject("select", noticeBoardContentsViewForm.getSelect());
		
		return modelAndView;
	}
	
	/**
	 * 해당 공지사항의 내용을 보여주는 컨트롤러
	 * @param noticeBoardNo 보고자 하는 공지사항 글 번호
	 * @return 반환 경로
	 */
	@RequestMapping("/common/viewNoticeBoardContentsController")
	public ModelAndView viewNoticeBoardContentsController(@RequestParam(value="noticeBoardNo", required=false) Integer noticeBoardNo){
		ModelAndView modelAndView = new ModelAndView();
		
		if(noticeBoardNo == null){
			modelAndView.setViewName("redirect:/common/findNoticeBoardContentsPagingListController.do");
			return modelAndView; //에러 발생 시 이동할 경로
		}
		NoticeBoardContents noticeBoardContents;
		try {
			noticeBoardContents = noticeBoardContentsService.viewNoticeBoardContentsByNoticeBoardNoService(noticeBoardNo);
		} catch (ContentsNotFoundException e) {
			modelAndView.setViewName("redirect:/common/findNoticeBoardContentsPagingListController.do");
			return modelAndView; //에러 발생 시 이동할 경로
		}
				
		modelAndView.setViewName("common/notice_board_view.tiles"); //성공 시 이동할 경로
		modelAndView.addObject("noticeBoardContents", noticeBoardContents);
		
		
		return modelAndView;
	}

}
