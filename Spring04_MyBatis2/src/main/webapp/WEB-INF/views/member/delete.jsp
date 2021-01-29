<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/delete.jsp</title>
</head>
<body>
<div class="container">
	<h1>Alert</h1>
	<p>
		<strong>${num }</strong>번 회원의 정보를 삭제 했습니다.
		<a href="list.do">목록 보기</a>
	</p>
</div>
</body>
</html>