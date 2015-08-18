package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.MyJdbcUtils;
import bean.Register;

public class RegisterDaoImpl implements RegisterDao {

	

	@Override
	public boolean register(Register register) {
		Connection conn = null;
		PreparedStatement psmt = null;
//		ResultSet rs = null;
		try {
			
			conn = MyJdbcUtils.getConnection();
			String sql = "insert into register values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, register.getMail());
			psmt.setString(2, register.getUsername());
			psmt.setString(3, register.getPassword());
			psmt.setString(4, register.getSex());
			psmt.setString(5, register.getPhone());
			psmt.setString(6, register.getDescript());

			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			return false;
		}finally{
			MyJdbcUtils.clearConn(null, psmt, conn);
		}
		
	}

}
