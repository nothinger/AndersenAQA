package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagespom.GoogleSearchPage;
import pagespom.GoogleSearchPageObjects;

public class GoogleSearchPagePomObjectsTest {
    WebDriver driver;

    @BeforeTest
    public void InitializeBrowser () {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstGoogleSearchTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        GoogleSearchPageObjects searchPageObjects = new GoogleSearchPageObjects(driver);
        searchPageObjects.setTextInSearchBox("I'm happy baby");
        searchPageObjects.clickEnter();
        driver.quit();
    }
}
