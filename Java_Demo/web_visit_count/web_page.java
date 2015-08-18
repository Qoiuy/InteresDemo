package 网站访问次数;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class web_page extends HttpServlet {

	public web_page() {
		super();
	}

	public void init() throws ServletException {
		getServletContext().setAttribute("count", 0);
	}

	/**
	 * 这个页面是client访问的页面 client每一次访问这个页面 都会进行计数  
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("hello web");
		
		getServletContext().setAttribute("count",(Integer)getServletContext().getAttribute("count")+1 );
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
