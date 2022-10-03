<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	textarea {
		width:99.8%;
		
	}
	form{
		display : inline;
	}
	button {
		height : 40px;
		margin : 5px;
	}
	#btn {
		display : flex;
		justify-content: flex-end;
	}  
</style>
</head>
<body>
	<h4>제목 : ${vo.title }</h4>
	<hr />
	<br />
	<textarea name="" id="" cols="100" rows="15" >${vo.content}</textarea>
	<br />
	<div id="btn">
	<button id=delete>삭제</button>
	<button id="update1">수정</button>
	<form action="${pageContext.request.contextPath }/back6" method="post">
		<button>뒤로가기</button>
	</form>
	</div>
	
	<script type="text/javascript">
		document.getElementById("update1").addEventListener("click", function() {
			location.href = "${pageContext.request.contextPath }/update6?title=${vo.title}";
		});
		document.getElementById("delete").addEventListener("click", function() {
			if(confirm("정말로 삭제하시겠습니까?")) {
				location.href = "${pageContext.request.contextPath }/delete/${vo.id}";
			}
		});
	</script>
</body>
</html>