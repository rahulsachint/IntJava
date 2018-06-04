package ttl.intjava.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ttl.intjava.domain.Student;
import ttl.intjava.service.StudentService;

public class RegApp {

	private int val;

	public static void main(String[] args) {
		RegApp ra = new RegApp();
		ra.go();
	}

	public void go() {

		StudentService ss = new StudentService();

		List<Student> students = ss.getAllStudents();

		Collections.sort(students);
		System.out.println(students);

		Collections.sort(students, new NameComparator());

		students.forEach(s -> System.out.println(s));
	}

	public class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}

	}
}
