package ttl.wc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

	public static void main(String[] args) throws IOException {

		// Stream<String> ss = Files.lines(Paths.get("PrideAndPrejudice.txt"));
		WordCounter wc = new WordCounter();
		wc.foo();
	}

	public void go3() {

		Comparator<String> c = createComparator(10);

		c.compare("abc", "def");

		c = createComparator(10);

		c = createComparator(35);
		int result = c.compare("abc", "def");
		
		System.out.println(result);
	}

	public void fileDemo(List<String> fNames) throws IOException {
		for (String name : fNames) {
			FileInputStream fis = new FileInputStream(name);
			int i = fis.read();
			// ...
		}

		fNames.forEach(name -> {
			try {
				FileInputStream fis = new FileInputStream(name);
				int i = fis.read();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		});

	}

	public void otherFun(int value) {
		int x;
	}

	public Comparator<String> createComparator(int value) {
		int x = value * value;
		Comparator<String> comp = (s1, s2) -> {

			System.out.println("value is " + value);
			if (s1.length() > value + x) {
				return 0;
			}
			return -1;
		};

		return comp;
	}

	public void go() throws IOException {

		// Map<String, Long> counts = fun();
		// counts.forEach((k, v) -> System.out.println(k + ":" + v));

		Map<String, Long> counts2 = funStream2();
		counts2.forEach((k, v) -> System.out.println(k + ":" + v));
	}

	public Map<String, Long> funStream2() throws IOException {

		Map<String, Long> yyy = Files.lines(Paths.get("PrideAndPrejudice.txt")).map(s -> s.split("\\W"))
				.flatMap(sa -> Arrays.stream(sa)).collect(Collectors.groupingBy(s -> s,
						// () -> new TreeMap<>(),
						TreeMap::new, Collectors.counting()));

		Comparator<String> cs = (k1, k2) -> {
			long v1 = yyy.get(k1);
			long v2 = yyy.get(k2);

			int ret = (int) (v1 - v2);
			if (ret == 0) {
				ret = k1.compareTo(k2);
			}
			return ret;
		};

		Comparator<String> cs2 = (k1, k2) -> {
			int ret = k1.length() - k2.length();
			return ret;
		};

		Map<String, Long> byValue = new TreeMap<>(cs);
		byValue.putAll(yyy);

		return byValue;

	}
	
	public Map<String, Long> funStream() throws IOException {

		Stream<String> ss = Files.lines(Paths.get("PrideAndPrejudice.txt"));

		Stream<String[]> sarrs = ss.map(s -> s.split("\\W"));

		Stream<String> xxx = sarrs.flatMap(sa -> Arrays.stream(sa));

		Map<String, Long> yyy = xxx.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		return yyy;

	}

	public Map<String, Long> fun() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("PrideAndPrejudice.txt"));

		Map<String, Long> counts = new HashMap<>();

		for (String line : lines) {
			String words[] = line.split("\\W");

			for (String word : words) {
				Long count = counts.get(word);
				if (count == null) {
					count = new Long(0);
				}

				count++;

				counts.put(word, count);
			}
		}

		return counts;
	}

	
	public void foo() {
		String [][] sarr = {
				{"one", "tow" ,"three" },
				{"foour", "five" ,"siz" },
		};
		
		Stream<String[]> s1 = Arrays.stream(sarr);

		s1.peek(s -> System.out.println("Peek1 " + s.getClass() + ", " + s))

		.flatMap(sa -> Arrays.stream(sa))
		//.map(sa -> Arrays.stream(sa))

		.peek(s2 -> System.out.println("Peek2 " + s2.getClass() + ", " + s2))

		.forEach(System.out::println);
	}
}
