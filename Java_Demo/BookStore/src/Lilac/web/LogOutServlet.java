package Lilac.web;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet {

	/**
	 * 注销功能
	 * 删除cookie里面的数据和session里面的数据
	 * @author Lilac
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		
		Cookie[] cookies = request.getCookies();
		
		Cookie user = FindCookie(cookies, "autologin");
		user.setMaxAge(0);
		user.setPath("/");
		response.addCookie(user);
		response.sendRedirect("/BookStore/index.jsp");
	}

	private Cookie FindCookie(Cookie[] cookies, String string) {
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
