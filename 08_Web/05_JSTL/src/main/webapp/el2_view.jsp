<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el2_ 페이지</title>
</head>
<body>
<h2>1. 기존방식</h2>
<%
String id = request.getParameter("id"); 
String[] hobby = request.getParameterValues("hobby");
%>
<ul>

<li>아이디 : <%=id %></li>
<%for(String h : hobby ){ %>
<li>취미 : <%=h %></li>
<%} %>
</ul>

<h2>2. EL</h2>
<ul>

	<li>아이디 : ${param.id}</li>
	<li>취미 : ${paramValues.hobby[0]}</li>
	<li>취미 : ${paramValues.hobby[1]}</li>
</ul>

</body>
</html>