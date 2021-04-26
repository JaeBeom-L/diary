package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.vo.Todo;

// 2. Dao -> Service
public class TodoDao {
	// 일정 삭제 메서드
	public void deleteTodo(Connection conn,int todoNo) throws SQLException{
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_TODONO);
			stmt.setInt(1, todoNo);
			System.out.println(stmt+" 삭제 메서드");
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}
	
	
	// 일정 수정 메서드
	public int updateTodo(Connection conn, Todo todo) throws SQLException{
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
				
		try {
			stmt = conn.prepareStatement(TodoQuery.UPDATE_TODO_BY_TODONO);
			stmt.setString(1, todo.getTodoTitle());
			stmt.setString(2, todo.getTodoContent());
			stmt.setString(3, todo.getTodoFontColor());
			stmt.setInt(4, todo.getTodoNo());
			System.out.println(stmt+" 수정 메서드");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	
	// 일정 상세보기
	public List<Todo> selectTodoOne(Connection conn, int memberNo, int todoNo, String todoDate) throws SQLException {
		// 초기화
		List<Todo> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_ONE);
			stmt.setInt(1, memberNo);
			stmt.setInt(2, todoNo);
			stmt.setString(3, todoDate);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoNo(rs.getInt("todoNo"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoContent(rs.getString("todoContent"));
				todo.setTodoAddDate(rs.getString("todoAddDate"));
				list.add(todo);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		
		return list;
	}
	
	// 달력 제목,색상
	public List<Todo> selectTodoListByDate(Connection conn, int memberNo, int tagetYear, int tagetMonth) throws SQLException {
		// 초기화
		List<Todo> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_LIST_BY_DATE);
			stmt.setInt(1, memberNo);
			stmt.setInt(2, tagetYear);
			stmt.setInt(3, tagetMonth);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoNo(rs.getInt("todoNo"));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
				list.add(todo);
			}
			
		} finally {
			rs.close();
			stmt.close();
		}
		
		return list;
	}
	
	// 일정 추가
	public int insertTodo(Connection conn, Todo todo) throws SQLException {
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.INSERT_TODO);
			stmt.setInt(1, todo.getMemberNo());
			stmt.setString(2, todo.getTodoDate());
			stmt.setString(3, todo.getTodoTitle());
			stmt.setString(4, todo.getTodoContent());
			stmt.setString(5, todo.getTodoFontColor());
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	// 계정삭제(트랜잭션)
	public int deleteTodoByMember(Connection conn, int memberNo) throws SQLException {
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			System.out.println(stmt+"Todostmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		System.out.println(rowCnt+"rowCnt");
		return rowCnt;
	}
}
