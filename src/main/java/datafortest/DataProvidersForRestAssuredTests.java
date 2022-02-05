package datafortest;

import org.testng.annotations.DataProvider;
import utils.ExelUtils;

import java.io.IOException;

public class DataProvidersForRestAssuredTests {
    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost() {
        return new Object[][]{
                {"Peter", "AQA"},
                {"Nadja", "QA"}};
    }

    @DataProvider(name = "dataForPostExel")
    public Object[][] dataForPostFromExel() throws IOException {
        ExelUtils data = new ExelUtils("./src/main/resources/schemesfortests/ExelTest.xlsx", "Sheet1");
        String name1 = (String) data.getData(1, 0);
        String name2 = (String) data.getData(2, 0);
        String job1 = (String) data.getData(1, 1);
        String job2 = (String) data.getData(2, 1);
        return new Object[][]{
                {name1, job1},
                {name2, job2}};
    }
}
