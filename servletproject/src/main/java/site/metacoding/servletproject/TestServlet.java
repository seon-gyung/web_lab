package site.metacoding.servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:80/index.jsp (URL) 파일 요청
// http://localhost:80/hello (URI) 식별자 요청
@WebServlet("/test")
public class TestServlet extends HttpServlet{

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	// 사용자에게 받은 httpbody, httpheader 정보를 HttpServletRequest req에 담고
	// 그 친구한테 응답될 빈 객체 HttpServletResponse resp를 만들어서
	// doGet(req, resp); 담아서 호출해준다. (아파치/톰캣에 의해 호출됨)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get 요청됨");
		
		String name = "SeonGyung";
		
        // printWriter에는 \n, flush 까지 내부에 적용되어 있음
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello EveryOne "+name+" </h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
