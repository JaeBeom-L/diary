<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoOne</title>
</head>
<body>
	<h1>todoOne</h1>
	<c:forEach var="todoOne" items="${todoOneList}">
		<table border="1">
			<tr>
				<td>todoTitle</td>
				<td>${todoOne.todoTitle}</td>
			</tr>
			<tr>
				<td>todoContent</td>
				<td>${todoOne.todoContent}</td>
			</tr>
			<tr>
				<td>todoAddDate</td>
				<td>${todoOne.todoAddDate}</td>
			</tr>
			<tr>
				<td>수정</td>
				<td><a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${todoOne.todoNo}">수정</a></td>
			</tr>
			<tr>
				<td>삭제</td>
				<td><a href="${pageContext.request.contextPath}/auth/deleteTodo?todoNo=${todoOne.todoNo}">삭제</a></td>
			</tr>
		</table>
	</c:forEach>	
</body>
</html>