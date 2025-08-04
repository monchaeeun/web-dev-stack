<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
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
		<form action = "/register" method="post">
			<h3>회원가입</h3>
				<p>아이디 입력</p>
				<input type="text" name="id" id="id" placeholder="아이디를 입력하세요"><br>
				<p>비밀번호 입력</p>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요"><br>
				<p>이름 입력</p>
				<input type="text" name="name" id="name" placeholder="이름을 입력하세요"><br>
				
				<input type="submit" value="확인">
		</form>
	
	</body>
	
</html>	