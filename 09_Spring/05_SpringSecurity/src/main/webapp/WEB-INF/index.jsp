<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>index 페이지</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	</head>

	<body>
	<div>
	
	<sec:authorize access="isAnonymous()">
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
	</sec:authorize>
	<b>
	<div id = "anonymous">
		<button type="button" onclick="location.href='/login'">로그인</button><br>
		<button type="button" onclick="location.href='/register'">회원가입</button><br>
	</div>
	<div id = "authenticated">
		<button type="button" onclick="location.href='/logout'" id="logout">로그아웃</button><br>
		<button type="button" onclick="location.href='/mypage'" id="mypage">마이 페이지</button><br>
	</div>
	<div id = "admin">
		<button type="button" onclick="location.href='/admin'">관리자 페이지</button><br>
		</div>
	</b>
	
	<script>
			const token = localStorage.getItem("token");
			if(token !== null)
			{
			$("#authenticated").show();
			$("#anonymous").hide();
			$("#admin").hide();
			
			
			$.ajax({
				
				url:'/check',
				type: 'get',
				data:{token : token},
				success:function(data)
				{
					const role = data.role;

					if(role === 'ROLE_ADMIN'){
						$("#admin").show();
					}	
					else{
						$("#admin").hide();
					}	
				}
			})
			}else{
				$("#anonymous").show();
				$("#authenticated").hide();
				$("#admin").hide();
			}
			
			$("#logout").click(()=>{
				localStorage.removeItem("token");
				location.href = "/";
			})
			
			$("#mypage").click(()=>{
				$.ajax({
					url:'/mypage',
					type:'get',
					beforeSend: function(xhr){
						xhr.setRequestHeader('Authorization', 'Bearer '+token);
					},
					success: function(data){
						$('body').html(data);
					}
				})
			})	
			
			$("#admin").click(()=> {
				$.ajax({
				url:'/admin',
				type:'get',
				beforeSend: function(xhr){
				xhr.setRequestHeader('Authorization','Bearer '+token);
				},
				success: function(data){
					$('body').html(data);
				}
			})	
		})
			</script>	
</body>
	
</html>