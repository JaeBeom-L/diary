package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;

@WebServlet("/auth/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoSerivce;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		String arr[] = todoDate.split("-"); // 받아온 날짜 값을 - 단위로 분리하여 문자열타입 배열에 저장
		this.todoSerivce = new TodoService();
		this.todoSerivce.removeTodo(todoNo);
		response.sendRedirect(request.getContextPath()+"/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1)); // 해당 년 월 다이어리로
	}

}
