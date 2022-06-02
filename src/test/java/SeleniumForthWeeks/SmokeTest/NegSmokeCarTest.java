package SeleniumForthWeeks.SmokeTest;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;

public class NegSmokeCarTest {
    @Test
    public void test() {
        // go to bluerental.com
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        BlueCar car=new BlueCar();
        //click to login button
        car.login.click();
        //wrong usermail and password then click to login
        car.userMail.sendKeys(ConfigReader.getProperty("brcWMail"));
        car.password.sendKeys(ConfigReader.getProperty("brcWPass"));
        car.submit.click();
        //test to if u error login to page as user
        Assert.assertTrue(car.login.isDisplayed());
        Driver.getClose();

    }
}
