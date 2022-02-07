package parser;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ParserVideoCards {

    @Test
    public void parserVideo () throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","C:/Users/Wazzup/Downloads/ChromeDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://tsifra.by/catalog/kompyutery-i-seti/kompyutery-i-komplektuyushchie/videokarty/");
        driver.findElement(By.xpath("//select[@id='input-limit']")).click();
        driver.findElement(By.xpath("//option[text()='100']")).click();
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1090)", "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Map<String, String> map = new HashMap<String, String>();
        for (int i=1; i<100; i++) {
            String xpathName = "//div[contains(@class,'product-layout')]["+i+"]//div[@class='caption']/a";
            WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathName)));
            String xpathPrice = "//div[contains(@class,'product-layout')]["+i+"]//div[@class='caption']//p[@class='price']";
          String name = driver.findElement(By.xpath(xpathName)).getText();
          String price = driver.findElement(By.xpath(xpathPrice)).getText();
            JSONObject request = new JSONObject(map);
            request.put("name", name);
            request.put("price", price);
            FileWriter writer = new FileWriter("notes3.txt", true);
            writer.write(request.toJSONString());
            System.out.println(request.toJSONString());
        }
        /*for(Map.Entry<String, String> entry: map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Модель: " + key + " || " + "Цена: " + value);
        } */
        driver.quit();
        }
    }
