package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import utils.MyJdbcUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3p0 {
	
	/**
	 * 正常使用c3p0
	 */
	public static ComboPooledDataSource getConnection()throws Exception{
		
		return new ComboPooledDataSource();
		
	}
	
	/**
	 * 使用配置文件配置c3p0， 满足2个条件
	 * 配置文件名称为c3p0-config.xml 同时配置文件放在src下面
	 * @throws Exception
	 */
	public static Connection getConnection_by_config_file()throws Exception{
		
		ComboPooledDataSource data = new ComboPooledDataSource();
		Connection conn = data.getConnection();
		
		return conn;
	}
	@Test
	public void test_getConnection_by_config_file(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = C3p0.getConnection_by_config_file();
					
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
	* 手动设置c3p0
	*/
	public static Connection getConnection_by_hand()throws Exception{
		
		ComboPooledDataSource data  = new ComboPooledDataSource();
		
		data.setDriverClass("com.mysql.jdbc.Driver");
		data.setJdbcUrl("jdbc:mysql:///day13");
		data.setUser("root");
		data.setPassword("jiandan");
		
		return data.getConnection();
	}
	
	@Test
	public void test_getConnection_by_hand(){
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
	
}
