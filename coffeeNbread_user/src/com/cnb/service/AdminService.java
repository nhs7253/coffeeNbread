package com.cnb.service;

import java.util.Map;

import com.cnb.exception.UserManageException;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.UserAuthority;

/*
 * 노현식
 * 2017-07-11
 * 생성, 초기 구현
 */
/**
 * 플렛폼 관리자가 지원하는 서비스
 */
public interface AdminService {
	
	
	/**
	 * 관리자가 입력한 키워드를 통해 조회한 회원과 매장의 조인 데이터를 페이징하여 보여주는 Service
	 * @param select 검색 카테고리 userId, userName, storeId, storeName
	 * @param keyword 검색할 키워드
	 * @param page 보려는 페이지 번호
	 * @return Map<String, Object> 페이징을 위한 정보 결과
	 */
	Map<String, Object> userManagementListService(String select, String keyword, int page);
	
	/**
	 * 매장을 허가 및 불허 해주는 서비스
	 * @param userId 변경할 유저 ID
	 * @param storeId 허가 여부를 결정할 매장
	 * @param storePermission 매장 허가 변경
	 */
	void storeApproveService(String userId, String storeId, String storePermission);
	
}
