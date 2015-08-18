package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {

	public login() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(username)&& "123456".equals(password) ){
			response.getWriter().write("login success");
		}
		else{
//			response.setStatus(302);
//			response.setHeader("Location", "/demo/login.jsp");
			response.sendRedirect("/demo/login.jsp");
		}
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
