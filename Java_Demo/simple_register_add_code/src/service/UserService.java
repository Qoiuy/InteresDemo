package service;

import dao.UserDao;
import dao.UserDaoImpl;
import bean.User;

public class UserService {

	public boolean Userlogin(User user ){
		
		return new UserDaoImpl().login(user);
	}
	
}
