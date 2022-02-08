package pagespom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
    WebDriver driver;

    By textBoxSearch = By.name("q");
    By textBoxAcceptButton = By.name("btnK");

    public GoogleSearchPageObjects (WebDriver driver) {
        this.driver = driver;
    }

    public void setTextInSearchBox (String searchText) {
        driver.findElement(textBoxSearch).sendKeys(searchText);
    }

    public void clickEnter () {
        driver.findElement(textBoxSearch).sendKeys(Keys.ENTER);
    }

    public void clickAcceptSearchButton () {
        driver.findElement(textBoxAcceptButton).click();
    }

}
