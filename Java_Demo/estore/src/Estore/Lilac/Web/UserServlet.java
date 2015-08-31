package Estore.Lilac.Web;

import Estore.Lilac.Bean.User;
import Estore.Lilac.Service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	
	/**
	 * 登录
	 * @author Lilac
	 */
	public String login (HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		try{
			BeanUtils.populate(user, request.getParameterMap());
			User u = new UserService().login(user);
			if(u == null){
				request.setAttribute("msg", "用户名或者密码错误");
				return "/jsps/user/login.jsp";
			}else{
				request.getSession().setAttribute("user", u);
				response.sendRedirect(request.getContextPath()+"/jsps/main.jsp");
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		return null;
	}
}
