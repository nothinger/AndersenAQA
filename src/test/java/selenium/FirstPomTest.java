package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagespom.GoogleSearchPage;

public class FirstPomTest {
    WebDriver driver;

    @BeforeTest
    public void InitializeBrowser () {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstGoogleSearchTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        GoogleSearchPage.textBoxSearch(driver).sendKeys("I'm the best AQA");
        GoogleSearchPage.textBoxSearch(driver).sendKeys(Keys.RETURN);
        driver.quit();
    }
}
