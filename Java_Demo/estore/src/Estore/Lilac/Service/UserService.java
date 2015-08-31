package Estore.Lilac.Service;

import Estore.Lilac.Bean.User;
import Estore.Lilac.Dao.UserDao;
import Estore.Lilac.Dao.UserDaoImpl;

public class UserService {
	public User login(User user) {
		UserDao dao = new UserDaoImpl();
		return dao.login(user);
	}

}
