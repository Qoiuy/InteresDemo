package Lilac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Lilac.bean.Register;
import Lilac.bean.User;
import Lilac.service.RegisterService;

public class LoginServlet extends HttpServlet {

	/**
	 * 实现登录界面
	 * 记录用户名 自动登录操作
	 * @author Lilac
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try{
			BeanUtils.populate(user, request.getParameterMap());
			
			Boolean bool = new RegisterService().Login(user.getUsername(),user.getPassword());
			if(bool){
				 auto_login(request, response, user);
				 request.getSession().setAttribute("user", user);
				 response.getWriter().write("登录成功");
			}
			else{
				 request.setAttribute("msg", "用户名或密码错误");
				 request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		
//		String remember_user = request.getParameter("remember_user");
//		if("user_auto".equals(remember_user))
		 
		
		
	}
	/**
	 * 实现自动登录操作之一 保存数据到cookie
	 * @author Lilac
	 */
	private void auto_login(HttpServletRequest request,	HttpServletResponse response, User user) {
			String remember_login = request.getParameter("remember_login");
			if(remember_login != null && "login_auto".equals(remember_login)){
				Cookie cookie = new Cookie("autologin", user.getUsername() +"#Lilac#"+user.getPassword());
				cookie.setMaxAge(36000);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
