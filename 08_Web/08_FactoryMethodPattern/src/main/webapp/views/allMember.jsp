<%@page import="java.util.ArrayList"%>
<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 전체 회원 보기 : AllMemberServlet 
					views/allMember.jsp에 리스트 출력 --%>
	 
	 <%--firEach items="${list}", var="member" 상태에서 member.id --%>
	  <%--firEach items="${list}", var="member" varStatus="status" ${status.index}, ${status.count}--%>
	 <h1>전체 회원 리스트</h1>
	 
	 <c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
		
		<h2>번호 : ${i+1}</h2>
		<h2>이름 : ${list[i].getName()}</h2>
		<h2>나이 : ${list[i].getAge()}</h2>
		<h2>아이디 : ${list[i].getId()}</h2>
		<br>
	</c:forEach>
   
    <a href="/">메인 페이지로 이동</a>	
</body>
</html>