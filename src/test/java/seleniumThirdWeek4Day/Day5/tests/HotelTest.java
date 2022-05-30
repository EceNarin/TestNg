package seleniumThirdWeek4Day.Day5.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.Driver;

public class HotelTest {
    @Test
    public void test() {
        HotelMoly hotelMoly=new HotelMoly();
        //https://www.hotelmycamp.com/ adresine git login butonuna bas
        Driver.getDriver().get("https://www.hotelmycamp.com/ ");
        hotelMoly.logIn.click();
        //test data username: manager ,
        hotelMoly.username.sendKeys("manager");
        //test data password : Manager1!
        hotelMoly.password.sendKeys("Manager1!");
        hotelMoly.submit.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//tbody//tr//td[2]")).getText().equals("manager"));
        Driver.getClose();

    }
}
