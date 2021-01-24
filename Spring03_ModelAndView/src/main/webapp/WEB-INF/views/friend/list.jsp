<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/friend/list.jsp</title>
</head>
<body>
<div class="container">
	<h1>친구 목록 입니다.</h1>
	<ul>
		<c:forEach var="tmp" items="${list }">
			<li>${tmp }</li>
		</c:forEach>
	</ul>
	<a href="../home.do">인덱스 (상대경로)</a><br />
	<a href="${pageContext.request.contextPath }/">인덱스 (최상위 경로)</a>
</div>
</body>
</html>