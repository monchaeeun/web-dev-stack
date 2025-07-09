<%@page import="java.util.ArrayList"%>
<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 전체 회원 보기 : AllMemberServlet 
					views/allMember.jsp에 리스트 출력 --%>
	<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");%>
	 <h1>전체 회원 리스트</h1>
	 <%for(Member m : list){%>
    
    <div class="member">
    <b>이름 : <%= m.getName() %></b> <br>
    <b>나이 : <%= m.getAge()%>  </b> <br>
    <b>아이디 : <%= m.getId()%>  </b> <br>
    <b>비밀번호 : <%= m.getPwd()%>  </b> <br>
    <br>
    </div>
    <%} %>
    <a href="/">메인 페이지로 이동</a>	
</body>
</html>