package Lilac.service.impl;

import Lilac.dao.StudentDao;
import Lilac.dao.impl.StudentDaoImpl;
import Lilac.domain.Student;
import Lilac.exception.UsernameExistException;
import Lilac.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao = new StudentDaoImpl();
	@Override
	public Student login(String username, String password) {
		 return dao.find(username, password);
	}

	@Override
	public void register(Student student) throws UsernameExistException {
		if(student ==null)
			throw new IllegalArgumentException("保存的数据不能为空");
		boolean b = dao.findStudentByUsername(student.getUsername());
		if(b)
			throw new UsernameExistException("用户名"+student.getUsername()+"已经存在");
		dao.save(student);
	}

}
