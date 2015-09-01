package loveyakamoz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.junit.Test;

public class linshi {
//	private static String EncodeInput = "GBK";
//	private static String EncodeOutput = "GBK";
	private static String EncodeInput = "UTF-8";
	private static String EncodeOutput = "UTF-8";
	//转换字符编码 从EncodeInput 转成  EncodeOutput
	private static void message( String szMsg ) {
		try{
			byte[] b = szMsg.getBytes(EncodeInput);
			System.out.println(new String(b, EncodeOutput)); 
//			System.out.println(szMsg); 
		}   
		catch(Exception e ){}
	}
	
	public static String openFile( String szFileName ) {
        try {
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream( new File(szFileName)),EncodeInput) );
            String szContent="";
            String szTemp;
            
            while ( (szTemp = bis.readLine()) != null) {
                szContent+=szTemp+"\n";
            }
            bis.close();
            return szContent;
        }
        catch( Exception e ) {
            return "";
        }	
	}
	    
	    
    @Test
    public void test() {
         
         try{
        	 //打开url连接
        	 String url = "http://roll.news.sina.com.cn/news/gnxw/gdxw1/index.shtml?qq-pf-to=pcqq.c2c";
        	 HttpURLConnection http = (HttpURLConnection) (new URL(url)).openConnection();
        	 //----------------------------------------------------------------------------------------------------我是分割线 读代码专用-------------------------------------
             Parser parser = new Parser(http);
	         
             for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
                 Node node = i.nextNode();
                 message("getText:"+node.getText());
                 message("getPlainText:"+node.toPlainTextString());
                 message("toHtml:"+node.toHtml());
                 message("toHtml(true):"+node.toHtml(true));
                 message("toHtml(false):"+node.toHtml(false));
                 message("toString:"+node.toString());
             }            
         }
         catch( Exception e ) {     
            e.printStackTrace();
         }
     }

	    
	    
}
   