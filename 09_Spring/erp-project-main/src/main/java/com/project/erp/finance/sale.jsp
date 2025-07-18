<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<form action="/insert" method="post">
		<p>매출일자 : <input type = "date" name="saleDate"></p>
		<p>품모명 : <input type = "date" name="productName"></p>
		<p>카테고리 : <input type = "date" name="category"></p>
		<p>성별 : <input type = "date" name=" gender"></p>
		<p>수량 : <input type = "date" name="quantity"></p>
		<p>부가세 : <input type = "date" name="varAmount"></p>
		<p>총액 : <input type = "date" name="totalAmount"></p>

	</form>
	
</section>