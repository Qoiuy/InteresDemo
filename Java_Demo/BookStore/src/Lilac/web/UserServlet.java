package Lilac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Lilac.bean.User;
import Lilac.service.RegisterService;


@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	
	
	/**
	 * 实现登录界面
	 * 记录用户名 自动登录操作
	 * @author Lilac
	 */
	public String login(HttpServletRequest request, HttpServletResponse response ){
		User register = new User();
		try{
			BeanUtils.populate(register, request.getParameterMap());
			
			Boolean bool = new RegisterService().Login(register.getUsername(),register.getPassword());
			if(bool){
				 auto_login(request, response, register);
				 request.getSession().setAttribute("user", register);
				 response.getWriter().write("登录成功");
				 response.setHeader("Refresh","3;url=/BookStore/index.jsp");
			}
			else{
				 request.setAttribute("msg", "用户名或密码错误");
				 request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}catch (Exception e) {} 
		
		return null;
	}
	
	/**
	 * 登录界面用函数---->实现自动登录操作之一 保存数据到cookie
	 * @author Lilac
	 */
	private void auto_login(HttpServletRequest request,	HttpServletResponse response, User user) throws ServletException, IOException  {
			String remember_login = request.getParameter("remember_login");
			if(remember_login != null && "login_auto".equals(remember_login)){
				Cookie cookie = new Cookie("autologin", user.getUsername() +"#Lilac#"+user.getPassword());
				cookie.setMaxAge(36000);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
	}
	
	/**
	 * 实现用户注销功能
	 * 删除cookie里面的数据和session里面的数据
	 * @author Lilac
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		
		Cookie user = findCookie(cookies, "autologin");
		user.setMaxAge(0);
		user.setPath("/");
		response.addCookie(user);
		response.sendRedirect("/BookStore/index.jsp");
		return null;
	}
	
	/**
	 * 注销功能用函数---->找到指定的cookie
	 * @author Lilac
	 */
	private Cookie findCookie(Cookie[] cookies, String string) {
		if(cookies == null){
			return null;
		}
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(string)){
				return cookie;
			}
		}
		return null;
	}

	/**
	 * 实现注册功能
	 * @author Lilac
	 */
	public String register(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		User register = new User();
		try {
			BeanUtils.populate(register, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 // 测试一下javabean
		 // System.out.println(register.getEmail() +"·····"+ register.getGender() +"·····"+ register.getIntroduce() +"·····"+ register.getPassword() +"·····"+ register.getTelephone() +"·····"+ register.getUsername() );
		/**
		 * 添加用户数据到数据库
		 */
		boolean bool = new RegisterService().addUser(register);
		if(bool){
			response.sendRedirect("/BookStore/registersuccess.jsp");
		}
		else{
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		return null;
	}
	
	/**
	 * 用ajax对用户名进行验证
	 * 有机会将多余的ajax servlet进行汇总
	 * 当用户名在数据库中不存在 返回ture
	 * @author Lilac
	 */
	public String ajaxCheckUser(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException{
		String username = request.getParameter("username");
		Boolean bool = new RegisterService().Find_User_By_username(username);
		
		if(bool){
			response.getWriter().write("false");
		}
		else{
			if(username.length()>5)
				response.getWriter().write("true");
			else
				response.getWriter().write("false");
		}
		return null;
	}
	
}
