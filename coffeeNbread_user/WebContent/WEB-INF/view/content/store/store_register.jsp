<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/coffeeNbread_user/store/register.do" method="post">
		<table>
			<tr>
				<th>매장 분류</th>
				<td><input type="text" value="StoreCategory"><input type="button" value="추가하기"></td>
			</tr>
			
			<tr>
				<th>옵션 카테고리</th>
				<td><input type="text" value="OptionCategory"><input type="button" value="추가하기"></td>
			</tr>
			
			<tr>
				<th>매장 ID</th>

				<td><input type="text" name="id" value="${param.id}"></td>
			</tr>
			<tr>
				<th>매장 이름</th>
				<td><input type="text" name="name" value="${param.name}"></td>
			</tr>
			<tr>
				<th>매장 번호</th>
				<td><input type="text" name="number" value="${param.maker}"></td>
			</tr>
			<tr>
				<th>매장 메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>open 시간</th>
				<td><input type="time" name="open"></td>
			</tr>
			<tr>
				<th>close 시간</th>
				<td><input type="time" name="close"></td>
			</tr>
			<tr>
				<th>매장 사진</th>
				<td><input type="button" value="찾아보기"></td>
			</tr>
			<tr>
				<th>매장 위치</th>
				<td><input type="button" value="찾아보기"></td>
			</tr>
			<tr>
				<th>매장 소개</th>
				<td><textarea name="intro" rows="5" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>