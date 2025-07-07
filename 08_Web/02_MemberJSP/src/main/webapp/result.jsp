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
    <div>
      <h1>회원가입이 완료되었습니다.</h1>
      <button>확인</button>
    </div>
  </body>
</html>
