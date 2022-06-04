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

public class VerifyCartPage {
    @Test
    public void test() {
        //3. Verify that home page is visible successfully
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        AutomationExercise ae=new AutomationExercise();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(ae.homePage.isDisplayed());
        //4. Click 'Cart' button
        ae.testCaseButton.click();
        //5. Scroll down to footer
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.END).perform();
        //6. Verify text 'SUBSCRIPTION'
        Faker fake=new Faker();
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"col-sm-3 col-sm-offset-1\"]//div/h2")).isDisplayed());
        //7. Enter email address in input and click arrow button
        action.click(Driver.getDriver().findElement(By.xpath("//input[@id=\"susbscribe_email\"]")))
                .sendKeys(fake.internet().emailAddress()).sendKeys(Keys.ENTER).perform();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id=\"success-subscribe\"]"))
                .getText().equals("You have been successfully subscribed!"));
        ScreenShoot.takeShootWebElement(Driver.getDriver().findElement(By.xpath("//div[@id=\"success-subscribe\"]")));
        soft.assertAll();
        Driver.getClose();
    }
}
