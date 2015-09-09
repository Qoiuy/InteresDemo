package Lilac.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Lilac.domain.Student;
import Lilac.exception.UsernameExistException;
import Lilac.service.StudentService;
import Lilac.service.impl.StudentServiceImpl;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	private Student student = new Student();
	StudentService service = new StudentServiceImpl();
	
	public String save(){
			return SUCCESS;
	}
	public String update(){
		return SUCCESS;
	}
	
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		return SUCCESS;
	}

	public String register(){
		try {
			service.register(student);
			return SUCCESS;
		} catch (UsernameExistException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String login(){
		Student s = service.login(student.getUsername(), student.getPassword());
		if(s == null){
			return LOGIN;
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", s);
		return SUCCESS;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public Student getModel() {
		return student;
	}
	
}
