package testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;
import org.testng.annotations.Test;

public class LogginDemo {

	static Logger log = LogManager.getLogger(LogginDemo.class);

	@Test
	public void main() {
		log.debug("This is example of logging");
	}

}
