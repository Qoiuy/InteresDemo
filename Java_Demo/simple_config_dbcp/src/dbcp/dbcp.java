package dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


import org.junit.Test;

import utils.MyJdbcUtils;

public class dbcp {

	
	
	/**
	 * 使用手动配置dbcp连接池
	 * @author Lilac
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection_by_hand() throws Exception{
		BasicDataSource d = new BasicDataSource();
		
		d.setDriverClassName("com.mysql.jdbc.Driver");
		d.setUrl("jdbc:mysql:///day13");
		d.setUsername("root");
		d.setPassword("jiandan");
		Connection conn = d.getConnection();
		
		return conn;	
	}
		
	@Test
	public  void test_getConnection_by_hand(){
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection_by_hand();
					
			String sql = "select * from account";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			
		}finally{
			MyJdbcUtils.clearConn(rs, psmt, conn); 
		}
	}
	
	/**
	 * 使用配置文件配置dbcp连接池
	 * @author Lilac
	 * 
	 */
	public static Connection getConnection_by_content_file()throws Exception{
		
		Properties p = new Properties();
		
		InputStream in =  dbcp.class.getClassLoader().getResourceAsStream("dbcp.peoperties");
		
		p.load(in);
		
		return BasicDataSourceFactory.createDataSource(p).getConnection();
		
	}
	
	@Test
	public void test_getConnection_by_content_file(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection_by_content_file();
					
			String sql = "select * from account";
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			
		}finally{
			MyJdbcUtils.clearConn(rs, psmt, conn); 
		}
	}
	
	
}
