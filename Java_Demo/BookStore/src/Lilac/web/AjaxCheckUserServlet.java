package Lilac.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lilac.bean.Register;
import Lilac.service.RegisterService;

public class AjaxCheckUserServlet extends HttpServlet {

	/**
	 * 用ajax对用户名进行验证
	 * 有机会将多余的ajax servlet进行汇总
	 * 当用户名在数据库中不存在 返回ture
	 * @author Lilac
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		Boolean bool = new RegisterService().Find_User_By_username(username);
		
		if(bool){
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
