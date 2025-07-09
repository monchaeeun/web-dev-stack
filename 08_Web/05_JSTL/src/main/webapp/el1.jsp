<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el1 페이지</title>
</head>
<body>
<% 
	request.setAttribute("re","request");
	session.setAttribute("se", "session");
	request.getRequestDispatcher("/el1_view.jsp").forward(request, response);
%>
</body>
</html>