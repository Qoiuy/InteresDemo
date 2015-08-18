package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class refresh extends HttpServlet {

	public refresh() {
		super();
	}

	/**
	 * 实现定时跳转
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("Refresh","3;url=/demo/login.jsp");
		//response.setContentType("text/html","charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("");
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
