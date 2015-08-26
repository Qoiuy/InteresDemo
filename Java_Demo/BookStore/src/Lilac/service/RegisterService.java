package Lilac.service;

import java.util.List;

import org.junit.Test;

import Lilac.bean.Register;
import Lilac.dao.RegisterDao;
import Lilac.dao.impl.RegisterDaoImpl;

public class RegisterService {

	/**
	 * 添加用户
	 * @author Lilac
	 * @param register
	 * @return
	 */
	public boolean addUser(Register register) {
		RegisterDao dao = new RegisterDaoImpl();
		boolean bool = dao.insert_user(register);
		return bool;
	}

	/**
	 * 通过用户名值查找数据库 里面是否有数据
	 * @author Lilac
	 * @param username
	 * @return
	 */
	public Boolean Find_User_By_username(String username) {
		RegisterDao dao = new RegisterDaoImpl();
		List<Register> list =  dao.Find_user_by_username(username);
		if(list.size() == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	//有点不放心做个测试
	//我的预感 挺准的~~
	
	@Test
	public void test_Find_User_By_username(){
		boolean bool = Find_User_By_username("7");
			System.out.println(bool);
		boolean bool1 = Find_User_By_username("1");
			System.out.println(bool1);
	}

	/**
	 * 登录操作 判断数据库里面是否有该用户
	 * @author Lilac
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean Login(String username, String password) {
		RegisterDao dao = new RegisterDaoImpl();
		List<Register> list =  dao.Find_user_by_username(username);
		for (Register register : list) {
			if(register.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
}
