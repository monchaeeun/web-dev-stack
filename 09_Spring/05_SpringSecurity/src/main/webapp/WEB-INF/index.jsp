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

	<body>
	<div>
	<p>아이디 확인 : ${user.id}</p><br><br>
	<p>비밀번호 확인 : ${user.pwd}</p><br><br>
	<p>이름 확인 : ${user.name}</p><br><br>
	<p>권한 확인 : ${user.role}</p><br><br>
	</div>
	<b>
	<div id = "anonymous" style="desplay:none;">
	<sec:authorize access="isAnonymous()">
		<button type="button" onclick="location.href='/login'">로그인</button>
		<button type="button" onclick="location.href='/register'">회원가입</button>
	</sec:authorize>
	</div>
	<div id = "authenticated" style="desplay:none;">
	<sec:authorize access="isAuthenticated()">
		<button type="button" onclick="location.href='/logout'">로그아웃</button>
		<button type="button" onclick="location.href='/mypage'">마이 페이지</button>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
		<button type="button" onclick="location.href='/admin'">관리자 페이지</button>
	</sec:authorize>
	</div>
	</b>
	
	<script>
			const token = localStorage.getItem("token");
			if(token !== null)
			{
				
			}else{
				$("#anonymous").show();
			}
			
			</script>	
</body>
	
</html>