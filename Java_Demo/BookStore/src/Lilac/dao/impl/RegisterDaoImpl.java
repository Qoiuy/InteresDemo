package Lilac.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import Lilac.bean.Register;
import Lilac.dao.RegisterDao;

public class RegisterDaoImpl implements RegisterDao {

	/**
	 * 想数据库中添加数据
	 * @author Lilac
	 */
	public boolean insert_user(Register r) {
		int rows;
		try {
			QueryRunner runner = new QueryRunner(new ComboPooledDataSource()); 
			Object[] os = {r.getEmail(),r.getUsername(),r.getPassword(),r.getGender(),r.getTelephone(),r.getIntroduce()};
				
			rows = runner.update("insert into user values(?,?,?,?,?,?)", os);
			if(rows > 0) return true; else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Add
	 * 测试数据库操作
	 * @author Lilac
	 * 
	 */
//	@Test
//	public void test_insert_user(){
//		Register register = new Register();
//		register.setEmail("邮箱");
//		register.setGender("男");
//		register.setIntroduce("个人简介");
//		register.setPassword("密码");
//		register.setTelephone("电话号");
//		register.setUsername("用户名");
//		Boolean bool = insert_user(register);
//		System.out.println(bool);
//		//System.out.println(register.getEmail() +"·····"+ register.getGender() +"·····"+ register.getIntroduce() +"·····"+ register.getPassword() +"·····"+ register.getTelephone() +"·····"+ register.getUsername() );
//			
//	}

	/**
	 * Find
	 * 通过用户名查找用户名是否存在
	 * @author Lilac
	 */
	public List<Register> Find_user_by_username(String username) {
		List<Register> rows = null;
		try {	
			QueryRunner runner = new QueryRunner(new ComboPooledDataSource()); 
			rows = runner.query("select * from user where username=?",new BeanListHandler<Register>(Register.class),username );
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	} 
	@Test
	public void test_Find_user_by_username(){
		String username = "2221234123";
		String usernaem_null = "7";
		List<Register> list = Find_user_by_username(username);
		for (Register register : list) {
			System.out.println("user---->"+ register.getUsername());
		}
		List<Register> list_null = Find_user_by_username(usernaem_null);
		for (Register register : list_null) {
			System.out.println("null--->"+register.getUsername());
		}
	}

}
