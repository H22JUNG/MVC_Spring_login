<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/create" method="post">
		<label for="category">카테고리</label>
		<select name="category" id="category">
			<option value="고민">고민</option>
			<option value="공유">공유</option>
			<option value="공지">공지</option>
			<option value="잡담">잡담</option>
			<option value="비밀">비밀</option>
			<option value="알림">알림</option>
		</select>
		<br />
		<label for="tilte">제목</label>
		<input type="text" id="title" name="title"/>
		<br />
		<textarea name="content" id="content" cols="100" rows="15"></textarea>
		<button>전송</button>
	</form>
</body>
</html>