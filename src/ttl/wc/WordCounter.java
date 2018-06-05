package ttl.wc;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class WordCounter {

	public static void main(String[] args) throws IOException {
		
		int [] arr = {0, 2, 5, 10 };
		
		IntStream.range(0, arr.length)
			.forEach(i -> {arr[i] *= arr[i]; System.out.println(arr[i]);});
		
		
		IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10000))
			.skip(10)
			.limit(100)
			.forEach(System.out::println);
			
	}

}
