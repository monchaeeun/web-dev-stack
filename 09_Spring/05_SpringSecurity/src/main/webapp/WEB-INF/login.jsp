<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>login 페이지</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	</head>
	<style>
	       body {
	           margin: 0;
	           padding: 0;
	           height: 100vh;
	           display: flex;
	           justify-content: center;
	           align-items: center;
	           background-color: #f2f2f2;
	       }

	       form {
	           background-color: white;
	           padding: 30px;
	           border-radius: 8px;
	           box-shadow: 0 0 10px rgba(0,0,0,0.1);
	       }

	       input[type="text"], input[type="password"] {
	           width: 100%;
	           padding: 10px;
	           margin-bottom: 15px;
	           box-sizing: border-box;
	       }

	       input[type="submit"] {
	           width: 100%;
	           padding: 10px;
	           background-color: #0d6efd;
	           border: none;
	           color: white;
	           cursor: pointer;
	           border-radius: 4px;
	       }

	       input[type="submit"]:hover {
	           background-color: #0b5ed7;
	       }

	       h3, p {
	           margin-bottom: 10px;
	       }
	   </style>

	<body>
		<form action = "/login" method="post" id="frm">
			<h3>로그인</h3>
			<p>아이디 입력</p>
			<input type="text" name="id" id="id" placeholder="아이디를 입력하세요"><br>
			<p>비밀번호 입력</p>
			<input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요"><br>
			<button type="submit" id="login">로그인</button>
		</form>
		
	<script>
			$("#login").click((e) =>{
				e.preventDefault();// 기존 이벤트 제거
			
				$.ajax({
					type : "post",
					url: "/login",
					data : $("#frm").serialize(),
					success: function(data){
						//localStorage에 token 키 값으로 저장
						localStorage.setItem("token", data);
						// <- index.jsp로 이동
						location.href = "/";
				},
					error : function(){
						alert("에러 발생");
					}
				})
			})
			
	</script>
	</body>
	
</html>