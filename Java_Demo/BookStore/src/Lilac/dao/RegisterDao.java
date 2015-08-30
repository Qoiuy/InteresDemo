package Lilac.dao;

import java.util.List;

import Lilac.bean.User;

public interface RegisterDao {

	boolean insert_user(User user);

	List<User> Find_user_by_username(String username);

}
