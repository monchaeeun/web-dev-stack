package controller.component;

import java.util.ArrayList;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = dao.printAll();

		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp",false);
	}

}
