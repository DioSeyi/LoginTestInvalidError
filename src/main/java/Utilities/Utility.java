package Utilities;

import java.util.Properties;
import java.io.FileInputStream;

public class Utility {

	public String dataFetcher(String key) throws Exception {
		String location = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(location+"\\src\\main\\resources\\propertyFile\\dataSaver.properties");
		Properties reader = new Properties();
		reader.load(file);
		String value = (String) reader.getProperty(key);
		return value;
	}
}
	