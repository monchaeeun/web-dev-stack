<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
        background-color: tomato;
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
    <div>
      <h1>회원가입에 실패하셨습니다.</h1>
      <button>돌아가기</button>
    </div>
  </body>
</html>
