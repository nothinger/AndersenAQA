package selenium.extentreport;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class Log4JDemoTest {
    Logger logger = LogManager.getLogger(Log4JDemoTest.class);

    @Test
    public void Test () {
        System.out.println("Hello world");
        logger.info("Info message");
        logger.warn("Want message");
        logger.fatal("Fatal error");
    }
}
