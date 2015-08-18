package 网站访问次数;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class count_page extends HttpServlet {

	public count_page() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			System.out.println("网站被访问的次数为:"+ getServletContext().getAttribute("count"));
			response.getWriter().write("网站被访问的次数为:"+ getServletContext().getAttribute("count"));
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
