<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/view/error/db_fail.jsp</title>
</head>
<body>
<div class="container">
	<h1>Oops!</h1>
	<p>${exception.message }</p>
	<a href="${pageContext.request.contextPath}/">인덱스로 돌아가기</a>
</div>
</body>
</html>
<%--
http://localhost:8888/spring05/cafe/private/delete.do?num=9999
내용 확인 가능
주소창 정확하게 확인하기
--%>