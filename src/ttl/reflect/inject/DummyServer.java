package ttl.reflect.inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DummyServer {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
		
		new DummyServer().start();
	}
	
	SuperController sController;
	public DummyServer() throws InstantiationException, IllegalAccessException {
		sController = BeanFactory.getBean(SuperController.class);
	}
	
	
	
	public void start() throws IOException {
		try (InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr)) { 
			String line = "";
			while(true) {
				System.out.print("Enter input -> ");
				line = br.readLine(); 
				if(line == null) { 
					break;
				}

				String inputFromWeb = line;
				String info = sController.getInfoFor(inputFromWeb);
		
				System.out.printf("Info for %s:%s%n", inputFromWeb, info);
			}
		}
	}
}
