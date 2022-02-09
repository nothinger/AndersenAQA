package selenium.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pagespom.GoogleSearchPage;

public class ExtentReportBasicTest {

    private static WebDriver driver;
    private static ExtentReports extent;

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public synchronized void afterMethod() {
        driver.quit();
        extent.flush();
    }

    @Test
   public static void Report () {
        ExtentTest testDemo = extent.createTest("MyFirstTest", "Sample description");
       driver = new ChromeDriver();
       driver.get("https://www.google.com/");
        testDemo.pass("Navigated to google.com");
       GoogleSearchPage.textBoxSearch(driver).sendKeys("I'm the best AQA");
        testDemo.pass("Entered text into google.com");
       GoogleSearchPage.textBoxSearch(driver).sendKeys(Keys.RETURN);
        testDemo.pass("Press ENTER into google.com");
        testDemo.info("Test Completed");
   }
}
