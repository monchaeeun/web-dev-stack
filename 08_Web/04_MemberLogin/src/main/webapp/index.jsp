<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>

	<%-- 로그인 Servlet에서 값을 받아서 null 상태로 변경 --%>
	<%-- 로그아웃 Servlet에서 값을 지움 --%>
	 <% Member member = (Member)session.getAttribute("member"); %>
	<h1>회원 관리</h1>
	
	<ul>
	<%-- 로그인 되어있지 않은 경우 --%>
	<% if(member == null){ %>
	<li> <a href="/views/register.jsp">회원가입</a> </li>
	<li> <a href="/views/login.jsp">로그인</a> </li>
	<%} else{ %>
						
	<%-- 로그인 된 경우 --%>
	<li><a href="/views/search.jsp">회원 검색</a></li>
	
	<li> <a href="/allMember">전체 회원 보기</a></li>
	<%-- 전체 회원 보기 : AllMemberServlet 
					views/allMember.jsp에 리스트 출력 --%>
	<li> <a href="/logout">로그아웃</a> </li>
	<%-- 로그아웃 : 로그아웃하고 index.jsp로! LogoutServlet --%>
	</ul>
	<%}%>
</body>
</html>