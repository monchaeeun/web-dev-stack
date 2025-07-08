<%@page import="vo.Member"%> <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>검색 페이지</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }
      .all {
        width: 100%;
        height: 500px;
        
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        text-align: center;
      }
      h2
      {
      	margin-top: 20px;
      }
      .mem {
        display : flex;
        flex-direction : column;
        justify-content : center;
        align-items : center;
      	width: 200px;
      	height: 300px;
        border: 3px solid gray;
        border-radius: 10px 10px 10px 10px;
      }
      b {
        font-weight: 700;
        text-decoration: underline;
       
        
      }
    </style>
  </head>
  <body>
    <% Member member = (Member)request.getAttribute("member");
    	String id = request.getParameter("id");
    %>
    <div class="all">
      <h2>조회된 회원</h2>
      <br>
      <div class="mem">
      <br />
      <%if(member!= null){ %>
        <b>이름 : <%= member.getName() %></b> <br />
        <b>나이 : <%= member.getAge()%> </b> <br />
        <b>아이디 : <%= member.getId()%> </b> <br />
        <b>비밀번호 : <%= member.getPwd()%> </b> <br />
      <% } else{%>
      <b>회원정보 <%=id %>가 없습니다.</b>
      <%} %>
        <br>
      </div>
    </div>
  </body>
</html>
