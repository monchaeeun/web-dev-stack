<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach6</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="6" step="1">
		<h${i}>JSTL...! - ${i}</${i}>
	</c:forEach>
	
	<%
		String[] arr = {"두루치기", "닭꼬치","김치볶음밥","순두부찌개"};
		request.setAttribute("arr", arr);
		
	%>
	<c:forEach items="${arr}" var="menu">
	<p>${menu} 먹고싶다.</p>
	</c:forEach>
</body>
</html>