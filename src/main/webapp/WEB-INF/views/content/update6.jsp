<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	label {
		font-weight : 600;
		width : 81px;
	}
	#category {
		width : calc(100% - 80px);
		float : right;
	}
	#title {
		width : calc(100% - 89px);
		float : right;
	}
	button {
		float: right;
		width : 60px;
		height : 40px;
	}
	#content {
		width : 99.7%;
	}
	#cate, #tit {
		margin-bottom : 7px;
	}
</style>
<body>

 	<form:form action="update6/${bbsVO.id}" modelAttribute="bbsVO" method="post">
		<div id="cate">
		<label for="category">카테고리 : </label>
		<form:select path="category">
			<form:option value="고민">고민</form:option>
			<form:option value="공유">공유</form:option>
			<form:option value="공지">공지</form:option>
			<form:option value="잡담">잡담</form:option>
			<form:option value="비밀">비밀</form:option>
			<form:option value="알림">알림</form:option>
		</form:select>
		</div>
		<div id="tit">
		<label for="tilte">제목 : </label>
		<form:input type="text" path="title"/>
		<br />
		</div>
		<form:textarea path="content" cols="100" rows="15"></form:textarea>
		<br />
		<button>전송</button>
	</form:form>
</body>
</html>