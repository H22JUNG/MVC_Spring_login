<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<form action="${pageContext.request.contextPath }/create6" method="post">
		<div id="cate">
		<label for="category">카테고리 : </label>
		<select name="category" id="category">
			<option value="고민">고민</option>
			<option value="공유">공유</option>
			<option value="공지">공지</option>
			<option value="잡담">잡담</option>
			<option value="비밀">비밀</option>
			<option value="알림">알림</option>
		</select>
		</div>
		<div id="tit">
		<label for="tilte">제목 : </label>
		<input type="text" id="title" name="title"/>
		</div>
		<textarea name="content" id="content" cols="100" rows="15"></textarea>
		<button>전송</button>
	</form>
</body>
</html>