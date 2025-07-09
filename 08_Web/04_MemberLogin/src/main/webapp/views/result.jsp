<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과 페이지</title>
</head>
<body>
<%-- 회원검색 : 검색할 아이디 입력 받아서
				호출 : /searchServlet
					views/result.jsp 에서
					성공하면 해당 정보 출력
					실패하면 검색에 실패했습니다 --%>
					
<h1>조회된 회원</h1>
<% Member member = (Member)request.getAttribute("member"); %>
<%if(member != null){%>
<b>이름 : <%= member.getName() %></b> <br>
<b>나이 : <%= member.getAge() %></b><br>
<b>아이디 : <%= member.getId() %></b><br>
<b>비번 : <%= member.getPwd() %></b><br>
<%} %>				
</body>
</html>