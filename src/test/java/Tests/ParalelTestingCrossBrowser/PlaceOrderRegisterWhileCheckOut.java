package Tests.ParalelTestingCrossBrowser;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;

import java.util.List;

public class PlaceOrderRegisterWhileCheckOut {
    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        AutomationExercise ae=new AutomationExercise();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(ae.homePage.isDisplayed());
        //4. Add products to cart
        ae.choiceProductChartByIndex(5).click();
        //5. Click 'Cart' button
        ae.continueShop.click();
        ae.viewButtonCart.click();
        //6. Verify that cart page is displayed
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//li[@class=\"active\"]")).isDisplayed());
        //7. Click Proceed To Checkout
        Driver.getDriver().findElement(By.linkText("Proceed To Checkout")).click();
        //8. Click 'Register / Login' button
        Driver.getDriver().findElement(By.xpath("(//a[@href=\"/login\"])[2]")).click();
        //9. Fill all details in Signup and create account
        Actions action=new Actions(Driver.getDriver());
        Faker fake=new Faker();
        String name=fake.name().firstName();
        String mail=fake.internet().emailAddress();
        action.click(ae.newUserName).sendKeys(name).sendKeys(Keys.TAB).sendKeys(mail).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        action.click(Driver.getDriver().findElement(By.xpath("//input[@id=\"id_gender2\"]"))).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
        .sendKeys(fake.internet().password()).sendKeys(Keys.TAB).sendKeys("13").sendKeys(Keys.TAB).sendKeys("January").sendKeys(Keys.TAB).sendKeys("1996").sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(fake.name().firstName()).sendKeys(Keys.TAB).sendKeys(fake.name().lastName()).sendKeys(Keys.TAB)
        .sendKeys(fake.company().name()).sendKeys(Keys.TAB).sendKeys(fake.address().buildingNumber()).sendKeys(Keys.TAB).sendKeys(fake.address().buildingNumber())
        .sendKeys(Keys.TAB).sendKeys(fake.country().name()).sendKeys(Keys.TAB).sendKeys(fake.address().state()).sendKeys(Keys.TAB).sendKeys(fake.address().cityName())
        .sendKeys(Keys.TAB).sendKeys(fake.address().zipCode()).sendKeys(Keys.TAB).sendKeys(fake.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
        .perform();
        //10. Verify 'ACCOUNT CREATED!'
        String actualword=Driver.getDriver().findElement(By.xpath("//h2[@data-qa=\"account-created\"]//b")).getText();
        soft.assertTrue(actualword.equals("ACCOUNT CREATED!"));
        //and click 'Continue' button
        ////a[@class="btn btn-primary"]
        Driver.getDriver().findElement(By.linkText("Continue")).click();
        //11. Verify ' Logged in as username' at top
        String topName=Driver.getDriver().findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//li[9]/a/b")).getText();
        System.out.println(topName);
        soft.assertTrue(ae.visibleTopNameAsUser.isDisplayed());
        //12.Click 'Cart' button
        ae.viewButtonCart.click();
        //13. Click 'Proceed To Checkout' button
        Driver.getDriver().findElement(By.linkText("Proceed To Checkout")).click();
        //14. Verify Address Details
        String adress=Driver.getDriver().findElement(By.xpath("//ul[@id=\"address_delivery\"]")).getText();
        int length=adress.length();
        System.out.println("\nAdress"+adress + "\n Length" + length);
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//ul[@id=\"address_delivery\"]")).isDisplayed());
        //and Review Your Order
        List <WebElement> reviewOrder=Driver.getDriver().findElements(By.xpath("//table//tbody//tr[1]//td"));
        reviewOrder.stream().forEach(t-> System.out.println(t.getText()));
        //Verify and Review Your Order
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//table//tbody//tr[1]")).isEnabled());
        //15. Enter description in comment text area
        //and click 'Place Order'
        action.click(Driver.getDriver().findElement(By.xpath("//textarea[@rows=\"6\"]"))).sendKeys(fake.lorem().sentence())
        .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //Driver.getDriver().findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys(fake.name().firstName());
        action.click(Driver.getDriver().findElement(By.xpath("//input[@class=\"form-control\"]"))).sendKeys(fake.name().firstName())
        .sendKeys(Keys.TAB).sendKeys(fake.finance().creditCard()).sendKeys(Keys.TAB).sendKeys("345").sendKeys(Keys.TAB).sendKeys("05").sendKeys(Keys.TAB)
        .sendKeys("2029").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //18. Verify success message 'Your order has been placed successfully!'
        ScreenShoot.takeShootAllScreen();
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[@class=\"title text-center\"]//b")).getText().equals("ORDER PLACED!"));
        //19. Click 'Delete Account' button
        ae.deleteAccountButton.click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        soft.assertFalse(Driver.getDriver().findElement(By.xpath("//div[@class=\"page-header\"]")).getText().equals("ACCOUNT DELETED!"));
        soft.assertAll();
        Driver.getClose();
    }
}
