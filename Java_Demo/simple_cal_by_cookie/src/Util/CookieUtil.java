package Util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Cookie findCookie(Cookie[] cookies,String name) {
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
}
