<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


		<form action="${initParam.rootPath }/user/modifyBoardReplyToQnaBoardNoController.do">
			<sec:csrfInput/>
			 <textarea rows="5" cols="80" name="replyContent">${requestScope.boardReply.replyContent }</textarea>
			 <input type="hidden" name="replyNo" value=" ${requestScope.boardReply.replyNo }"/>
			 <input type="hidden" name="qnaBoardNo" value=" ${requestScope.boardReply.qnaBoardNo }"/>
			 <input type="hidden" name="qnaStoreId" value=" ${requestScope.qnaStoreId }"/>
			 <input type="hidden" name="replyName" value="${requestScope.boardReply.replyName }"/>
			 <input type="submit" value="수정 하기">
		</form>