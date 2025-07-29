<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	<style>
			body, html {
				height: 100%;
				margin: 0;
				font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
				background-color: #f8f9fa;
			}
			.container {
				max-width: 600px;
				margin: 60px auto;
				background: white;
				padding: 30px 40px;
				box-shadow: 0 4px 12px rgba(0,0,0,0.1);
				border-radius: 10px;
				text-align: center;
			}
			h3 {
				margin-bottom: 30px;
				color: #343a40;
			}
			p {
				text-align: left;
				font-weight: 600;
				color: #495057;
				margin-bottom: 6px;
				margin-top: 20px;
			}
			input[type="text"] {
				width: 100%;
				padding: 10px 12px;
				font-size: 16px;
				border: 1px solid #ced4da;
				border-radius: 5px;
				box-sizing: border-box;
				transition: border-color 0.3s ease;
			}
			input[type="text"]:focus {
				outline: none;
				border-color: #0d6efd;
				box-shadow: 0 0 5px rgba(13,110,253,0.5);
			}
			button {
				margin: 20px 10px 0 10px;
				padding: 10px 25px;
				font-size: 16px;
				border-radius: 5px;
				border: none;
				cursor: pointer;
				transition: background-color 0.3s ease, box-shadow 0.15s ease;
				color: white;
				user-select: none;
			}
			#update {
				background-color: #0d6efd; /* Bootstrap primary blue */
			}
			#submit {
				background-color: #198754; /* Bootstrap success green */
			}
			#delete {
				background-color: #dc3545; /* Bootstrap danger red */
			}
			button:hover {
				filter: brightness(110%);
			}
			button:active {
				box-shadow: inset 0 3px 5px rgba(0,0,0,0.2);
				filter: brightness(90%);
			}
			
			.button-group {
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-top: 20px;
			}

			.button-group button {
				padding: 6px 15px;
				font-size: 14px;
			}

			#delete {
				background-color: #dc3545;
				margin-left: auto;
			}
			.preview-img {
			  max-width: 100%;
			  height: auto;
			  border-radius: 8px;
			  margin-bottom: 20px;
			}
		</style>

</head>
<body>
	<!--a 링크를 통해 딱 해당 정보만 나올 수 있도록! 상세 보기-->
	<div class="container">
		
			<h3>상세 정보</h3>
			<img class="preview-img" src="http://192.168.0.35:8081/${board.url}"/>
			
			<input type="hidden" name="no" id="no" value="${board.no}">
			<p>제목</p>
			<input type="text" name="title" id="title" placeholder="${board.title}" disabled>
			
			<p>내용</p>
			<input type="text" name="content" id="content" placeholder="${board.content}" disabled>		
			
			<p>url</p>
			<input type="text" name="url" id="url" placeholder="${board.url}" disabled><br><br>
			
					
			<div class="button-group">
				<button type="button" name="update" id="update">수정</button>
				<button type="button" name="submit" id="submit">저장</button>
				<button type="button" name="delete" id="delete">삭제</button>
			</div>
	</div>			
	<script>
		$("#update").click(() =>{
			$("#title").prop("disabled", false);
			$("#content").prop("disabled", false);
			$("#url").prop("disabled", false);
		})
		$("#submit").click(() =>{
			const no = $("#no").val();
			const title = $("#title").val();
			const content = $("#content").val();
			const url = $("#url").val();		
			
			const formData = new FormData();
			formData.append("no", no);
			formData.append("title", title);
			formData.append("content", content);
			formData.append("url", url);
			
			$.ajax({
				type : "POST",
				url : "/update",
				data : formData,
				processData: false,
				contentType: false,
				success: function (result) {
				if (result === "success") {
					alert("해당정보가 수정되었습니다.");
					location.href = "/";
				} else {
					alert("수정할 수 없습니다.");
					location.href = "/";
				}	
			  },
			});
			
		})
				
		$("#delete").click(() =>{
			const no = $("#no").val();
			const formData = new FormData();
			 formData.append("no", no);
			$.ajax({
				type : "POST",
				url : "/delete",
				data : formData,
				processData: false,
				contentType: false,
				success: function (result) {
				if (result === "success") {
					alert("해당정보가 삭제되었습니다.");
					location.href = "/";
				} else {
					alert("삭제할 수 없습니다.");
					location.href = "/";
				}	
				 },
			});
		})
	</script>
</html>	