package Tests.AutomationExercise;

import com.sun.prism.shader.DrawRoundRect_ImagePattern_AlphaTest_Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Random;

public class VerifyProductQuantity extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("positive test","verify product quantitiy");
        extentTest.info("navigate to http://automationexercise.com");
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        extentTest.pass("Verify that home page is visible");
        AutomationExercise ae=new AutomationExercise();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(ae.homePage.isDisplayed());
        //4. Click 'View Product' for any product on home page
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        Random rnd=new Random();
        int choice=rnd.nextInt(ae.allProducts.size());
        System.out.println(choice);
        extentTest.info("Click 'View Product' for any product on home page");
        String proText=ae.choiceProductDetailsByIndex(18).getText();
        System.out.println(proText);
        Thread.sleep(3000);
        ae.choiceProductDetailsByIndex(18).click();
        //5. Verify product detail is opened
        Thread.sleep(1500);
        boolean verifyDetails=Driver.getDriver().findElement(By.xpath("//div[@class=\"product-details\"]")).isDisplayed();
        extentTest.pass("Verify product detail is opened");
        soft.assertTrue(verifyDetails);
        //6. Increase quantity to 4
        extentTest.info("Increase quantity to 4");
        ae.quantityButton.clear();
        ae.quantityButton.sendKeys("4");
        Thread.sleep(3000);
       //7. Click 'Add to cart' button
        extentTest.info("Click 'Add to cart");
        Driver.getDriver().findElement(By.xpath("//button[@type=\"button\"]")).click();
        //8. Click 'View Cart' button
        extentTest.info("Click 'View Cart' button");
        Driver.getDriver().findElement(By.xpath("(//a[@href=\"/view_cart\"])[2]")).click();
        //9. Verify that product is displayed in cart page with exact quantity*/
        WebElement quantitiy= Driver.getDriver().findElement(By.xpath("//button[@class=\"disabled\"]"));
        extentTest.pass("Verify that product is displayed in cart page with exact quantity");
        soft.assertTrue(quantitiy.getText().equals("4"));
        soft.assertAll();
        Driver.getClose();
    }
}
