package com.cnb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.vo.ProductPicture;

@Controller
public class FileUploadController {
	


	
	//@ModelAttribute로 받기
	@RequestMapping("/uploadImage2")
	public String imageUpload2(@ModelAttribute ProductPicture productPicture, HttpServletRequest request, ModelMap map) throws Exception{
		//파일 이동 (임시 경로 -> 최종 경로(up_image))
		String destDir = request.getServletContext().getRealPath("/up_image");
		List<MultipartFile> list = productPicture.getProductPictureList();
		ArrayList<String> imageName = new ArrayList<>();	//업로드된 파일명을 저장할 list
		
		//업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
		for(int i = 0; i < list.size(); i++) {
			MultipartFile mFile = list.get(i);
			if(mFile != null && !mFile.isEmpty()) {	//업로드된 파일이 있는 경우
				imageName.add(mFile.getOriginalFilename());
				mFile.transferTo(new File(destDir, mFile.getOriginalFilename()));	//예외 던짐
			}
		}
		
		//다른 경로로 이동 -> 경로 변경
		//경로는 고정, 파일은 여러개 -> 파일 이름 저장
		
		map.addAttribute("imageName", imageName);
		return "response2";	//디스패치 방식
	}
	
}
