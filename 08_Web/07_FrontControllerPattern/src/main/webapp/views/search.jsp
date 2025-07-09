<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지</title>
</head>
<body>
검색 페이지
<%-- 회원검색 : 검색할 아이디 입력 받아서
				호출 : /searchServlet
					views/result.jsp 에서
					성공하면 해당 정보 출력
					실패하면 검색에 실패했습니다 --%>
<form action="/front" method="post">
	<input type="hidden" name="command" value="search">
	아이디 검색 : <input type="text" name="id"> <input type="submit" value="검색">
	</form>
</body>
</html>