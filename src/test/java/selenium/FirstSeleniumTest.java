package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeTest
    public void InitializeBrowser () {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstGoogleSearchTest() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("I'm best AQA");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.quit();
    }
}
