<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>

	<h1>회원 관리</h1>
	
	<ul>
	<c:choose>
 	<c:when test="${empty member}">
	<li> <a href="/views/register.jsp">회원가입</a> </li>
	<li> <a href="/views/login.jsp">로그인</a> </li>
	 </c:when>	 
	 <c:otherwise>
	<li><a href="/views/search.jsp">회원 검색</a></li>	
	<%-- ?key = value --%>
	<li> <a href="/allMember.do">전체 회원 보기</a></li>
	<li> <a href="/logout.do">로그아웃</a> </li>
	 </c:otherwise>
	 </c:choose>	
	</ul>
</body>
</html>