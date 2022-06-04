package Tests.AutomationExercise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShoot;
import utilities.TestBaseRapor;

public class VerifyProductChart extends TestBaseRapor {
    @Test
    public void test() throws InterruptedException {
        extentTest=extentReports.createTest("Positive verify","Verify Product");
        //3. Verify that home page is visible successfully
        extentTest.info("get automation excercise Page");
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //4. Click 'Products' button
        extentTest.info("click to product button");
        SoftAssert soft=new SoftAssert();
        AutomationExercise ae=new AutomationExercise();
        ae.productButton.click();
        //5. Hover over first product and click 'Add to cart'
        extentTest.info("click first products' chart button");
        ae.buttonAddToCart.click();
        //6. Click 'Continue Shopping' button
        extentTest.info("click to continue shop button");
        Thread.sleep(1500);
        extentTest.pass("continue shop buttons' text is visible");
        soft.assertTrue(ae.continueShop.getText().equals("Continue Shopping"));
        Thread.sleep(1500);
        //for taken screenshot threadSleep work better
        extentTest.info("click to continue shop button");
        ScreenShoot.takeShootWebElement(ae.continueShop);
        ae.continueShop.click();

        //7. Hover over second product and click 'Add to cart'

        extentTest.info("add second product to chart");
        ae.choiceProductChartByIndex(2).click();
        Thread.sleep(2000);//waiting  for visible
        extentTest.pass("passed if continue button is displayed");
        soft.assertTrue(ae.continueShop.isDisplayed());
        //8. Click 'View Cart' button
        extentTest.info("click to view chart");
        Driver.getDriver().findElement(By.linkText("View Cart")).click();
        //9. Verify both products are added to Cart
        String products= ae.choiceProductDetailsByIndex(1).getText() + " " +ae.choiceProductDetailsByIndex(2).getText();
        boolean ifHas= Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[2]/h4/a")).stream().allMatch(t->products.contains(t.getText()));
        Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[2]/h4/a")).stream().forEach(t-> System.out.println(t.getText()));
        extentTest.pass("verifying to if products add ");
        soft.assertTrue(ifHas);
        //10. Verify their prices, quantity and total price
        int sumOfPrice=Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[3]/p")).stream()
        .mapToInt(t-> Integer.parseInt(t.getText().replaceAll("Rs.","").trim())).sum();;
       int totalSum=Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[5]/p")).stream()
       .mapToInt(t-> Integer.parseInt(t.getText().replaceAll("Rs.","").trim())).sum();
        extentTest.pass("verifying if price and total price sum of equals");
       soft.assertTrue(sumOfPrice==totalSum);
        soft.assertAll();
       Driver.getClose();

    }
}
