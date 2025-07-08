<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>회원 관리</h1>
	
	<ul>
	<%-- 로그인 되어있지 않은 경우 --%>
	
	<li> <a href="/views/register.jsp">회원가입</a> </li>
	
	<li> <a href="/views/login.jsp">로그인</a> </li>
	
						
	<%-- 로그인 된 경우 --%>
	<li><a href="/search.jsp">회원 검색</a></li>
	
	<li> <a href="/allMember">전체 회원 보기</a></li>
	<%-- 전체 회원 보기 : AllMemberServlet 
					views/allMember.jsp에 리스트 출력 --%>
	<li> <a href="/views/logout">로그아웃</a> </li>
	<%-- 로그아웃 : 로그아웃하고 index.jsp로! LogoutServlet --%>				
	</ul>
</body>
</html>