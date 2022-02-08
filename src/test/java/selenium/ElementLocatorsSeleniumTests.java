package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementLocatorsSeleniumTests {
    //id,name,className,tagName,css,xpath,linkText,partialLinkText
    WebDriver driver;

    @Test
    public void searchByXpathTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[contains(@class,'gLFyf')]"));
        driver.quit();
    }
}
