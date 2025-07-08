<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<%-- 로그인 로직 : 아이디, 비밀번호 입력박아서
					호출 : /login, 방식 : post
						LoginServlet : 세션 데이터 바인딩!
						index.jsp로 이동  --%>
<form action="login" method="post">
	아이디 : <input type="text" name="id"> <br>
	비밀번호 : <input type="password" name="pwd"> <br>
	<input type="submit" value="로그인">
</form>								
						
</body>
</html>