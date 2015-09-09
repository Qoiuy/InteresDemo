package Lilac.test;

import org.junit.Test;

import Lilac.dao.StudentDao;
import Lilac.dao.impl.StudentDaoImpl;
import Lilac.domain.Student;

public class StudentDaoImplTest {
	StudentDao dao = new StudentDaoImpl();
	@Test
	public void testSave() {

		Student student = new Student();
		student.setUsername("ab");
		student.setPassword("123");
		student.setTelphone("1832");
		student.setEmail("112311@qq.com");
		dao.save(student);
	}

	@Test
	public void testFind() {
		String username = "a"; 
		String password = "123";
		System.out.println(dao.find(username, password));
	}

	@Test
	public void testFindStudentByUsername() {
		String username = "a";
		System.out.println(dao.findStudentByUsername(username));
	}


}
