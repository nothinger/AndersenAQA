package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DesireCapabilitiesDemoTest {
    WebDriver driver;

    @BeforeTest
    public void InitializeBrowser () {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstGoogleSearchTest() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("ignoreProtectedModeSettings","true");
        caps.setBrowserName("Chrome");
        caps.setPlatform(Platform.MAC);

        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("I'm best AQA");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.quit();
    }
}
