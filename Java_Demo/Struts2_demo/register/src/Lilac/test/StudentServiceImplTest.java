package Lilac.test;

import org.junit.Test;

import Lilac.domain.Student;
import Lilac.exception.UsernameExistException;
import Lilac.service.StudentService;
import Lilac.service.impl.StudentServiceImpl;

public class StudentServiceImplTest {
	StudentService service = new StudentServiceImpl();
	@Test
	public void testLogin() {
		String username = "a";
		String password = "123";
		service.login(username, password);
	}

	@Test
	public void testRegister() throws UsernameExistException {
		Student student = new Student();
		student.setUsername("asdf");
		student.setPassword("123");
		student.setTelphone("183");
		student.setEmail("112a@qq.com");
		service.register(student);
	}

}
