<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addTodo</title>
</head>
<body>
	<c:if test="${sessionMember != null}">
		${sessionMember.memberId}님 반갑습니다.
		<div>
			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/auth/modifyMember">정보수정</a>
			<a href="${pageContext.request.contextPath}/auth/removeMember">탈퇴</a>
		</div>
		<div><a href="${pageContext.request.contextPath}/auth/diary">다이어리</a></div>
	</c:if>	
	
	<h1>todo 입력</h1>
	<form action="${pageContext.request.contextPath}/auth/addTodo" method="post">
		<div>todoDate : </div>
		<div><input type="text" name="todoDate" value="${todoDate.toString()}" readonly="readonly"></div>
		<div>todoTitle</div>
		<div><input type="text" name="todoTitle"></div>
		<div>todoContent</div>
		<div><textarea cols="80" rows="5" name="todoContent"></textarea></div>
		<div>totoFontColor</div>
		<div><input type="Color" name="todoFontColor"></div>
		<button type="submit">addTodo</button>
	</form>
</body>
</html>