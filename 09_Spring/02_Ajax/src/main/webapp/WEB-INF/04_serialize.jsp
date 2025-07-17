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

    <form id="frm">
      아이디: <input type="text" name="id" id="id" /><br />
      비밀번호: <input type="password" name="pwd" id="pwd" /><br />
      이름: <input type="text" name="name" id="name" /><br />
      <input type="button" value="회원가입" id="btn" />
    </form>
    <script>
      $("#idCheck").click(() => {
        $.ajax({
          // 요청
          type: "post",
          url: "/signup",
          data: $("#frm").serialize(),
          // 응답
          success: function (response) {
            if (response == false) {
              $("#idCheckView").text("아이디 사용 가능").css("color", "green");
            } else {
              $("#idCheckView").text("아이디 사용 불가").css("color", "red");
            }
          },
          error: function (xhr, status, error) {},
        });
      });
    </script>
  </body>
</html>
