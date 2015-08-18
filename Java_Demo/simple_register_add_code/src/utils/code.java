package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;



public class code {

	public String make_code(HttpServletResponse response) throws IOException{
		String code = new String();
		
		BufferedImage img = new BufferedImage( 150,  50, BufferedImage.TYPE_3BYTE_BGR);
		
		
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		
		Random ran = new Random();
		String word =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		g2d.setColor(Color.yellow);
		g2d.setFont(new Font("宋体",Font.BOLD,20));
		
		int x = 30;
		for (int i = 0; i < 4; i++)		{
			
			double hudu = (ran.nextInt(60)-30)*Math.PI/180;
			g2d.rotate(hudu, x, 30);

			g2d.drawString(word.charAt(ran.nextInt(word.length())) + "", x += 25, 30);

			g2d.rotate(-hudu, x, 30);
		}
		
		g2d.setColor(Color.green);
		for(int m=1;m<=3;m++) {
			g2d.drawLine(ran.nextInt(150), ran.nextInt(50), ran.nextInt(150), ran.nextInt(50));
		}
		
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		return code;
	}
	
	
}
