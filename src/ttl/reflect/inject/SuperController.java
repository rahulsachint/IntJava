package ttl.reflect.inject;

public class SuperController {

	@MyInject
	private SuperService service;
	
	public String getInfoFor(String input) {
		return service.getInfo(input);
	}
	
}
