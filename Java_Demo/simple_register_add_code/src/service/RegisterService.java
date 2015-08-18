package service;

import bean.Register;
import dao.RegisterDaoImpl;

public class RegisterService {

	public boolean realcode(String code, Register register){
		return register.getCode().equalsIgnoreCase(code);
	}
	
	public  boolean Register(Register register){
			
			return new RegisterDaoImpl().register(register); 
			
	}

}
