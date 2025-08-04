<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>마이 페이지</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	</head>
	<style>
	       body {
	           margin: 0;
	           padding: 0;
	           height: 100vh;
	           display: flex;
			   flex-direction: column;
	           justify-content: center;
	           align-items: center;
	           background-color: #f2f2f2;
	       }

	       form {
	           background-color: white;
	           padding: 30px;
	           border-radius: 8px;
	           box-shadow: 0 0 10px rgba(0,0,0,0.1);
	       }
		   div {
		           background-color: #fff;
		           padding: 30px 40px;
		           border-radius: 10px;
		           box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
		           text-align: center;
		       }

	       input[type="text"], input[type="password"] {
	           width: 100%;
	           padding: 10px;
	           margin-bottom: 15px;
	           box-sizing: border-box;
	       }

	       input[type="submit"] {
	           width: 100%;
	           padding: 10px;
	           background-color: #0d6efd;
	           border: none;
	           color: white;
	           cursor: pointer;
	           border-radius: 4px;
	       }

	       input[type="submit"]:hover {
	           background-color: #0b5ed7;
	       }

	       h3, p {
	           margin-bottom: 10px;
	       }
		   p{
			text-align : left;
		   }
	   </style>
	<body>
			<h3>마이 페이지</h3>
			<div>
				<p><sec:authentication property="principal.name"/>님의 페이지 입니다.</p><br><br>
				<p><sec:authentication property="principal.role"/> 권한</p><br><br>
			</div>
	</body>
	
</html>	