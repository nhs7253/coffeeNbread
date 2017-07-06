package com.cnb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.UserManageException;
import com.cnb.service.StoreService;
import com.cnb.validation.annotation.StoreRegisterForm;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;

/*
 * 이진영
 * 2017-07-05
 * 생성
 */

@Controller
public class StoreController {

	@Autowired
	private StoreService service;
	
	/**
	 * Store 기본 내용을 등록하는 Controller
	 * @param Store 요청파라미터 검증 Store 객체
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("addStoreController")
	public String addStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm, BindingResult errors) throws UserManageException, IllegalStateException, IOException{
		/*String destDir = request.getServletContext().getRealPath("/up_image");
		List<MultipartFile> list = storeRegisterForm.getStorePictureList();
		ArrayList<String> imageName = new ArrayList<>();//업로드된 파일명을 저장할 list
		
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
*/
		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);
		
		System.out.println("앞store = " + store);

		List<String> storeCategoryList = new ArrayList<String>(); 
		storeCategoryList.add(storeRegisterForm.getStoreCategoryList().get(0));

		StoreCategory storeCategoryList2= new StoreCategory(storeCategoryList.get(0),storeRegisterForm.getStoreId());
		List<StoreCategory> sclist = new ArrayList<StoreCategory>(); 
		sclist.add(storeCategoryList2);

		
		System.out.println("중간 store = " + store);
		
		List<String> optionCategoryList  = new ArrayList<String>();
		optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(0));

		OptionCategory optionCategoryList2= new OptionCategory(optionCategoryList.get(0),storeRegisterForm.getStoreId());
		List<OptionCategory> oplist = new ArrayList<OptionCategory>(); 
		oplist.add(optionCategoryList2);
		
	/*	for(int i = 0;i<storeRegisterForm.getOptionCategoryList().size();i++){
			optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(i));
		}*/
		
		System.out.println("뒤store = " + store);
		//사진리스트
		/*List<StorePicture> storePictureList  = new ArrayList<StorePicture>();
		for(int i = 0;i<storeRegisterForm.getStorePictureList().size();i++){
			storePictureList.add(storeRegisterForm.getStorePictureList().get(i));
		}
		*/
		
		try {
			service.addStore(store,sclist,oplist/*,storePictureList*/);
		} catch (DuplicatedStoreIdException | DuplicatedOptionCategoryNameException
				| DuplicatedStoreCategorytNameException | DuplicatedStorePictureException e) {
			System.out.println(e.getMessage());
		}
		return "store/store_success.tiles";
	}
}
