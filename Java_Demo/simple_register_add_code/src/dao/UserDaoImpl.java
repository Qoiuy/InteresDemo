package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.MyJdbcUtils;


import bean.User;

public class UserDaoImpl implements UserDao {

	
	public boolean login(User user) {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			
			conn = MyJdbcUtils.getConnection();
			String sql = "select * from user where username =? and password =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyJdbcUtils.clearConn(rs, psmt, conn);
		}
		
		return false;
	}

	
	
}
