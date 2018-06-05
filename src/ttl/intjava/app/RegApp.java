package ttl.intjava.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ttl.intjava.domain.Student;
import ttl.intjava.domain.Student.Status;
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
		
		List<Student> name = students.stream().parallel()
				.filter(s -> s.getName().length() > 5)
				.collect(() -> {
					return new ArrayList<>();
				}, 
				(list, nextItem) ->  {
					list.add(nextItem);
				},
				(list1, list2) -> { 
					list1.addAll(list2);	
				});
		
		name.forEach(System.out::println);
	}
	public void go2() {

		StudentService ss = new StudentService();

		List<Student> students = ss.getAllStudents();
		
		//List<String> names = getNames(students, (s) -> s.getName());
		
		/*
		List<String> name = students.stream()
				.peek(s -> System.out.println("Peek 1 " + s))
				.filter(s -> s.getName().length() > 5)
				.peek(s -> System.out.println("Peek 2 " + s))
				.map(s -> s.getName())
				.peek(s -> System.out.println("Peek 3 " + s))
				.collect(Collectors.toList());
		*/
		
		Map<Integer, Student> map = students.stream()
			.collect(Collectors.toMap(s -> s.getId(), s -> s));

		Map<Status, List<Student>> map2 = students.stream()
			.collect(Collectors.groupingBy(s -> s.getStatus()));
		
		Map<Status, Long> map3 = students.stream()
			.collect(Collectors.groupingBy(s -> s.getStatus(), Collectors.counting()));

		map.forEach((k, v) -> System.out.println(k + ":" + v));
		
		List<Integer> ids = getProperties(students, (s) -> s.getId());
		
		
		
		//names.forEach(System.out::println);
		//ids.forEach(System.out::println);
	}
	
	public interface Checker<T>
	{
		public boolean test(T s);
	}
	public interface Extract<T, R> {
		public R getProp(T s);
	}

	public <T, R> List<R> getProperties(List<T> list, Function<T, R> ex) {
		List<R> result = new ArrayList<>();
		
		for(T s : list) {
			result.add(ex.apply(s));
		}
		
		return result;
	}

	public <T, R> List<R> getNames(List<T> list, Extract<T, R> ex) {
		List<R> result = new ArrayList<>();
		
		for(T s : list) {
			result.add(ex.getProp(s));
		}
		
		return result;
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
