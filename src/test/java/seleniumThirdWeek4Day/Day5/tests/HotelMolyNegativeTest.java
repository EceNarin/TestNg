package seleniumThirdWeek4Day.Day5.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.Driver;

public class HotelMolyNegativeTest {
    @Test
    public void NegativeLoginTest() {
        HotelMoly hotelMoly=new HotelMoly();
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        // login butonuna bas
        hotelMoly.logIn.click();
        // test data username: manager1 ,
        hotelMoly.username.sendKeys("manager1");
        // test data password : manager1!
        hotelMoly.password.sendKeys("manager1!");
        hotelMoly.submit.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText().contains("Try again please"));
        Driver.getClose();
    }
}
