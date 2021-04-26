package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

//3. Service -> Controller
public class TodoService {
	private DBUtil dbUtil;
	private TodoDao todoDao;
	
	//일정 삭제
	public void dropTodo(int todoNo) {
		// 초기화
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.deleteTodo(conn, todoNo);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	//일정 수정
	public void modifyTodo(Todo todo) {
		// 초기화
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.updateTodo(conn, todo);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	// 일정 상세보기
	public List<Todo> todoOneList(int memberNo, int todoNo, String todoDate) {
		List<Todo> list = new ArrayList<>();
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			list = this.todoDao.selectTodoOne(conn, memberNo, todoNo, todoDate);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 일정 추가
	public int addTodo(Todo todo) {
		// 초기화
		int rowCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.insertTodo(conn, todo);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
}
