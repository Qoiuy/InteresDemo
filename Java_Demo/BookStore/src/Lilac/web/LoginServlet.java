package Lilac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Lilac.bean.Register;
import Lilac.service.RegisterService;

public class LoginServlet extends HttpServlet {

	/**
	 * 实现登录界面
	 * 记录用户名 自动登录操作
	 * @author Lilac
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		 login(request, response);
		
		
	}

	/**
	 * 登录操作
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 Boolean bool = new RegisterService().Login(username,password);
		 
		 if(bool){
			 response.getWriter().write("登录成功");
		 }
		 else{
			 request.setAttribute("msg", "用户名或密码错误");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
		 }
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
