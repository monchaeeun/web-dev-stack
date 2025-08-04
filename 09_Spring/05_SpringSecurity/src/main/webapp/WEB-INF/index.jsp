<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>index 페이지</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	</head>
	<style>
	    body {
	        margin: 0;
	        padding: 0;
	        height: 100vh;
	        display: flex;
			flex-direction: column;
	        justify-content: center;
	        align-items: center;
	        font-family: sans-serif;
	        background-color: #f0f2f5;
	    }
		b{
			display: flex;
			flex-direction:row ;
			justify-content: center;
			align-items: center;
		}

	    div {
	        background-color: #fff;
	        padding: 30px 40px;
	        border-radius: 10px;
	        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	        text-align: center;
	    }

	    button {
	        padding: 10px 20px;
	        margin: 5px;
	        border: none;
	        border-radius: 5px;
	        font-size: 16px;
	        cursor: pointer;
	    }

	    button:first-of-type {
	        background-color: #4CAF50;
	        color: white;
	    }

	    button:last-of-type {
	        background-color: #2196F3;
	        color: white;
	    }

	    p {
	        margin: 10px 0;
	        font-size: 16px;
	    }
	</style>
	<body>
	<div>
	<p>아이디 확인 : ${user.id}</p><br><br>
	<p>비밀번호 확인 : ${user.pwd}</p><br><br>
	<p>이름 확인 : ${user.name}</p><br><br>
	<p>권한 확인 : ${user.role}</p><br><br>
	</div>
	<b>
		<sec:authorize access="isAnonymous()">
	<button type="button" onclick="location.href='/login'">로그인</button>
	<button type="button" onclick="location.href='/register'">회원가입</button>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<button type="button" onclick="location.href='/logout'">로그아웃</button>
	<button type="button" onclick="location.href='/mypage'">마이 페이지</button>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
	<button type="button" onclick="location.href='/admin'">관리자 페이지</button>
	</sec:authorize>
	</b>
</body>
	
</html>