package dbUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.exception.DatabaseException;

public class PropertyReader {

	public static String PROPERTY_FILE = "/db.properties";

	public static Properties readPropertyFile() throws DatabaseException {
		Properties p = new Properties();
		try {
			InputStream is = PropertyReader.class.getResourceAsStream(PROPERTY_FILE);
			if (is != null) {
				p.load(is);
			}
		} catch (IOException e) {
			throw new DatabaseException("Unable to load database details !!");
		}
		return p;
	}

}
