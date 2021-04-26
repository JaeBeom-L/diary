<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
	<form action="${pageContext.request.contextPath}/auth/removeMember" method="post">
		<div>
			memberPw :
		</div>
		<div>
			<input type="password" name="memberPw">
		</div>
		<button type="submit">회원탈퇴</button>
	</form>
</body>
</html>