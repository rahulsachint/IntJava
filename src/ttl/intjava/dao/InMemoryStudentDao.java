package ttl.intjava.dao;

import java.util.ArrayList;
import java.util.List;

import ttl.intjava.domain.Student;

public class InMemoryStudentDao {

	private List<Student> students;
	
	public InMemoryStudentDao() {
		students = new ArrayList<>();
		Student s = new Student(1, "Joe", Student.Status.FULL_TIME);
		students.add(s);

		s = new Student(2, "Charlene", Student.Status.FULL_TIME);
		students.add(s);
	}
	
	public Student getStudent(int id) {
		for(Student s : students) {
			if(s.getId() == id) {
				return s;
			}
		}
		
		return null;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public Student  insertStudent(Student s)  {
		students.add(s);
		
		return s;
	}
	
	
}
