<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form:form action="update1/${vo.id}" modelAttribute="vo" method="post">
		<label for="category">카테고리</label>
		<form:select path="category">
			<form:option value="고민" >고민</form:option>
			<form:option value="공유" >공유</form:option>
			<form:option value="공지" >공지</form:option>
			<form:option value="잡담" >잡담</form:option>
			<form:option value="비밀" >비밀</form:option>
			<form:option value="알림" >알림</form:option>
		</form:select>
		<br />
		<label for="tilte">제목</label>
		<form:input type="text" path="title"/>
		<br />
		<form:textarea path="content" cols="100" rows="15"></form:textarea>
		<button>전송</button>
	</form:form>
</body>
</html>