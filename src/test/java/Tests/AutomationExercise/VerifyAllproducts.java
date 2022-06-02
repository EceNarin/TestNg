package Tests.AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class VerifyAllproducts {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        AutomationExercise ae=new AutomationExercise();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(ae.homePage.isDisplayed());
        //4. Click on 'Products' button
        ae.productButton.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        soft.assertTrue(Driver.getDriver().getCurrentUrl().contains("products"));
        //6. The products list is visible
        soft.assertTrue(ae.visibleTestText.isDisplayed());
        //7. Click on 'View Product' of first product
         ae.viewProductButton.click();
        //8. User is landed to product detail page
        soft.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class=\"product-information\"]")).isEnabled());
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Driver.getDriver().findElements(By.xpath("//div[@class=\"product-information\"]")).stream()
                .forEach(t-> System.out.println(t.getText()));
        Driver.getClose();

        }

    }

