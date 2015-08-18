package linshi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.acl.LastOwnerException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class download extends HttpServlet {

	public download() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		download(response);
	}

	private void download(HttpServletResponse response)
			throws FileNotFoundException, IOException {
		String path = getServletContext().getRealPath("/img/0001.jpg");
		response.setHeader("Content-Disposition", "attachment;filename="+path.substring(path.lastIndexOf("\\") + 1));
		InputStream io = new FileInputStream(path);
		OutputStream ot = response.getOutputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while((len = io.read(b)) != -1){
			ot.write(b,0,len);
		}
		io.close();
	}

	

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
