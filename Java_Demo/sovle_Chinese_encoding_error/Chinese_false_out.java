package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Chinese_false_out extends HttpServlet {

	public Chinese_false_out() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response 两种输出机制 字节流和字符流
		
		//字节流   让浏览器的编码和字节数组的编码一致
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.getOutputStream().write("字节流中文".getBytes("utf-8"));
		
		//字符流  设置response缓冲区的编码
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("字符流中文");
		//解决字符流乱码的具体实现
//		response.setCharacterEncoding("text/html;charset=utf-8");
//		response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//request 乱码一般指post和get方式提交的时候产生乱码
		//解决post提交时候的乱码
		//post提交表单的时候，request会把数据放到缓冲区内，缓冲区内编码不支持中文，修改缓冲区编码就OK
		request.setCharacterEncoding("utf-8");
		
		//解决get提交时出现乱码
		//解决乱码方法有三种
		
		//解决方案一：修改server.xml 修改这个文件需要tomcat配置文件的权限，一般程序员无法修改
		<Connector port="80" protocol="HTTP/1.1"       
		connectionTimeout="20000" redirectPort="8443" URIEncoding="utf-8"/>

		//解决方案二：逆向编解码
		username = URLEncoder.encode(username, "ISO8859-1");
		username = URLDecoder.decode(username, "utf-8");

		//解决方案三：简化
		username = new String(username.getBytes("ISO8859-1"),"utf-8");

		
		
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
