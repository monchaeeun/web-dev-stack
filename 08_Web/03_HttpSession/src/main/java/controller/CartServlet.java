package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public void service(HttpServletRequest request, HttpServletResponse response) {
        // ProductServlet 에서 여기로 왔을 때도 user 정보를 가지고 오게끔!
    	HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("user");
        System.out.println("cart : "+member);
        
        // 세션 정보 죽이기 -> 로그아웃
        session.invalidate();
       }

}
