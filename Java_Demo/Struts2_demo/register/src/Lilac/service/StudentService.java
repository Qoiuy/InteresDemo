package Lilac.service;

import Lilac.domain.Student;
import Lilac.exception.UsernameExistException;


/**
 * @author Lilac
 */
public interface StudentService {
	
	
	/**
	 * 登录账户
	 * @param username
	 * @param password
	 * @return 如果用户名或密码错误 返回null
	 */
	public Student login(String username, String password);
	
	/**
	 * 注册功能
	 * @param student
	 * @throws UsernameExistException 如果用户名存在 抛出此异常 
	 */
	public void register(Student student) throws UsernameExistException;
	
}