<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<!-- 비로그인 상태 -->
	<c:if test="${sessionMember == null}">
		<div class="row">
			<form action="${pageContext.request.contextPath}/login" method="post">
				<div>
					<div>ID : </div>
					<div><input type="text" name="memberId" value="admin"></div>
					<div>PW : </div>
					<div><input type="password" name="memberPw" value="1234"></div>
				</div>
				<button type="submit">로그인</button>
			</form>
			<a href="${pageContext.request.contextPath}/addMember">
				<button type="button">회원가입</button>
			</a>
		</div>
	</c:if>
	
	<!-- 로그인 상태 -->
	<c:if test="${sessionMember != null}">
		${sessionMember.memberId}님 반갑습니다.
		<div>
			<a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/auth/modifyMember">정보수정</a>
			<a href="${pageContext.request.contextPath}/auth/removeMember">탈퇴</a>
		</div>
		<div><a href="${pageContext.request.contextPath}/auth/diary">다이어리</a></div>
	</c:if>
</body>
</html>