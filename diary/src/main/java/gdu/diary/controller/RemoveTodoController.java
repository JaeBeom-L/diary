package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;

@WebServlet("/auth/deleteTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoSerivce;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		this.todoSerivce = new TodoService();
		this.todoSerivce.dropTodo(todoNo);
		response.sendRedirect(request.getContextPath()+"/auth/todoOne");
	}

}
