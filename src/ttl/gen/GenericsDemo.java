package ttl.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericsDemo {

	public static void main(String[] args) {
		GenericsDemo gd = new GenericsDemo();
		gd.go();
	}
	
	public void go() {
		List<Number> ln = new ArrayList<>();
		
		ln.add(10);
		ln.add(22.5);
		ln.add(15);
		
		double d = sum(ln);
		System.out.println("sum is " + d);

		List<Integer> li = new ArrayList<>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(50);
		
		Integer [] iarr = {0, 4, 10};
		
		sum(li);
		
		addToList(li, iarr);
		
		addToList(ln, iarr);
		
		Map<String, Number> r = null;
		Map<String, Long> rr = null;
		setData(rr);
		
	}

	
	public double sum(List<? extends Number> ln) {
		double sum = 0;
		for(Number n : ln) {
			sum += n.doubleValue();
		}
		
		return sum;
	}
	
	public <T> void addToList(List<? super T> li, T [] arr) {
		for(T i : arr) {
			li.add(i);
		}
	}
	
	

	//library
	public void setData(Map<String, ? extends Number> data) {
		
	}
}
