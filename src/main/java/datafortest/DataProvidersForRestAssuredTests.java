package datafortest;

import org.testng.annotations.DataProvider;

public class DataProvidersForRestAssuredTests {
    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost() {
        return new Object[][] {
                {"Peter","AQA"},
                {"Nadja","QA"}};
    }
}
