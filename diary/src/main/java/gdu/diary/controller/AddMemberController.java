package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.vo.Member;
import gdu.diary.service.MemberService;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	// 회원가입 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	
	// 회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 정보수집
		this.memberService = new MemberService();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		System.out.println(member);
		
		boolean check = this.memberService.checkMemberIdAndAddMember(member);
		if(check == false) { // 회원가입 실패시 돌아가기
			response.sendRedirect(request.getContextPath()+"/addMember");
			return;
		}
		
		// 회원가입 성공시 로그인화면 이동
		response.sendRedirect(request.getContextPath()+"/login");
	}
}
