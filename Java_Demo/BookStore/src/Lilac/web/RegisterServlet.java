package Lilac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Lilac.bean.Register;
import Lilac.service.RegisterService;

public class RegisterServlet extends HttpServlet {

	/**
	 * 实现注册功能
	 * @author Lilac
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Register register = new Register();
		try {
			BeanUtils.populate(register, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		/**
		 * 测试一下javabean
		 * System.out.println(register.getEmail() +"·····"+ register.getGender() +"·····"+ register.getIntroduce() +"·····"+ register.getPassword() +"·····"+ register.getTelephone() +"·····"+ register.getUsername() );
		 */
		
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
			
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
