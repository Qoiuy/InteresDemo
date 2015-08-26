package listener.init_destory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * 访问一个JSP会不会创建session?      会创建session对象
 * 访问一个Servlet会不会创建session?  不会创建session对象
 * 访问一个html会不会创建session?     不会创建session对象 
 * @author Lilac
 *
 */
public class Session_Destroyed_and_Created implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session Created---------------------------------------------------");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session Destroyed---------------------------------------------------");
	}

}
