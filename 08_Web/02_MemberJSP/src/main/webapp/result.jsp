<!-- HTML 주석 : 소스코드에 보여짐-->
<%-- JSP 주석 : 소스코드에 안보임

JSP Element
1. 지시어 %@ % : 컨테이너에게 알려줄 내용을 지정
2. 스클릿틀릿 % % : 자바코드은 이 안에 지정
3. 출력문 %= % ': 출력하는 내용 지정


--%> 
<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }
      div {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 100%;
        height: 500px;
      }
      h1 {
        text-align: center;
        color: gray;
      }

      button {
        margin-top: 30px;
        border: 0;
        background-color: lightseagreen;
        color: white;
        width: 80px;
        height: 30px;
        font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
          sans-serif;
        border-radius: 10px 10px 10px 10px;
      }
    </style>
  </head>
  <body>
  <%-- check 값도 바인딩해서 여기서 조건을 걸 수 있다는 점!! --%>
  	<% 
  	boolean check = (boolean)request.getAttribute("check");
  	String name = request.getParameter("name");
  	%>
	<%--String name = (String)request.getAttribute("name");  --%>  	
 <%  	if(check){%>
  		 <div>
  	      <h1><%=name %>님 회원가입이 완료되었습니다.</h1>
  	      <button>확인</button>
  	    </div>
  	<%}else{ %>
  		 <div>
      <h1>회원가입 실패</h1>
      <button>확인</button>
    </div>
  	<%}%>
    
  </body>
</html>
