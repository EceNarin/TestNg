package seleniumThirdWeek4Day.Day6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class HotelMolyNegativeTest extends TestBaseRapor {
    @Test
    public void NegativeLoginTest() {
        extentTest=extentReports.createTest("negative test","login to hotelmycamp");
        HotelMoly hotelMoly=new HotelMoly();
        // https://www.hotelmycamp.com/ adresine git
        extentTest.info("get hotel moly ");
        Driver.getDriver().get(ConfigReader.getProperty("hotelMolyUrl"));
        // login butonuna bas
        extentTest.info("click for login button fot get to page");
        hotelMoly.logIn.click();
        // test data username: manager1 ,
        extentTest.info("input unvalid name");
        hotelMoly.username.sendKeys("manager1");
        // test data password : manager1!
        extentTest.info("input unvalid mail");
        hotelMoly.password.sendKeys("manager1!");
        extentTest.info("click submit button");
        hotelMoly.submit.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        extentTest.pass("wont be pass");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText().contains("Try again please"));
        Driver.getClose();
    }
}
