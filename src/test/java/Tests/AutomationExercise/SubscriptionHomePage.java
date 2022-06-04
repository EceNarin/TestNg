package Tests.AutomationExercise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;

public class SubscriptionHomePage {
    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        AutomationExercise ae=new AutomationExercise();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(ae.homePage.isDisplayed());
        //4. Scroll down to footer
        Actions action=new Actions(Driver.getDriver());
        Faker fake=new Faker();
        action.sendKeys(Keys.END).perform();
        //5. Verify text 'SUBSCRIPTION'
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"col-sm-3 col-sm-offset-1\"]//div/h2")).isDisplayed());
        //6. Enter email address in input and click arrow button
        action.click(Driver.getDriver().findElement(By.xpath("//input[@id=\"susbscribe_email\"]")))
                .sendKeys(fake.internet().emailAddress()).sendKeys(Keys.ENTER).perform();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id=\"success-subscribe\"]"))
        .getText().equals("You have been successfully subscribed!"));
        ScreenShoot.takeShootWebElement(Driver.getDriver().findElement(By.xpath("//div[@id=\"success-subscribe\"]")));
        soft.assertAll();
        Driver.getClose();
    }
}
