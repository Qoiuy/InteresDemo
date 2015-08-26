package Lilac.dao;

import java.util.List;

import Lilac.bean.Register;

public interface RegisterDao {

	boolean insert_user(Register register);

	List<Register> Find_user_by_username(String username);

}
