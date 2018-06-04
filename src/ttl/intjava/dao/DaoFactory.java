package ttl.intjava.dao;

public class DaoFactory {

	public static BaseDAO getStudentDao() {
		//return new MysqlStudentDAO();
		return new InMemoryStudentDao();
	}
}
