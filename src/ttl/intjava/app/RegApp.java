package ttl.intjava.app;

import ttl.intjava.domain.Student;
import ttl.intjava.service.StudentService;

public class RegApp {

	public static void main(String[] args) {
		StudentService ss = new StudentService();
		
		Student s = ss.getStudent(2);
		
		System.out.println(s);
		
		System.out.println(ss.getAllStudent());
	}
}
