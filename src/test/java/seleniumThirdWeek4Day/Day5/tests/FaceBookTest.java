package seleniumThirdWeek4Day.Day5.tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FaceBookPages;
import utilities.Driver;

public class FaceBookTest {
    @Test
    public void test() {
        //1 -https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        FaceBookPages fb=new FaceBookPages();
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        Faker fake=new Faker();
        Actions action=new Actions(Driver.getDriver());
        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        action.click(fb.emailBox).sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(fake.internet().password()).perform();
        fb.submitLogin.click();
        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"_9ay7\"]")).isDisplayed());
    }
}
