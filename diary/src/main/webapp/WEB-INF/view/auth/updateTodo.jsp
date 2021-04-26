<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateTodo</title>
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
	
	<h1>일정수정</h1>
	<div>
	
		<form action="${pageContext.request.contextPath}/auth/modifyTodo" method="post">
			<input type="hidden" name="todoDate" value="${todoDate}">
			<input type="hidden" name="todoNo" value="${todoNo}">
			<table border="1">
			<tr>
				<td>todoTitle</td>
				<td><input type="text" name="todoTitle"></td>
			</tr>
			<tr>
				<td>todoContent</td>
				<td><textarea name="todoContent" cols="80" rows="5"></textarea></td>
			</tr>
			<tr>
				<td>todoFontColor</td>
				<td><input type="color" name="todoFontColor"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>