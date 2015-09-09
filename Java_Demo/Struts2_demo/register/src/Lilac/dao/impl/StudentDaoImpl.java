package Lilac.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Lilac.dao.StudentDao;
import Lilac.utils.C3o0Utils;
import Lilac.domain.Student;

public class StudentDaoImpl  extends JdbcDaoSupport implements StudentDao {
	QueryRunner runner = new QueryRunner(C3o0Utils.getDataSource());
	@Override
	public Student find(String username, String password) {
			return query("select * from students where username=? and password=?", new BeanHandler<Student>(Student.class), username, password);
	}

	@Override
	public boolean findStudentByUsername(String username) {
			Student s = query("select * from students where username=?",new BeanHandler<Student>(Student.class), username);
			return s == null ? false :true;
	}

	@Override
	public void save(Student student) {
		Object[] o = {student.getUsername(), student.getPassword(), student.getEmail(), student.getTelphone()};
		update("insert into students(username, password, email, telphone) values(?, ?, ?, ?)", o);
		
	}

}
