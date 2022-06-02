package SeleniumForthWeeks.E2ETest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;

public class E2ETest {
    @Test
    public void E2E() throws InterruptedException {
        //3. https://www.hotelmycamp.com adresine git.
        HotelMoly moly=new HotelMoly();
        Driver.getDriver().get(ConfigReader.getProperty("hotelMolyUrl"));
        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager
        //b. Password : Manager1!
        //5. Login butonuna tıklayın.
        moly.logIn.click();
        moly.username.sendKeys(ConfigReader.getProperty("molyUser"));
        moly.password.sendKeys(ConfigReader.getProperty("molyPassword"));
        moly.submit.click();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        Actions action=new Actions(Driver.getDriver());

        WebElement hotelMenu= Driver.getDriver().findElement(By.xpath("(//span[@class=\"title\"])[3]"));
        action.clickAndHold(hotelMenu).sendKeys(Keys.PAGE_DOWN).click().click(Driver.getDriver()
        .findElement(By.xpath("//ul[@class=\"sub-menu\"]//li[2]//ul//li[1]"))).perform();
        //addHotel button
        Driver.getDriver().findElement(By.xpath("//span[@class=\"hidden-480\"]")).click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8. Save butonuna tıklayın.
        Faker fake=new Faker();
        action.click(Driver.getDriver().findElement(By.xpath("//input[@title=\"Code\"]"))).sendKeys(fake.code().gtin8()).sendKeys(Keys.TAB)
        .sendKeys("Asya Hotel").sendKeys(Keys.TAB).sendKeys("Zurih").sendKeys(Keys.TAB).sendKeys(fake.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
        .sendKeys(fake.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ENTER)
        .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        //10. “Hotel was inserted successfully” take screenshot
                        Thread.sleep(1500);
        WebElement actualAlertElement=Driver.getDriver().findElement(By.xpath("//div[@class=\"bootbox-body\"]"));
        ScreenShoot.takeShootWebElement(actualAlertElement);
        String expectedAlertText="Hotel was inserted successfully";
        Assert.assertTrue(actualAlertElement.getText().equals(expectedAlertText));
        Assert.assertTrue(actualAlertElement.isDisplayed());
        //11. OK butonuna tıklayın.
        Driver.getDriver().findElement(By.xpath("(//button[@type=\"button\"])[6]")).click();
        //12. sayfayi kapatin
        Driver.getClose();


    }



}
