<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <h1>회원가입</h1>

    <div>
      아이디: <input type="text" id="id" /><br />
      비밀번호: <input type="password" id="pwd" /><br />
	  나이: <input type="text" id="age" /><br />
      이름: <input type="text" id="name" /><br />
	  <button id="btn">회원가입</button>
    <div>
	<div id="result"></div>
    <script>
      $("#btn").click(() => {
		<!--푬 양식 생성-->
		const formData= new FormData();
		formData.append("id", $("#id").val());
		formData.append("pwd", $("#pwd").val());
		formData.append("age", $("#age").val());
		formData.append("name", $("#name").val());
        $.ajax({
          // 요청
          type: "post",
          url: "/register",
          data: formData,
		  processData:false,
		  contentType:false,
          // 응답
          success: function (response) {
           console.log(response.name);
		   $("#result").text(response.name + "님이 회원가입하셨습니다.");
          },
          error: function (xhr, status, error) {},
        });
      });
    </script>
  </body>
</html>