package Lilac.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import Lilac.bean.User;
import Lilac.service.RegisterService;
/**
 * 实现自动登录之二 添加过滤器
 * @author Lilac
 *
 */
public class AutoLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)req;
			User user = (User) request.getSession().getAttribute("user");
			if(user != null){
				chain.doFilter(request, resp);
			}else{
				Cookie[] cookies = request.getCookies();
				Cookie cookie = findCookie(cookies, "autologin");
				if(cookie == null){
					chain.doFilter(request, resp);
				}else{
					String[] userpass = cookie.getValue().split("#Lilac#");
					
					boolean bool = new RegisterService().Login(userpass[0], userpass[1]);
					
					if(bool){
						chain.doFilter(request, resp);
					}else{
						User u = new User();
						u.setUsername(userpass[0]);
						u.setPassword(userpass[1]);
						request.getSession().setAttribute("user", u);
						chain.doFilter(request, resp);
					}
				}
				
			}
			
	}

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

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
