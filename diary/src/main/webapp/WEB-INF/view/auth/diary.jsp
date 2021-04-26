<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diary</title>
</head>
<body>
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
	<!-- 전체 셀 -->
	<c:set var="totalCell" value="${diaryMap.startBlank + diaryMap.endDay + diaryMap.endBlank}"></c:set>
	<!-- 달력넘기기 -->
	<h1>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전달</a>
		${diaryMap.targetYear}년 ${diaryMap.targetMonth+1}월
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음달</a>
	</h1>
	<!-- 달력출력 -->
	<table border="1" width="90%">
		<tr>
			<c:forEach var="i" begin="1" end="${totalCell}" step="1">
				<!-- 날짜값만 출력하게 변경 (음수면 빈칸,마지막날넘어가면 빈칸)-->
				<c:set var="num" value="${i-diaryMap.startBlank}"></c:set>
				<td>
					<!-- 날짜출력 / 다이어리 입력 링크 -->
					<c:if test="${num > 0 && num <= diaryMap.endDay}">
						<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth+1}&day=${num}">
							${num}</a>
							<c:forEach var="todo" items="${diaryMap.todoList}">	
								<c:if test="${todo.todoDate == num}">
									<div style="background-color: ${todo.todoFontColor}">
                                    	<a href="${pageContext.request.contextPath}/auth/todoOne?todoDate=${diaryMap.targetYear}-${diaryMap.targetMonth+1}-${num}&todoNo=${todo.todoNo}">${todo.todoTitle}</a>
                                    </div>
								</c:if>
							</c:forEach>
					</c:if>
					<!-- 빈칸출력 -->
					<c:if test="${num <= 0 || num > diaryMap.endDay}">
						&nbsp;
					</c:if>
				</td>
				<c:if test="${i%7==0}">
					</tr><tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>