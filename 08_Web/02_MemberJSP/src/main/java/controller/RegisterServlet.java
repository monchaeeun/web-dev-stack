package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. (있으면 form 값 받아온다)

			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));

			System.out.println(id);
			System.out.println(pwd);
			System.out.println(name);
			System.out.println(age);
			
		// 2. DAO 호출 - DB 접근 필요 시	
			MemberDAO dao = new MemberDAO();
			Member member = new Member();
			
			member.setId(id);
			member.setName(name);
			member.setPwd(pwd);
			member.setAge(age);
			
			try {
				dao.register(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		// 3. 결과 페이지
		response.sendRedirect("result.jsp");	
	}
}
