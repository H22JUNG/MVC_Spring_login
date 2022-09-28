<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	  body {
            background-color: #5fbae9;
            position : relative;
        }
        #div1 {
            width: 400px;
            padding: 40px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 5px 5px 20px gray;
            position : absolute;
            left:50%;
            top:50%;
            transform: translateX(-50%);
            animation-name: rotate;
            animation-duration: 0s;
            animation-timing-function: ease-in;
            animation-fill-mode: forwards;
        }
        @keyframes rotate{
            from {
                top:50%;
            }
            to {
                transform: translate(-50%, 100%);
            } 
        }
        h1 {
            font-size: 18px;
            height: 25px;
            color: black;
            text-align: center;
            display: inline-block;
            border-bottom: 2px solid #5fbae9;
            font-weight:bold;
            animation-name: h1fade;
            animation-duration: 0s;
            animation-timing-function: ease-out;
            animation-fill-mode: forwards;
        }
        @keyframes h1fade{
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            } 
        }
        #center {
            text-align: center;
        }
        input[type=text], input[type=password] {
            background-color: #f6f6f6;
            border : #f6f6f6;
            width: 400px;
            height: 50px;
            margin-bottom: 10px;
            text-align: center;
            font-size: 15px;
        }
        input[type=text]:focus, input[type=password]:focus {
            outline: none;
            border: 2px solid #f6f6f6;
            border-bottom : 2px solid #5fbae9;
            background-color: white;
        }
        button {
            width: 250px;
            height: 50px;
            background-color:#56baed;
            border: none;
            color: white;
            font-size: medium;
            border-radius: 10px;
            display: inline-block;
            box-shadow: 1px 1px 15px #5fbae9;
            opacity: 0;
            animation-name: btnfade;
            animation-duration: 0s;
            animation-timing-function: ease-out;
            animation-fill-mode: forwards;
            animation-delay : 0s;
        }
        input[type=text] {
            animation-name: textfade;
            animation-duration: 0s;
            animation-timing-function: ease-out;
            animation-fill-mode: forwards;
        }
        @keyframes textfade {
        from { opacity: 0; }
            to { opacity: 1; } 
        }
        input[type=password] {
            opacity: 0;
            animation-name: pwfade;
            animation-duration: 0s;
            animation-timing-function: ease-out;
            animation-fill-mode: forwards;
            animation-delay : 0s;
        }
        @keyframes pwfade {
        from { opacity: 0; }
            to { opacity: 1; } 
        }
        @keyframes btnfade {
        from { opacity: 0; }
            to { opacity: 1; } 
        }
</style>
<body>
	<div id="div1">
		<div id="center"><h1>로그인</h1></div>
		<form action="${pageContext.request.contextPath}/result2" method="post">
			<input type="text" id="id" name="userid" placeholder="아이디를 입력하세요" /><br />
			<input type="password" id="pw" name="password" placeholder="패스워드를 입력하세요" /><br />
			<div id="center"><button>Log In</button></div>
		</form>
	</div>
</body>
</html>