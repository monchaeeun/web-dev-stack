<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입</title>
  </head>
  <body>
    <h1>회원가입</h1>
    아이디 : <input type="text" id="id" />
    <input type="button" value="중복체크" id="idCheck" />
    <span id="idCheckView"></span>
    <!-- 중복 체크 버튼 눌렀을 때 post 방식으로 
            /Check 로 id값 넘겨서 결과값 (boolean)을 받아서
            아이디가 있으면 ID 사용 불가, 없으면 id 사용 가능
            스키마 : work, 테이블 : member-->
    <script>
      $("#idCheck").click(() => {
        const id = $("#id").val();
        $.ajax({
          // 요청
          type: "get",
          url: "/register",
          data: "id=" + id,
          // 응답
          success: function () {
            $("#idCheckView").text("아이디 사용이 가능합니다");
          },
        });
      });
    </script>
  </body>
</html>
