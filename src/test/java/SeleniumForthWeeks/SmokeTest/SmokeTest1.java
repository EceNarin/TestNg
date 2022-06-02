package SeleniumForthWeeks.SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueCar;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;

public class SmokeTest1 {
    //Smoke Test

    @Test
    public void positiveLoginTest() {
        HotelMoly moly=new HotelMoly();

        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMolyUrl"));
        //login butonuna bas
        moly.logIn.click();
        //test data username: manager
        //test data password : Manager1!
        Actions actions=new Actions(Driver.getDriver());
        actions.click(moly.username).sendKeys(ConfigReader.getProperty("molyUser")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("molyPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        //WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
       //WebElement x=wait.until(ExpectedConditions.visibilityOfElementLocated((By) moly.successLogin));
        Assert.assertTrue(moly.successLogin.isDisplayed());
        Driver.getClose();

    }


}
