package Lilac.dao;

import Lilac.domain.Student;

public interface StudentDao {

	/**
	 * 通过用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return 如果用户名或密码不存在  则返回null
	 */
	public Student find(String username, String password) ;


	/**
	 * 查找用户名是否存在
	 * @param username
	 * @return 如果用户名已经存在 返回 true
	 */
	public boolean findStudentByUsername(String username) ;

	/**
	 * 保存用户信息
	 * @param student
	 */
	public void save(Student student);

}
