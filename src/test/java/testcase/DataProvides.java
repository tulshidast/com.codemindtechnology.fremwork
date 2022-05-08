package testcase;

import org.testng.annotations.*;

public class DataProvides {

	@DataProvider(name = "user-password")
	public Object[][] dataProvider() {

		Object array[][] = { { "test1", "test1" }, { "test2", "test2" }, { "test3", "test3" } };
		return array;

		// return new Object[][] { { "test1", "test1" }, { "test2", "test2" }, {
		// "test3", "test3" } };
	}
}
