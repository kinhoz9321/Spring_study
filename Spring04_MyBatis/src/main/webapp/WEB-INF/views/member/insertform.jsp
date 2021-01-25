<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/insertform.jsp</title>
</head>
<body>
<div class="container">
	<h1>회원추가 폼 입니다.</h1>
	<form action="insert.do" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" placeholder="이름 입력"/><br />
		<label for="addr">주소</label>
		<input type="text" name="addr" placeholder="주소 입력"/><br />
		<button type="submit">추가</button>
	</form>
</div>
</body>
</html>