package ttl.intjava.dao;

import java.util.ArrayList;
import java.util.List;

import ttl.intjava.domain.Student;
import ttl.intjava.domain.Student.StudentBuilder;
import ttl.intjava.utils.IdGen;

public class MysqlStudentDAO implements BaseDAO {

	private List<Student> students;
	
	public MysqlStudentDAO() {
		students = new ArrayList<>();
		Student s = new Student("JoeFromDB", Student.Status.FULL_TIME);
		insertStudent(s);

		s = new Student("CharleneFromDB", Student.Status.FULL_TIME);
		insertStudent(s);
	}
	
	/* (non-Javadoc)
	 * @see ttl.intjava.dao.BaseDAO#getStudent(int)
	 */
	@Override
	public Student getStudent(int id) {
		for(Student s : students) {
			if(s.getId() == id) {
				return s;
			}
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see ttl.intjava.dao.BaseDAO#getStudents()
	 */
	@Override
	public List<Student> getStudents() {
		return students;
	}
	
	/* (non-Javadoc)
	 * @see ttl.intjava.dao.BaseDAO#insertStudent(ttl.intjava.domain.Student)
	 */
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
