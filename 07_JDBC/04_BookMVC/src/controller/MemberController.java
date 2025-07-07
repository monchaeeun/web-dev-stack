package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	MemberDAO dao = new MemberDAO();
	
	// 4. 회원가입
	public void register(Member member)
	{
		//id가 prinaryKey 라 에러가 난다! 활용
		try {
			boolean isMember=  dao.checkMember(member);
			if(isMember == false)
			{
				dao.register(member);
				System.out.println("회원가입이 완료되었습니다.");
			}
			else
			{
				System.out.println("이미 존재하는 회원입니다.");
			}
		} 
		
		catch (SQLException e) {
			System.out.println("회원가입 실패");
		e.printStackTrace();
		}
		
	}
	
	// 5. 로그인
	public Member login(String id,String pwd)
	{
		try {
			Member member = dao.login(id,pwd);
			if(member.getId().equals(id) && member.getPwd().equals(pwd))
			{
				return member;
			}
			else
			{
				System.out.println("해당하는 회원이 없습니다.");
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	// 6. 회원 탈퇴(삭제)
	public void delete(String id)
	{
		try {
			dao.delete(id);
			System.out.println("회원 탈퇴가 완료되었습니다.");
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		}
	}
}
