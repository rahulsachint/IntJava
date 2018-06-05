package ttl.intjava.test;

import org.testng.annotations.Test;
import ttl.intjava.domain.Student;
import ttl.intjava.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rmadan on 6/5/18.
 */
public class StudentServiceUnitTestNG {

    @Test
    public void learnStreamUsage() {
        StudentService ss = new StudentService();
        ss.addStudent(new Student("Rahul", Student.Status.FULL_TIME));
        ss.addStudent(new Student("Ajitesh", Student.Status.HIBERNATING));
        ss.addStudent(new Student("Kavitha", Student.Status.FULL_TIME));
        ss.addStudent(new Student("Prabhjot", Student.Status.PART_TIME));
        ss.addStudent(new Student("Praveen", Student.Status.PART_TIME));
        List<Student> students = ss.getAllStudents();
        // students.forEach(s -> System.out.println(s));
        System.out.println("=========================================");

        List<String> names = students.stream()
                .peek(s -> System.out.println("Peek 1: " + s))
                .filter(s -> s.getName().length() > 5)
                .map(s -> s.getName())
                .collect(Collectors.toList());
        System.out.println("=========================================");
        System.out.println(names);

        System.out.println("=========================================");
        Map<Student.Status, List<Student>> map = students.stream().collect(Collectors.groupingBy(s -> s.getStatus()));
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("=========================================");
        // Each id can have only one student (otherwise illegal state exception)
        Map<Integer, Student> keyMap = students.stream().collect(Collectors.toMap(s -> s.getId(), s -> s));
        keyMap.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("=========================================");

        Map<Student.Status, Long> countMap = students.stream().collect(Collectors.groupingBy(s -> s.getStatus(), Collectors.counting()));
        countMap.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("=========================================");
    }

    @Test
    public void learnCustomCollect() {
        StudentService service = new StudentService();
        List<Student> students = service.getAllStudents();

        // Debug and check out the stream usage
        students.stream().parallel()
                .filter(s -> s.getName().length() > 5)
                .collect(() -> {
                    return new ArrayList<>();
                },
                (list, nextItem) -> {
                    list.add(nextItem);
                },
                (list1, list2) -> {
                    list1.addAll(list2);
                });
    }

    @Test
    public void learnArrayStream() {
        String [] oned = {"one", "two", "three"};
        Stream<String> s = Arrays.stream(oned);

        String[][] twod = {
            {"one", "two", "three"},
            {"four", "five", "six"}
        };

        Stream<String []> stringArrayStream = Arrays.stream(twod);

//        Stream<Stream<String>> tempStream = stringArrayStream.map(arr -> Arrays.stream(arr));

//        Stream<String> strStream = stringArrayStream.flatMap(arr -> Arrays.stream(arr));

        List<String> strList = stringArrayStream
                .peek(arrToPrint -> System.out.println("Peek 1: " + arrToPrint.toString()))
                .flatMap(arr -> Arrays.stream(arr))
                .peek(strToPrint -> System.out.println("Peek 2: " + strToPrint))
                .filter(strToFilter -> strToFilter.length() > 3)
                .peek(strToPrint -> System.out.println("Peek 3: " + strToPrint))
                .collect(Collectors.toList());
        System.out.println(strList);
    }

    @Test
    public void learnIntStream() {
        int[] arr = {0, 2, 5, 10};

        IntStream.range(0, arr.length)
                .forEach(i -> {
                    arr[i] *= arr[i];
                    System.out.println(arr[i]);
                });

    }
}