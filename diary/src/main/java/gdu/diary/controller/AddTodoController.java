package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.*;


@WebServlet("/auth/addTodo")
public class AddTodoController extends HttpServlet {
	// 서비스호출
	private TodoService todoService;
	// Todo 입력폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		
		
		// 데이터 저장
		TodoDate todoDate = new TodoDate();
		todoDate.setYear(year);
		todoDate.setMonth(month);
		todoDate.setDay(day);
		
		System.out.println(todoDate); // todoDate.toString()
		
		// request데이터 넣기
		request.setAttribute("todoDate", todoDate);
		// 입력폼으로
		request.getRequestDispatcher("/WEB-INF/view/auth/addTodo.jsp").forward(request, response);
	}
	// Todo 엑션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		HttpSession session = request.getSession();
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		String todoDate = request.getParameter("todoDate");
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");
		
		// 데이터 저장
		Todo todo = new Todo();
		todo.setMemberNo(memberNo);
		todo.setTodoDate(todoDate);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoFontColor(todoFontColor);
		
		System.out.println(todo); // todo.toString()
		
		// 서비스 호출
		this.todoService = new TodoService();
		this.todoService.addTodo(todo);
		
		String[] arr = todoDate.split("-"); // arr[0] 2021, arr[1] "04", arr[2] "26"
		
		response.sendRedirect(request.getContextPath()+"/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1)); // 작업이 완료 된 후 해당 년 월에 다이어리 출력
	}
}
