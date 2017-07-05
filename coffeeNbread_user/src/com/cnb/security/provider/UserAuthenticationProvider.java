package com.cnb.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cnb.dao.GeneralUserDao;
import com.cnb.dao.UserAuthorityDao;
import com.cnb.vo.GeneralUser;
import com.cnb.vo.UserAuthority;


@Component
/*
 * Spring Security 컨테이너가 사용자 인증 처리(로그인 처리) 할때 호출할 클래스
 * 			=> AuthenticationProvider
 * 구현 : AuthenticationProvider 를 implements. 메소드 오버라이딩(authenticate())
 */

public class UserAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private GeneralUserDao userDao;
	
	@Autowired
	private UserAuthorityDao authorityDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//ID 체크
		String id = authentication.getName();//사용자가 입력한 ID
		GeneralUser generalUser = userDao.selectGeneralUserByUserId(id);
		if(generalUser == null){ //없는 id => 로그인실패
			throw new UsernameNotFoundException("ID를 확인하세요");
		}
		
		if(generalUser.getUserActiveState().equals("N")){
			throw new UsernameNotFoundException("탈퇴한 회원입니다.");
		}
		
		//패스워드 체크
		String password = (String)authentication.getCredentials();//사용자가 입력한 패스워드.
		if(!encoder.matches(password, generalUser.getUserPw())){//틀린 패스워드
			throw new BadCredentialsException("패스워드를 확인하세요");
		}
		//인증 성공
		//권한 조회
		UserAuthority userauthority = authorityDao.selectUserAuthorityByUserId(id);
		if(userauthority ==  null){
			//모든 인증된 사용자는 권한이 있어야 하는 경우는 권한 개수 체크후 권한이 없으면 
			//  예외 발생시킨다. (권한이 없는 사용자도 있을 경우 생략한다.)
			throw new UsernameNotFoundException("권한이 없는 사용자 입니다.");
		}
		
		//SimpleGrantedAuthority - 권한정보를 문자열로 저장.
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(userauthority.getUserAuthority()));
				
		//인증한 사용자 정보(Principal), 패스워드, 인증된사용자의 권한들 을 넣어 Authentication객체 생성해 리턴
		return new UsernamePasswordAuthenticationToken(generalUser, null, authList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}
}









































