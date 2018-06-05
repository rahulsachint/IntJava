package ttl.intjava.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import ttl.intjava.domain.Student;
import ttl.intjava.domain.Student.Status;
import ttl.intjava.service.StudentService;

public class RegAppPredicate {

	private int val;

	public static void main(String[] args) {
		RegAppPredicate ra = new RegAppPredicate();
		ra.go();
	}

	public void go() {

		StudentService ss = new StudentService();

		List<Student> students = ss.getAllStudents();
		
		List<Student> withM = findWithFirstName(students, "M");
		Checker<Student> cfnm = new FirstNameChecker("M");
		
		//withM = findWithChecker(students, cfnm);

		withM = findWithChecker(students, (s) -> s.getName().startsWith("M"));
		
		List<String> sList = Arrays.asList("One", "two", "Three" );
		
		List<String> result = findWithChecker(sList, (s) -> s.length() > 3);
		
		System.out.println("> 3" + result);
		
		
		withM = findWithChecker(students, (s) -> s.getStatus() == Status.FULL_TIME);
		
		withM.forEach(System.out::println);
		
		System.out.println("****************");
		
		List<Student> withS = findWithStatus(students, Status.FULL_TIME);
		withS.forEach(System.out::println);
		
	}
	
	public <T> List<T> findWithChecker(List<T> list, Predicate<T> checker) {
		List<T> result = new ArrayList<>();
		
		for(T s : list) {
			if(checker.test(s)) {
				result.add(s);
			}
		}
		
		return result;
	}
	
	
	public List<Student> findWithFirstName(List<Student> list, String start) {
		List<Student> result = new ArrayList<>();
		
		for(Student s : list) {
			if(s.getName().startsWith(start)) {
				result.add(s);
			}
		}
		
		return result;
	}

	public List<Student> findWithStatus(List<Student> list, Status start) {
		List<Student> result = new ArrayList<>();
		
		for(Student s : list) {
			if(s.getStatus() == start) {
				result.add(s);
			}
		}
		
		return result;
	}
	
	public interface Checker<T>
	{
		public boolean test(T s);
	}
	
	class FirstNameChecker implements Checker<Student>
	{

		private String testString;
		public FirstNameChecker(String testString) {
			this.testString = testString;
		}
		@Override
		public boolean test(Student s) {
			return s.getName().startsWith(testString);
		}
		
	}
}
