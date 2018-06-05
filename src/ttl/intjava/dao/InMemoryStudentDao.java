package ttl.intjava.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ttl.intjava.domain.Student;
import ttl.intjava.domain.Student.StudentBuilder;
import ttl.intjava.utils.IdGen;

public class InMemoryStudentDao implements BaseDAO {

	
	public InMemoryStudentDao() {
		students = new ArrayList<>();
		Student s = new Student("Joe", Student.Status.FULL_TIME);
		insertStudent(s);

		s = new Student("Manoj", Student.Status.FULL_TIME);
		insertStudent(s);

		s = new Student("Charlene", Student.Status.FULL_TIME);
		insertStudent(s);

		s = new Student("Rajesh", Student.Status.FULL_TIME);
		insertStudent(s);

		s = new Student("Ana", Student.Status.FULL_TIME);
		insertStudent(s);
	}
	
	@Override
	public Student getStudent(int id) {
		for(Student s : students) {
			if(s.getId() == id) {
				return s;
			}
		}
		
		return null;
	}

	private List<Student> students;

	@Override
	public List<Student> getStudents() {
		return new ArrayList<Student>(students);
	}
	
	@Override
	public Student  insertStudent(Student s)  {
		int id = IdGen.getNextStudentId();
		//Student tmp = new Student(id, s.getName(), s.getStatus());

		Student tmp = new StudentBuilder().id(id).name(s.getName()).status(s.getStatus()).build();

		//s.setId(1000000000);
		students.add(tmp);
		
		return tmp;
	}
	
	
}
