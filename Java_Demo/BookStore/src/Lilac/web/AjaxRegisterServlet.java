package Lilac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

public class AjaxRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Code_client = request.getParameter("code");
		String Code_service_session = (String) request.getSession().getAttribute("code");
		if( ! Code_client.equalsIgnoreCase(Code_service_session)){
			response.getWriter().write("false");
		}
		else{
			response.getWriter().write("true");
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
