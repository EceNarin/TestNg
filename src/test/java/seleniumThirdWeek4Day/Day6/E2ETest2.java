package seleniumThirdWeek4Day.Day6;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMoly;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;
import utilities.TestBaseCross;

public class E2ETest2  {

    //2. Bir metod olusturun: RoomCreateTest()
    @Test
    public void RoomCreateTest() throws InterruptedException {
        HotelMoly moly=new HotelMoly();
        //3. https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("hotelMolyUrl"));
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        Thread.sleep(1500);
        moly.logIn.click();
        moly.username.sendKeys(ConfigReader.getProperty("molyUser"));
        moly.password.sendKeys(ConfigReader.getProperty("molyPassword"));
        //5. Login butonuna tıklayın.
        moly.submit.click();
        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        Actions action=new Actions(Driver.getDriver());
        WebElement hotelMenu= Driver.getDriver().findElement(By.xpath("(//span[@class=\"title\"])[3]"));
        action.clickAndHold(hotelMenu).sendKeys(Keys.PAGE_DOWN).click().click(Driver.getDriver()
                .findElement(By.xpath("//ul[@class=\"sub-menu\"]//li[2]//ul//li[2]"))).perform();
        //addHotelRoom button
        Driver.getDriver().findElement(By.xpath("//span[@class=\"hidden-480\"]")).click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8. Save butonuna basin.
        Faker fake=new Faker();
        WebElement ddm=Driver.getDriver().findElement(By.xpath("//select[@id=\"IDHotel\"]"));
        Select select=new Select(ddm);
        select.selectByValue("1016");
        WebElement code=Driver.getDriver().findElement(By.xpath("//input[@id=\"Code\"]"));
        action.click(code).sendKeys(fake.code().gtin13()).sendKeys(Keys.TAB).sendKeys(fake.company().name()).sendKeys(Keys.TAB)
        .sendKeys(fake.address().country()).sendKeys(Keys.TAB).sendKeys(fake.lorem().sentence(170)).sendKeys(Keys.TAB)
        .dragAndDrop(Driver.getDriver()
        .findElement(By.xpath("//li[@data-id=\"700\"]")),Driver.getDriver().findElement(By.xpath("//input[@id=\"Price\"]")))
                .perform();
        select=new Select(Driver.getDriver().findElement(By.xpath("//select[@id=\"IDGroupRoomType\"]")));
        select.selectByVisibleText("Queen");
        action.click(Driver.getDriver()
        .findElement(By.xpath("//input[@id=\"MaxAdultCount\"]"))).sendKeys(String.valueOf(fake.number().numberBetween(1,5)))
        .sendKeys(Keys.TAB).sendKeys(String.valueOf(fake.number().numberBetween(1,6))).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(1500);
        ScreenShoot.takeShootAllScreen();
        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        SoftAssert soft=new SoftAssert();
        WebElement success=Driver.getDriver().findElement(By.xpath("//div[@class=\"bootbox-body\"]"));
        soft.assertTrue(success.isDisplayed());
        ScreenShoot.takeShootWebElement(success);
        Thread.sleep(1500);
        //10. OK butonuna tıklayın.
        Driver.getDriver().findElement(By.xpath("(//button[@type=\"button\"])[6]")).click();
        //11. Hotel rooms linkine tıklayın.
        action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).click(Driver.getDriver().findElement(By.xpath("//a[@class=\"remove\"]"))).click().perform();
        action.sendKeys(Keys.PAGE_UP).moveToElement(Driver.getDriver().findElement(By.xpath("//a[@href=\"/admin/HotelroomAdmin\"]"))).doubleClick()
                .perform();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        WebElement greenPart=Driver.getDriver().findElement(By.xpath("//span[@class=\"caption-subject font-green-sharp bold uppercase\"]"));
        soft.assertTrue(greenPart.isDisplayed());
        ScreenShoot.takeShootWebElement(greenPart);
        soft.assertAll();
        Driver.getClose();
    }

}
