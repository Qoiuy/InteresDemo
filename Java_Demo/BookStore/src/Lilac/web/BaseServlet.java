package Lilac.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			String method = req.getParameter("method");
			if(method == null) method = "execute";
			Method m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			Object o = m.invoke(this, req, resp);
			if(o != null){
				req.getRequestDispatcher(o+"").forward(req, resp);
			}
		}catch(Exception e ){
			
		}
	}

	

}
