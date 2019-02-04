package dbUtility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.junit.Test;

import com.exception.DatabaseException;

public class DBStoreTest {

	@Test(expected=DatabaseException.class)
	public void testGetDataSourcePropertyEmpty() throws DatabaseException, SQLException {
		DBStore.property= new Properties();
		DBStore.getDataSource();
		
	}

	@Test(expected=DatabaseException.class)
	public void testGetDataSourcePropertyNull() throws DatabaseException, SQLException {
		DBStore.property= null;
		DBStore.getDataSource();
		
	}
	
	@Test
	public void testDsPrpertyFileValid() throws DatabaseException, SQLException {
		DBStore.property= PropertyReader.readPropertyFile();
		BasicDataSource ds=DBStore.getDataSource();
		/*if(ds.getConnection()==null) {
			throw new AssertionError
		}*/
		assertNotNull("Datasource should not be null",ds);
		assertNotNull(ds.getConnection());
		assertEquals(200,ds.getMaxTotal());
		assertFalse(ds.getEnableAutoCommitOnReturn());
		
	}
	
	
}
