package Lilac.service;

import Lilac.bean.Register;
import Lilac.dao.RegisterDao;
import Lilac.dao.impl.RegisterDaoImpl;

public class RegisterService {

	public boolean addUser(Register register) {
		RegisterDao dao = new RegisterDaoImpl();
		boolean bool = dao.insert_user(register);
		return bool;
	}

}
