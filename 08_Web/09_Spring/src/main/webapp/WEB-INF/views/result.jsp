<%@page import="com.kh.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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


<b>이름 : ${member.name}</b> <br>
<b>나이 : ${member.age}</b><br>
<b>아이디 : ${member.id}</b><br>
<b>비번 : ${member.pwd}</b><br>
<a href="/">메인 페이지로 이동</a>			

</body>
</html>