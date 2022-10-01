<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>제목 : ${vo.title }</h4>
	<hr />
	<textarea name="" id="" cols="100" rows="15" >${vo.content}</textarea>
	<br /><button id="update1">수정</button>
	<form action="${pageContext.request.contextPath }/back3" method="post">
		<button>뒤로가기</button>
	</form>
	
	<script type="text/javascript">
		document.getElementById("update1").addEventListener("click", function() {
			location.href = "${pageContext.request.contextPath }/update1?title=${vo.title}";
		});
	</script>
</body>
</html>