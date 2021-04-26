package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.*;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.*;

// 3. Service -> Controller
public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	private TodoDao todoDao;

	// select -> get
	// insert -> add
	// update -> modify
	// delete -> remove

	// 비밀번호 변경
	public void modifyMemberPw(Member member) {
		// 초기화
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;

		try {
			conn = this.dbUtil.getConnection();
			this.memberDao.updateMemberPw(conn, member);
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

	}

	// 아이디 중복검사 + 회원가입
	public boolean checkMemberIdAndAddMember(Member member) {
		// 초기화
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		Connection conn = null;
		boolean checkId = false;

		try {
			conn = this.dbUtil.getConnection();
			if (this.memberDao.checkMemberId(conn, member) != null) { // 아이디 존재하면 콘솔알림
				System.out.println("중복된 아이디입니다");
				checkId = false;
			} else { // 회원가입
				this.memberDao.insertMember(conn, member);
				checkId = true;
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			checkId = false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkId;
	}

	// 회원탈퇴 - 삭제 실패(rollback) : false 삭제 실패: true
	public boolean removeMemberByKey(Member member) {
		this.dbUtil = new DBUtil();
		this.memberDao = new MemberDao();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int todoRowCnt = 0;
		int memberRowCnt = 0;

		try {
			conn = dbUtil.getConnection();
			todoRowCnt = this.todoDao.deleteTodoByMember(conn, member.getMemberNo());
			memberRowCnt = this.memberDao.deleteMemberByKey(conn, member);
			System.out.println(todoRowCnt + "todoRowCnt");
			System.out.println(memberRowCnt + "memberRowCnt");
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (todoRowCnt + memberRowCnt) > 0;
	}

	// 로그인
	public Member getMemberByKey(Member member) {
		// 초기화
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		this.memberDao = new MemberDao();
		Connection conn = null;

		try {
			conn = dbUtil.getConnection();
			returnMember = this.memberDao.selectMemberByKey(conn, member);
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
		return returnMember;
	}
}
