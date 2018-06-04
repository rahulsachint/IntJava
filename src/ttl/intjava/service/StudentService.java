package ttl.intjava.service;

import java.util.List;

import ttl.intjava.dao.InMemoryStudentDao;
import ttl.intjava.domain.Student;

public class StudentService {

	private InMemoryStudentDao dao = new InMemoryStudentDao();
	
	public Student getStudent(int id) {
		//
		Student s = dao.getStudent(id);
		
		return s;
	}

	public List<Student> getAllStudent() {
		//
		return dao.getStudents();
	}

	public Student addStudent(Student s) {
		Student ns = dao.insertStudent(s);
		return ns;
	}
	
}
