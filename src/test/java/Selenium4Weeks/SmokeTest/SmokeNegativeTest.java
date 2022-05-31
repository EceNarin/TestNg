package Selenium4Weeks.SmokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class SmokeNegativeTest {
    @Test
    public void test() {
        //3 Farkli test Methodunda 3 senaryoyu test et
        //- yanlisSifre
        //- yanlisKulllanici
        //- yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1
        //2) https://www.hotelmycamp.com adresine git
        HotelMoly moly=new HotelMoly();
        Driver.getDriver().get(ConfigReader.getProperty("hotelMoly"));
        //3) Login butonuna bas
        moly.logIn.click();
        Actions action=new Actions(Driver.getDriver());
        action.click(moly.username).sendKeys(ConfigReader.getProperty("wrongUsername")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("wrongPassword")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
        //4) Verilen senaryolar ile giris yapilamadigini test et
        Assert.assertTrue(moly.UnSuccessLogin.isDisplayed());
        Driver.getClose();
    }

}
