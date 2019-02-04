package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bean.User;
import com.exception.DatabaseException;

public class UserDaoTest {

	static UserDao obj= new UserDao();
	@Test
	public void m1() throws DatabaseException {
		User user= new User("admin","admin","administrator");
		assertEquals(1,obj.insertUser(user));
	}
}
