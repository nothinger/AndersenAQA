package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTestSeleniumTests {
    WebDriver driver;

    @BeforeTest
    public void initDriver() {
    System.setProperty("webdriver.chrome.driver","C:/Users/Wazzup/Downloads/ChromeDriver/chromedriver.exe");
}
   @Test
   public void firstTest () {
       WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.by/");
        driver.quit();
   }


}
