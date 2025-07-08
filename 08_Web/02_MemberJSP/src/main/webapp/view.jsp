<%@page import="java.util.ArrayList"
		import="vo.Member"
		
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입 페이지</title>
    <style>
        *
        {
            margin: 0;
            padding: 0;
        }
        .all{
            width: 100%;
            height: 1000px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        b
        {
            margin-top: 20px;
            font-weight: 700;
        }
        h1
        {
        	margin-bottom:30px; 
        }
    </style>
  </head>
  <body>
  
  
	<% ArrayList<Member> member = (ArrayList<Member>)request.getAttribute("member");%>
    <div class="all">
    <h1>전체 리스트</h1>
  	<h2>회원조회</h2>
  	<form action="search">
  	검색할 회원 아이디 : <input type="text" name="id"> 
  	<input type="submit" value="조회">
  	<br><br>
  	</form>
    <%for(Member m : member){%>
    
    <div class="member">
    <b>이름 : <%= m.getName() %></b> <br>
    <b>나이 : <%= m.getAge()%>  </b> <br>
    <b>아이디 : <%= m.getId()%>  </b> <br>
    <b>비밀번호 : <%= m.getPwd()%>  </b> <br>
    <br>
    </div>
    <%} %>
    </div>
  </body>
</html>
