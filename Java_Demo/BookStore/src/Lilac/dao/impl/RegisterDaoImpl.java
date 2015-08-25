package Lilac.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import Lilac.bean.Register;
import Lilac.dao.RegisterDao;

public class RegisterDaoImpl implements RegisterDao {

	public boolean insert_user(Register r) {
		QueryRunner runner = new QueryRunner(new ComboPooledDataSource()); 
		
		Object[] os = {r.getEmail(),r.getUsername(),r.getPassword(),r.getGender(),r.getTelephone(),r.getIntroduce()};
			
		int rows;
		try {
			rows = runner.update("insert into register values(?,?,?,?,?,?)", os);
			if(rows > 0) return true; else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 测试数据库操作
	 * @author Lilac
	 * 
	 */
	@Test
	public void test(){
		Register register = new Register();
		register.setEmail("邮箱");
		register.setGender("男");
		register.setIntroduce("个人简介");
		register.setPassword("密码");
		register.setTelephone("电话号");
		register.setUsername("用户名");
		Boolean bool = insert_user(register);
		System.out.println(bool);
		//System.out.println(register.getEmail() +"·····"+ register.getGender() +"·····"+ register.getIntroduce() +"·····"+ register.getPassword() +"·····"+ register.getTelephone() +"·····"+ register.getUsername() );
			
	}

}
