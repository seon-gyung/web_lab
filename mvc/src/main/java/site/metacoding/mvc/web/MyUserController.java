package site.metacoding.mvc.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.domain.MyUser;
import site.metacoding.mvc.domain.MyUserRepository;

// 회원 관련 요청만 컨트롤함
public class MyUserController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private MyUserRepository repo;
	
	public MyUserController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		repo = new MyUserRepository();
	}
	
	// GET : http://localhost:8000/myuser
	public void getAll() {
        System.out.println("getAll 호출됨");
        List<MyUser> myUsers = repo.selectAll();
        request.setAttribute("myUsers", myUsers);
        try {
            RequestDispatcher dis = request.getRequestDispatcher("/user.jsp");
            dis.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	// GET : http://localhost:8000/myuser?id=1
	public void getOne(int id) {
		System.out.println("getOne 호출됨");
		MyUser myUser = repo.selectById(id);
		System.out.println("myUser : "+myUser.getUsername());
		request.setAttribute("myUser", myUser);
		
		try {
			// response.sendRedirect("/userInfo.jsp"); // 저장장치가 실행
			RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
