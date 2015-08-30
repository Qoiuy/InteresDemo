package Lilac.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class CodeServlet extends BaseServlet {
	/**
	 * 生成验证码
	 * @author Lilac
	 */
	public String code(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException {
		BufferedImage img = new BufferedImage( 150,  50, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		
		Random ran = new Random();
		String  word=  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		g2d.setColor(Color.yellow);
		g2d.setFont(new Font("宋体",Font.BOLD,20));
		
		StringBuffer code = new StringBuffer();
		
		int x = 30;
		for (int i = 0; i < 4; i++)		{
			
			double hudu = (ran.nextInt(60)-30)*Math.PI/180;
			g2d.rotate(hudu, x, 30);

			char c = word.charAt(ran.nextInt(word.length()));
			
			code.append(c);
			
			g2d.drawString( c+ "", x, 30);

			g2d.rotate(-hudu, x, 30);
			
			x += 25;
		}
		
		g2d.setColor(Color.green);
		for(int m=1;m<=3;m++) {
			g2d.drawLine(ran.nextInt(150), ran.nextInt(50), ran.nextInt(150), ran.nextInt(50));
		}
		
		request.getSession().setAttribute("code", code.toString());
		
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		return null;
	}
	
	
	/**
	 * 用ajax对验证码进行校验 
	 * 当验证码验证成功的时候返回true
	 * @author Lilac
	 */
	public String ajaxCheckCode(HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException	{
		String Code_client = request.getParameter("code");
		String Code_service_session = (String) request.getSession().getAttribute("code");
		if( ! Code_client.equalsIgnoreCase(Code_service_session)){
			response.getWriter().write("false");
		}
		else{
			response.getWriter().write("true");
		}
		return null;
	}
}
