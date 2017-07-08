package com.cnb.exception;

/*
 * 김형주 
 * 2017-07-04
 * 레시피게시판 사진 업로드 할떄 같은 사진 넣었을떄의 에러
 * 
 * 김형주
 * 2017-07-04 
 * 생성, 초기 구현
 */
public class NotInputRecipeBoardPictureException extends Exception{

	public NotInputRecipeBoardPictureException(){}
	public NotInputRecipeBoardPictureException(String message){
		super(message);
	}
}
