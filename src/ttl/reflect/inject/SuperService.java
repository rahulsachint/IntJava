package ttl.reflect.inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperService {
	
	public String getInfo(String input) {
		List<String> chars = Arrays.asList(input.split(""));
		Collections.shuffle(chars);

		String result = "";
		for(String s : chars) {
			result += s;
		}
		return result;
	}
}
