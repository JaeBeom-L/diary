<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 비밀번호 수정</title>
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
	
	<h1>회원정보 수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/auth/modifyMember">
		<div>PW: </div>
		<div><input type="password" name="memberPw"></div>
		<button type="submit">비밀번호 변경</button>
	</form>
</body>
</html>