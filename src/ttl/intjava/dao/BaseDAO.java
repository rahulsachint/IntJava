package ttl.intjava.dao;

import java.util.List;

import ttl.intjava.domain.Student;

public interface BaseDAO {

	Student getStudent(int id);

	List<Student> getStudents();

	Student insertStudent(Student s);

}