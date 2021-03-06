package demo;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class code extends HttpServlet {

	public code() {
		super();
	}

	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BufferedImage img = new BufferedImage( 150,  75, BufferedImage.TYPE_3BYTE_BGR);
		
		
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		
		Random ran = new Random();
		String word =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		g2d.setColor(Color.yellow);
		g2d.setFont(new Font("宋体",Font.BOLD,20));
		
		int x = 30;
		for (int i = 0; i < 4; i++)		{
			
			char ch =word.charAt(ran.nextInt(word.length()));
			System.out.println(ch+"");
			double hudu = (ran.nextInt(60)-30)*Math.PI/180;
			g2d.rotate(hudu, x, 30);

			g2d.drawString(ch + "", x += 25, 30);

			g2d.rotate(-hudu, x-25, 30);
		} 
		
		g2d.setColor(Color.green);
		for(int m=1;m<=3;m++) {
			g2d.drawLine(ran.nextInt(125), ran.nextInt(50), ran.nextInt(125), ran.nextInt(50));
		}
		
		ImageIO.write(img, "jpg", response.getOutputStream());
		
			
	}


	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
