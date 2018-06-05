package ttl.intjava.service;

import java.util.List;

import ttl.intjava.dao.BaseDAO;
import ttl.intjava.dao.DaoFactory;
import ttl.intjava.domain.Student;

public class StudentService {

	//private BaseDAO dao = new InMemoryStudentDao();
	private BaseDAO dao = DaoFactory.getStudentDao();
	
	public Student getStudent(int id) {
		Student s = dao.getStudent(id);
		
		return s;
	}

	public List<Student> getAllStudents() {
		return dao.getStudents();
	}

	public Student addStudent(Student s) {
		Student ns = dao.insertStudent(s);
		return ns;
	}
	
}
