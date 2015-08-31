package Estore.Lilac.Web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 编写通用的Servlet
 * @author Teacher
 *
 */
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try{
				String method = request.getParameter("method");
				if(method == null){
					method = "execute";
				}
				@SuppressWarnings("rawtypes")
				Class clazz = this.getClass();
				@SuppressWarnings("unchecked")
				Method  m1 = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				Object o = m1.invoke(this, request, response);
				if(o == null ){
					request.getRequestDispatcher(o + "").forward(request, response);
				}
			}catch(Exception e){
			//	e.printStackTrace();
			}
		
	}

}
