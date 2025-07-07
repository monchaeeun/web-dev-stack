package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/word")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get 방식으로 호출!");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post 방식으로 호출!");
	}
	//무조건 service 먼저 호출
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 필수 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset= utf-8");
		String keword = request.getParameter("keyword");
		System.out.println(keword);
		System.out.println("service 방식으로 호출!");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>");
		out.println(keword);
		out.println("</h1>");
		out.println("</body></html>");
		
		out.close();
		
		// 요청으로 받은 keyword 값 그대로 브라우저 상에 나타나도록! h1태그 사용
	}

}
