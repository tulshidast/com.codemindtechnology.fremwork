package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static String getProperty(String key) {
		String keyValue = null;
		try {
			File file = new File(
					"C:\\Users\\Administrator\\classworkspace\\com.codemind.testing\\com.codemindtechnology.fremwork\\src\\test\\java\\resources\\test.properties");
			FileInputStream fiStream = new FileInputStream(file);

			Properties properties = new Properties();
			properties.load(fiStream);
			keyValue = (String) properties.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyValue;

		// return (String) properties.get(key);

	}

}
