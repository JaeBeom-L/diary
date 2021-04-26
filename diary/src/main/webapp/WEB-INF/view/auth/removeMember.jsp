<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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