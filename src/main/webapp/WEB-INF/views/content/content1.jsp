<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>제목 : ${bbsVO.title }</h4>
	<hr />
	<textarea name="" id="" cols="100" rows="15" >
		${bbsVO.content} 왜 null?
	</textarea>
	<form action="${pageContext.request.contextPath }/result3" method="post">
		<button>뒤로가기</button>
	</form>
</body>
</html>