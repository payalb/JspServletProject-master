package dbUtility;

import org.junit.Test;

import com.exception.DatabaseException;

public class PropertyReaderTest {
	//Negative testing
	@Test(expected=DatabaseException.class)
	public void testFailPropertyFileNotFound() throws DatabaseException{
		PropertyReader.PROPERTY_FILE="abc.properties";
		PropertyReader.readPropertyFile();
	}
	//Positive testing
	@Test
	public void testSuccessPropertyFileFound() throws DatabaseException {
		PropertyReader.PROPERTY_FILE="/db_test.properties";
		PropertyReader.readPropertyFile();
	}
}
