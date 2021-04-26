package gdu.diary.dao;


// 1. Query - > Dao
public class MemberQuery {
	public final static String SELECT_MEMBER_BY_KEY; // 로그인
	public final static String DELETE_MEMBER_BY_KEY; // 계정삭제
	public final static String INSERT_MEMBER; // 회원가입
	public final static String UPDATE_MEMBER_PW;//비밀번호 변경
	public final static String CHECK_MEMEBER_ID; // 계정유효성 검사
	static {
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		DELETE_MEMBER_BY_KEY = "DELETE FROM member WHERE member_no=? AND member_pw=PASSWORD(?)";
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?, PASSWORD(?), NOW())";
		UPDATE_MEMBER_PW = "UPDATE member SET member_pw=PASSWORD(?) WHERE member_no=?";
		CHECK_MEMEBER_ID = "SELECT member_id memberId FROM member WHERE member_id=?";
	}
}
