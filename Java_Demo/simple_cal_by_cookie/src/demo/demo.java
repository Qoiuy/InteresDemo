package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo extends HttpServlet {

	public demo() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id = request.getParameter("num");
			
			if("sum".equals(id)){
				
			}else if("BAK".equals(id)){
				
			}else if("CE".equals(id)){
				
				clear_number(request, response, id);
				
			}else{	
			
				add_number(request, response, id);
			
			}
			response.sendRedirect("/demo/jsp/cal.jsp");
	}

	private void clear_number(HttpServletRequest request,
			HttpServletResponse response, String id) {
		Cookie cookie = FindCookie(request.getCookies(),"num");
		if(cookie != null){
			Cookie newcookie = new Cookie("num",id);
			newcookie.setMaxAge(0);
			newcookie.setPath("/");
			response.addCookie(newcookie);
		}
	}

	private void add_number(HttpServletRequest request,
			HttpServletResponse response, String id) {
		Cookie cookie = FindCookie(request.getCookies(),"num");
		
		if(cookie == null){
			Cookie newcookie = new Cookie("num",id );
			System.out.println(newcookie.getValue());
			newcookie.setMaxAge(3600);
			newcookie.setPath("/");
			response.addCookie(newcookie);
		}
		else{
			Cookie newcookie = new Cookie("num", cookie.getValue() + "+" + id);
			newcookie.setMaxAge(3600);
			newcookie.setPath("/");
			response.addCookie(newcookie);
		}
	}

	private Cookie FindCookie(Cookie[] cookies, String name) {
		if(cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			//得到cookie的名称
			String cookieName = cookie.getName();
			if(name.equals(cookieName)) {
				return cookie;
			}
		}	
		return null;
	}
	
	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
