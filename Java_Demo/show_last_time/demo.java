package linshi;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import com.sun.mail.iap.Response;

public class demo extends HttpServlet {

	public demo() {
		super();
	}

	/**
	 * 查看用户最后一次访问时间 附带添加cookie时间操作和注销cookie操作
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = show_last_time(request, response);
		//add_cookie_time(cookie,response);
		//destory_cookie(cookie,response);
	}

	private void add_cookie_time(Cookie cookie, HttpServletResponse response) {
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	}

	private void destory_cookie(Cookie cookie, HttpServletResponse response) {
		//Cookie cookie = new Cookie("last_time", new Date().toLocaleString().toString());
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private Cookie show_last_time(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = Find_Cookie_From_Cookies_By_name(cookies, "last_time");
		
		if(cookie == null ){
			response.getWriter().write("您之前没有访问。那我给您找个毛线球啊".toString());
		}
		else{
			response.getWriter().write(cookie.getValue());
		}
		
		Cookie lastCookie = new Cookie("last_time", new Date().toLocaleString().toString());
		
		lastCookie.setPath("/");
		
		response.addCookie(lastCookie);
		
		return lastCookie;
	}

	private Cookie Find_Cookie_From_Cookies_By_name(Cookie[] cookies,
			String string) {
		
		if(cookies == null)
			return null;
		for (Cookie cookie : cookies) {
			if(string.equals(cookie.getName().toString()))
				return cookie;
		}
		
		return null;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
