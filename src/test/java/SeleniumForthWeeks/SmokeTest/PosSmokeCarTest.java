package SeleniumForthWeeks.SmokeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PosSmokeCarTest  extends TestBaseRapor {

    @Test
    public void testName() throws InterruptedException {
     extentTest=extentReports.createTest("pozitif login","Vslid UserName");
        // go to bluerental.com
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //click to login button
        BlueCar bb=new BlueCar();
        extentTest.info("click to login");
        bb.login.click();
        //usermail and password then click to login
        Thread.sleep(1500);
        extentTest.info("entering username");
        bb.userMail.sendKeys(ConfigReader.getProperty("brcMail"));
        extentTest.info("entering password");
        bb.password.sendKeys(ConfigReader.getProperty("brcPass"));
        extentTest.info("click for submit ");
        bb.submit.click();
        //test to if u successfully login to page as user
        extentTest.pass("all steps are passed");
        Assert.assertTrue(bb.succesLogin.isDisplayed());
    }
}
