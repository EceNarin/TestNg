package seleniumThirdWeek4Day.Day6;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class amazonTest extends TestBaseRapor {
    @Test
    public void testName() {
        extentTest=extentReports.createTest("get amazon","verify log-in log-out");
        extentTest.info("in amazon");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getClose();

    }

    @Test
    public void testName1() {
        extentTest=extentReports.createTest("get amazon","verify log-in log-out");
        extentTest.info("in google");
        Driver.getDriver().get("https://www.facebook.com");
        Driver.getClose();
    }
}
