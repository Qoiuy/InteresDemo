package listener.init_destory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Request_Destroyed_and_Initialized implements ServletRequestListener{

	/**
	 * == 访问JSP的时候会不会创建request对象?     会创建request对象
	 * == 访问Servlet的时候会不会创建request对象? 会创建request对象
	 * == 访问一个html的时候会不会创建request?    会创建request对象
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("servletrequest destoryed------------------------------------------------------------------");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {

		System.out.println("servletrequest Initialized------------------------------------------------------------------");
	}

}
