<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<h1>플랫폼 지원 결제 목록 등록</h1><hr><br>

<form action="${initParam.rootPath }/addPaymentOptionListController.do" method="post">
	<sec:csrfInput/>
	아이디 : <input type="text" name="paymentId" required><br>
	방법 : <input type="text" name="paymentMethod" required><br>
	<input type="submit" value="등록">
</form>

