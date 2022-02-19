package selenium;

import org.testng.annotations.Test;

public class TestNgGroupingTests {


    @Test(groups = {"smoke"})
    public void firstGoogleSearchTest() {
        System.out.println("test1");
    }

    @Test(groups = {"smoke"})
    public void secondGoogleSearchTest() {
        System.out.println("test2");
    }

    @Test(groups = {"regression","smoke"})
    public void thirdGoogleSearchTest() {
        System.out.println("test3");
    }

    @Test
    public void fourthGoogleSearchTest() {
        System.out.println("test4");
    }
}
