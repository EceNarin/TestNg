package seleniumThirdWeek4Day.Day5.tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FaceBookPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class FaceBookTest extends TestBaseRapor {
    @Test
    public void test() {
        extentTest=extentReports.createTest("pozitifTest","create login");
        //1 -https://www.facebook.com/ adresine gidin
        extentTest.info("get to facebook");
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        FaceBookPages fb=new FaceBookPages();
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        Faker fake=new Faker();
        Actions action=new Actions(Driver.getDriver());
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        extentTest.info("create an account by faker repo and actions class object");
        action.click(fb.emailBox).sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(fake.internet().password()).perform();
        extentTest.info("submit after indormations ");
        fb.submitLogin.click();
        //4- Basarili giris yapilamadigini test edin
        extentTest.pass("test passed succesfully");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"_9ay7\"]")).isDisplayed());
    }
}
