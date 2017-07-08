package com.cnb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cnb.exception.DuplicatedOptionCategoryNameException;
import com.cnb.exception.DuplicatedStoreCategorytNameException;
import com.cnb.exception.DuplicatedStoreIdException;
import com.cnb.exception.DuplicatedStorePictureException;
import com.cnb.exception.StorePictureNotFoundException;
import com.cnb.exception.UserManageException;
import com.cnb.service.StoreService;
import com.cnb.validation.annotation.StoreRegisterForm;
import com.cnb.vo.OptionCategory;
import com.cnb.vo.Store;
import com.cnb.vo.StoreCategory;
import com.cnb.vo.StorePicture;

/*이진영
 * 2017-07-06
 * storeCategory controller 추가
 * optionCategory controller 추가
 * 
 * 이진영
 * 2017-07-05
 * 생성
 */

@Controller
public class StoreController {

	@Autowired
	private StoreService service;

	private String eclipseDir = "C:\\javaexam\\coffeeNbread_user\\WebContent\\up_images"; 

	/**
	 * Store 매장 전체를 등록하는 Controller
	 * 
	 * @param Store
	 *            요청파라미터 검증 Store 객체
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("addStoreController")
	public String addStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request, ModelMap map)
			throws Exception {
		if (errors.hasErrors()) {
			return "store/store_register.tiles";
		}

		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);
		
		System.out.println("store = " + store);
		// storeCategory 등록
		List<String> storeCategoryList = new ArrayList<String>();
		List<StoreCategory> sclist = new ArrayList<StoreCategory>();

		for (int i = 0; i < storeRegisterForm.getStoreCategoryList().size(); i++) {
			storeCategoryList.add(storeRegisterForm.getStoreCategoryList().get(i));
			StoreCategory storeCategoryList2 = new StoreCategory(storeCategoryList.get(i),
					storeRegisterForm.getStoreId());
			sclist.add(storeCategoryList2);
		}

		/*// optionCategory 등록
		List<String> optionCategoryList = new ArrayList<String>();
		optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(0));

		OptionCategory optionCategoryList2 = new OptionCategory(optionCategoryList.get(0),
				storeRegisterForm.getStoreId());
		List<OptionCategory> oplist = new ArrayList<OptionCategory>();
		oplist.add(optionCategoryList2);
*/
	
		
		  // storePicture 등록
	      String destDir = request.getServletContext().getRealPath("/up_image");

	      List<MultipartFile> list = storeRegisterForm.getStorePictureList();
	      ArrayList<String> imageName = new ArrayList<>();// 업로드된 파일명을 저장할 list
	      

	      // 업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
	      for (int i = 0; i < list.size(); i++) {
	         MultipartFile mFile = list.get(i);
	         if (mFile != null && !mFile.isEmpty()) { // 업로드된 파일이 있는 경우
	            imageName.add(mFile.getOriginalFilename());
	            mFile.transferTo(new File(destDir, mFile.getOriginalFilename())); // 예외
	                                                               // 던짐

	         }
	      }

	      // 다른 경로로 이동 -> 경로 변경
	      // 경로는 고정, 파일은 여러개 -> 파일 이름 저장
	      // map.addAttribute("imageName", imageName);

	    StorePicture storePicture = new StorePicture(imageName.get(0), storeRegisterForm.getStoreId());

	      System.out.println("store = " + store);

			// 세션으로 묶음
		HttpSession session = request.getSession();
		session.setAttribute("store", store);
	      try {
	         service.addStore(store, sclist, storePicture);
	      } catch (DuplicatedStoreIdException | DuplicatedOptionCategoryNameException
	            | DuplicatedStoreCategorytNameException | DuplicatedStorePictureException e) {
	         System.out.println(e.getMessage());
	      }
	      return "store/store_success.tiles";

	}
		

	
	
	/**
	 * store매장을 수정하는 controller
	 * 
	 * @param storeRegisterForm
	 * @param errors
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("modifyStoreController")
	public String modifyStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request) throws IllegalStateException, IOException {

		Store store = new Store();
		BeanUtils.copyProperties(storeRegisterForm, store);

		// 매장 분류 수정
		List<String> storeCategoryList = new ArrayList<String>();
		List<StoreCategory> sclist = new ArrayList<StoreCategory>();

		for (int i = 0; i < storeRegisterForm.getStoreCategoryList().size(); i++) {
			storeCategoryList.add(storeRegisterForm.getStoreCategoryList().get(i));
			StoreCategory storeCategoryList2 = new StoreCategory(storeCategoryList.get(i),
					storeRegisterForm.getStoreId());
			sclist.add(storeCategoryList2);
		}
		/*
		// 옵션카테고리 수정 - 수정하지 않은 카테고리 세부 내용의 option id를 이름이 같은 바꾼 객체의 option id로
		// 바꾼다
		List<String> optionCategoryList = new ArrayList<String>();
		optionCategoryList.add(storeRegisterForm.getOptionCategoryList().get(0));

		OptionCategory optionCategoryList2 = new OptionCategory(optionCategoryList.get(0),
				storeRegisterForm.getStoreId());
		List<OptionCategory> oplist = new ArrayList<OptionCategory>();
		oplist.add(optionCategoryList2);

		
		*/
		//사진 수정 삭제 및 재업로드 
		// storePicture 등록
		String destDir = request.getServletContext().getRealPath("/up_image");

		List<MultipartFile> list = storeRegisterForm.getStorePictureList();
		ArrayList<String> imageName = new ArrayList<>();// 업로드된 파일명을 저장할 list

		// 업로드된 파일의 정보(파일명) 조회, 파일 이동 처리 - 반복문 필요
		for (int i = 0; i < list.size(); i++) {
			MultipartFile mFile = list.get(i);
			if (mFile != null && !mFile.isEmpty()) { // 업로드된 파일이 있는 경우
				imageName.add(mFile.getOriginalFilename());
				mFile.transferTo(new File(destDir, mFile.getOriginalFilename())); // 예외
																					// 던짐

			}
		}

		// 다른 경로로 이동 -> 경로 변경
		// 경로는 고정, 파일은 여러개 -> 파일 이름 저장

		// 사진 객체로
		List<StorePicture> storePictureList = new ArrayList<StorePicture>();
		for (int i = 0; i < imageName.size(); i++) {
			storePictureList.add(new StorePicture(imageName.get(i), storeRegisterForm.getStoreId()));
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("store", store);
		
		//수정하는 서비스 호출
		try {
			service.modifyStore(store, sclist,storePictureList);
		} catch (DuplicatedStoreIdException | StorePictureNotFoundException  e) {
			System.out.println(e.getMessage());
		}

		return "store/store_success.tiles";

	}

	/**
	 * store매장을 삭제하는 controller
	 * 
	 * @param storeRegisterForm
	 * @param errors
	 * @param request
	 * @return
	 */
	@RequestMapping("removeStoreController")
	public String removeStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request) {

		return null;

	}

	@RequestMapping("selectStoreController")
	public String selectStoreController(@ModelAttribute("store") @Valid StoreRegisterForm storeRegisterForm,
			BindingResult errors, HttpServletRequest request) {

		return "store/store_success.tiles";

	}

}
