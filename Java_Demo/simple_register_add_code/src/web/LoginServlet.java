package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.RegisterService;
import service.UserService;
import utils.code;
import bean.Register;
import bean.User;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//Login(request, response);
				
				Register(request, response);
				
				
		
	}


	/**
	 * @author teacher
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User user = new User();
		
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(new UserService().Userlogin(user)){
			response.sendRedirect("/day12/login/success.jsp");
		}
		else{
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}
	/**
	 * @author Lilac
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @throws ServletException
	 * @throws IOException
	 */

	private void Register(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException,
			ServletException, IOException {
		Register register = new Register();
		 
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;character=utf-8");
		 
		 try {
				BeanUtils.populate(register, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 
		 boolean bool = new RegisterService().realcode((String)request.getSession().getAttribute("code"), register);
		 
		 if(bool){
				 if( new RegisterService().Register(register)){
					 request.setAttribute("reg", "注册成功");
					 request.getRequestDispatcher("/register.jsp").forward(request, response);
				 }
				 else{
					 request.setAttribute("reg", "用户名或密码错误 请重新注册");
					 request.getRequestDispatcher("/register.jsp").forward(request, response);
				 }
		 }
		 else{
			 request.setAttribute("reg", "验证码错误");
			 request.getRequestDispatcher("/register.jsp").forward(request, response);
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
