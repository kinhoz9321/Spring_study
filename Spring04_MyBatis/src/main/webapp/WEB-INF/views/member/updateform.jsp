<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/updateform.jsp</title>
</head>
<body>
<div class="container">
	<h1>회원수정 폼 입니다.</h1>
	<form action="update.do" method="post">
        <label for="num2">번호</label>
		<input type="hidden" name="num" id="num" value="${requestScope.dto.num }"/><br />
		<label for="name">이름</label>
		<input type="text" name="name" value="${requestScope.dto.name }"/><br />
		<label for="addr">주소</label>
		<input type="text" name="addr" value="${requestScope.dto.addr  }"/><br />
		<button type="submit">수정</button>
	</form>
</div>
</body>
</html>