package ttl.advjava.collections.streams.jdk8.cc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import java.util.Arrays;

public class CustStatsApp {

	public static void main(String[] args) throws IOException {
		List<Data> data = Arrays.asList(
				new Data(0,10),
				new Data(4,20),
				new Data(6,80),
				new Data(2,10)
		);
		
		CustomStatistics result = data.stream()
				.collect(() -> {
					//Supplier
					return new CustomStatistics();
				},
				(cs, d) -> {
					//Accumulator
					cs.accumulate(d);
				}, 
				(cs1, cs2) -> { 
					//Combiner
					cs1.combine(cs2);	
				});

		CustomStatistics result2 = data.stream()
				.collect(() -> new CustomStatistics(), 
						(cs, d) -> cs.accumulate(d), 
						(cs1, cs2) -> cs1.combine(cs2));

		CustomStatistics result3 = data.stream()
				.collect(CustomStatistics::new,
						CustomStatistics::accumulate,
						CustomStatistics::combine);

		//Simpler way
		result = data.stream()
				.parallel()
				.collect(CustomStatistics::new,
						CustomStatistics::accumulate,
						CustomStatistics::combine);
		
		
		System.out.println("result = " + result);
		
	}
}
