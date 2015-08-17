package demo;

import java.io.IOException;

import demo.d;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if("BAK".equals(id)){
			
			back_number(request, response);
			
		}else if("CE".equals(id)){
			
			clear_session(request);
			
		}else{	
		
			add_number(request, response, id);
		
		}
		
		response.sendRedirect("/demo/jsp/cal.jsp");
		
		
	}
	/**
	 * 实现回退功能
	 * @author Lilac
	 * @param request
	 * @param response
	 */
	
	private void back_number(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException{
		
		d d = (d)request.getSession().getAttribute("num");
		//计算sum
		String[] arr = d.string.split("+");
		Integer linshi = (d.integer)-(Integer.parseInt(arr[arr.length-1]));
		//截取字符串
		
		
		
		request.getSession().setAttribute("num", d);
		
		
	}
	/**
	 * 实现删除session操作
	 * @author Lilac
	 * @param request
	 * @throws ServletException
	 * @throws IOException
	 */

	private void clear_session(HttpServletRequest request)
				throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		
	}

	/**
	 * 使用session实现计算器
	 * @author Lilac
	 * @param request
	 * @param response
	 * @param id
	 * @throws IOException 
	 */
	private void add_number(HttpServletRequest request,
			HttpServletResponse response, String id)
			throws ServletException, IOException{
		d d = (d)request.getSession().getAttribute("num");
		
		if(d == null){
			d =new d();
			d.integer = Integer.parseInt(id);
			d.string = id;
		}
		else{
			d.integer += Integer.parseInt(id);
			d.string = d.string + "+" + id;
		}
		
		request.getSession().setAttribute("num", d);
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
