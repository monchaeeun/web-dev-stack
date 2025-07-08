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
					
<% Member member = (Member)request.getAttribute("member"); %>

<b>이름 : <%= member.getName() %></b>
<b>나이 : <%= member.getAge() %></b>
<b>아이디 : <%= member.getId() %></b>
<b>비번 : <%= member.getPwd() %></b>
					
</body>
</html>