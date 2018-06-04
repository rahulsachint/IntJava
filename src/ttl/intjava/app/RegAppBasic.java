package ttl.intjava.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ttl.intjava.domain.Student;
import ttl.intjava.service.StudentService;

public class RegAppBasic {

	private int val;

	public static void main(String[] args) {
		RegAppBasic ra = new RegAppBasic();
		ra.go();
	}

	public void go() {

		StudentService ss = new StudentService();

		List<Student> students = ss.getAllStudents();

		Collections.sort(students);
		System.out.println(students);

		// Collections.sort(students, new NameComparator());
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}

		});

		Collections.sort(students, (Student s1, Student s2) -> {
				return s1.getName().compareTo(s2.getName());
			});

		Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));

		students.forEach(s -> System.out.println(s));

		students.forEach(RegAppBasic::easyPrint);
		
		doIt(new MyInterface() {
			public String fun(String s) {
				return "did " + s;
			}

		});

		doIt((s) -> "did " + s);
	}
	
	public static void easyPrint(Object o) {
		System.out.println(o);
	}
	
	interface MyInterface
	{
		public String fun(String s);
		//public String bar(String s);
	}
	
	public void doIt(MyInterface mi) {
		String s = mi.fun("xyz");
		
		System.out.println("s is " + s);
	}
	
	public class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}

	}
	
}
