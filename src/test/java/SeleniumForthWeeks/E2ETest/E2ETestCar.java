package SeleniumForthWeeks.E2ETest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;

import java.time.Duration;

public class E2ETestCar {


    @Test
    public void testName() throws InterruptedException {
        // go to bluerental.com
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //click to login button
        BlueCar car=new BlueCar();
        car.login.click();
        car.createNewUser.click();
        //create and new account
        Actions action=new Actions(Driver.getDriver());
        Faker fake=new Faker();
        String password=fake.internet().password();
        String email=fake.internet().emailAddress();
        action.click(car.firstName).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().lastName()).sendKeys(Keys.TAB)
        .sendKeys(fake.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).sendKeys(fake.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(fake.address().zipCode())
        .sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB)
        .sendKeys(Keys.ENTER).perform();
        //login with account
        Thread.sleep(6000);
        car.userMail.sendKeys(email);
        car.password.sendKeys(password);
        car.submit.click();
        Assert.assertTrue(car.succesLogin.isDisplayed());
        ScreenShoot.takeShootAllScreen();
        Thread.sleep(1500);
        ScreenShoot.takeShootWebElement(car.succesLogin);

    }

}
