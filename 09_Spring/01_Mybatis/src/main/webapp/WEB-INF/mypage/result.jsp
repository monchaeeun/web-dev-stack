<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<!--로그인에 성공하면 index.jsp에 ~~님 로그인 하셨습니다.
		기존 회원가입이랑 로그인 연결됨 부분은 사라지고
	-->
	<% String name = (String)session.getAttribute("name");%>
	<h1><%= name %>님 환영합니다.</h1>
</body>
</html>	