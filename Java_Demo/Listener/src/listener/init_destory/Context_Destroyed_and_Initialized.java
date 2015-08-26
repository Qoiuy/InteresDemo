package listener.init_destory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 需要配置web.xml文件
 * @author Lilac
 *
 */
public class Context_Destroyed_and_Initialized implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servletcontext destoryed------------------------------------------------------------------");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servletcontext inittialized---------------------------------------------------------------");
	}

}
