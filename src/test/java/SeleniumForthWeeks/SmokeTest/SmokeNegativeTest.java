package SeleniumForthWeeks.SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;

public class SmokeNegativeTest {
    @Test
    public void test() throws InterruptedException {
        //3 Farkli test Methodunda 3 senaryoyu test et
        //- yanlisSifre
        //- yanlisKulllanici
        //- yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1
        //2) https://www.hotelmycamp.com adresine git
        HotelMoly moly=new HotelMoly();
        Driver.getDriver().get(ConfigReader.getProperty("hotelMoly"));
        ScreenShoot.takeShootAllScreen();
        //3) Login butonuna bas
        moly.logIn.click();
        Actions action=new Actions(Driver.getDriver());
        action.click(moly.username).sendKeys(ConfigReader.getProperty("wrongUsername")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("wrongPassword")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //4) Verilen senaryolar ile giris yapilamadigini test et
        ScreenShoot.takeShootWebElement(moly.UnSuccessLogin);
        Assert.assertTrue(moly.UnSuccessLogin.isDisplayed());
        Driver.getClose();
    }

}
