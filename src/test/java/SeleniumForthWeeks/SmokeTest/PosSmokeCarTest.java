package SeleniumForthWeeks.SmokeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;

public class PosSmokeCarTest {
    @Test
    public void testName() throws InterruptedException {

        // go to bluerental.com
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //click to login button
        BlueCar bb=new BlueCar();
        bb.login.click();
        //usermail and password then click to login
        Thread.sleep(1500);
        bb.userMail.sendKeys(ConfigReader.getProperty("brcMail"));
        bb.password.sendKeys(ConfigReader.getProperty("brcPass"));
        bb.submit.click();
        //test to if u successfully login to page as user
        Assert.assertTrue(bb.succesLogin.isDisplayed());
    }
}
