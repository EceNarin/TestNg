package seleniumThirdWeek4Day.Day5.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.Driver;
import utilities.TestBaseRapor;

public class HotelTest extends TestBaseRapor {
    @Test
    public void test()  {
        extentTest=extentReports.createTest("posiviveTest","login with valid info");

        HotelMoly hotelMoly=new HotelMoly();
        //https://www.hotelmycamp.com/ adresine git login butonuna bas
        extentTest.info("get to hotelmolypage");
        Driver.getDriver().get("https://www.hotelmycamp.com/ ");
        extentTest.info("cliclk to login button");
        hotelMoly.logIn.click();
        //test data username: manager
        extentTest.info("input valid username");
        hotelMoly.username.sendKeys("manager");
        //test data password : Manager1!
        extentTest.info("input valid password");
        hotelMoly.password.sendKeys("Manager1!");
        extentTest.info("submit click button");
        hotelMoly.submit.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        extentTest.pass("test expected pass");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tbody//tr//td[2]")).getText().equals("manager"));
        Driver.getClose();

    }
}
