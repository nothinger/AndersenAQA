package parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static utils.ExelUtils.sheet;

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

        Date date = new Date();
        Format formatter = new SimpleDateFormat("YYYY-MM-dd_hh-mm-ss");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet " + formatter.format(date));

        Map<Integer, Object[]> map = new HashMap<Integer, Object[]>();
        for (int i=1; i<100; i++) {
            String xpathName = "//div[contains(@class,'product-layout')]["+i+"]//div[@class='caption']/a";
            WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathName)));
            String xpathPrice = "//div[contains(@class,'product-layout')]["+i+"]//div[@class='caption']//p[@class='price']";
          String name = driver.findElement(By.xpath(xpathName)).getText();
          String price = driver.findElement(By.xpath(xpathPrice)).getText();
            map.put(i,new Object[] {name,price});
        }

        Set<Integer> keyset = map.keySet();
        int rownum = 0;
        for (Integer key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = map.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
            FileOutputStream out = new FileOutputStream(new File("src/main/java/utils/exelmethods/test.xlsx"));
            workbook.write(out);
        driver.quit();
        }
    }
