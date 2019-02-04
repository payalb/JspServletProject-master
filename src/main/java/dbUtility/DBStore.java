package dbUtility;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.exception.DatabaseException;
import com.mysql.cj.util.StringUtils;

public class DBStore {
	static Properties property;
	
	  public static BasicDataSource getDataSource() throws DatabaseException {
		property= getProperty();
		BasicDataSource ds = new BasicDataSource();
		if(property== null || StringUtils.isEmptyOrWhitespaceOnly(
				property.getProperty("DB_Driver"))||StringUtils.isEmptyOrWhitespaceOnly(property.getProperty("DB_URL"))
				|| StringUtils.isEmptyOrWhitespaceOnly(property.getProperty("DB_Password"))||
				StringUtils.isEmptyOrWhitespaceOnly(property.getProperty("DB_User"))) {
			throw new DatabaseException("DB Properties not found");
		}
		ds.setDriverClassName(property.getProperty("DB_Driver"));
		ds.setUrl(property.getProperty("DB_URL"));
		ds.setPassword(property.getProperty("DB_Password"));
		ds.setUsername(property.getProperty("DB_User"));
		ds.setMaxTotal(200);// load testing get connection :(2sec) close the connection
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(180);
		ds.setMinIdle(20);
		ds.setMaxWaitMillis(2000);// 2sec
		ds.setDefaultAutoCommit(false);
		return ds;
	}

	public static Properties getProperty() {
		return property;
	}

	static {
		try {
			property=PropertyReader.readPropertyFile();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}


	
}
