package Elf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;
import java.util.List;
import java.util.OptionalDouble;

public class SoftAllertTask {
    @Test
    public void testName() {
        SauceDemoPage sd=new SauceDemoPage();
        //* Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));
        //* Enter the username  as standard_user
        // * Enter the password as   secret_sauce
        Actions actions=new Actions(Driver.getDriver());
        actions.click(sd.demoUsername).sendKeys(ConfigReader.getProperty("demoUsername")).sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("demoPassword"))
                .perform();
        //* Click on login button
        sd.login.click();
        //*T1 : Choose price low to high with soft Assert
        WebElement ddm=Driver.getDriver().findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
        actions.clickAndHold(ddm);
        Select select=new Select(ddm);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> list=Driver.getDriver().findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        OptionalDouble min=list.stream().mapToDouble(t->Double.parseDouble(t.getText().replaceAll("\\$","").trim())).min();
        OptionalDouble max=list.stream().mapToDouble(t->Double.parseDouble(t.getText().replaceAll("\\$","").trim())).max();
        //*T2 : Verify item prices are sorted from low to high with hard Assert
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(min.getAsDouble()< max.getAsDouble());
        soft.assertAll("All test finished");
        Driver.getClose();
        // Verify item prices are sorted from low to high with hard Assert
    }
}

