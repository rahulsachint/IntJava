package ttl.intjava.utils;

public class IdGen {

	private static int nextStudentId = 0;
	
	public static int getNextStudentId() {
		return nextStudentId++;
	}
	
}
