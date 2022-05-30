package seleniumThirdWeek4Day.Day5.tests;

import org.testng.annotations.Test;
import utilities.Driver;

public class test1 {
    @Test
    public void testName() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getClose();

    }

    @Test
    public void testName1() {
        Driver.getDriver().get("https://www.facebook.com");
        Driver.getClose();
    }
}
