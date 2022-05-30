package seleniumThirdWeek4Day.Day6;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class Day6_ConfigReader {
    @Test
    public void test() {
        //Driver.getDriver().get("amazonUrl"); it was first type but cant understandt what does mean it
        //we will use configReader class's getProperty's method for read and turning to actual key's valu from file
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getClose();
    }
}
