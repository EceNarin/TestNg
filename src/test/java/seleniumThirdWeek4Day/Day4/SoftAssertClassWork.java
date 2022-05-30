package seleniumThirdWeek4Day;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SoftAssertClassWork extends TestBase {
    @Test
    public void Test(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click();
        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        // 5. Sign in tusuna basin
        Actions action=new Actions(driver);
        action.sendKeys("username").sendKeys(Keys.TAB).sendKeys("password")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        driver.navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id=\"online-banking\"]\n")).click();
        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id=\"pc_currency\"]"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("sp_sell_rate")).isDisplayed(),"not displayed");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> actualAll=select.getOptions();
        List<String> newlist=new ArrayList<>();
        List<String> optionsExpected = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)"));


            for(int i=0;i< actualAll.size();i++){
                newlist.add(i,actualAll.get(i).getText());
            }
        newlist.stream().forEach(t-> System.out.println(t));
        softAssert.assertTrue(newlist.containsAll(optionsExpected),"not contains");
        softAssert.assertAll();


        //  "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China(yuan)",
        //  "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong(dollar)",
        //  "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand(dollar)",
        //  "Sweden (krona)","Singapore (dollar)","Thailand (baht)"*/
        /*
        List<String> optionsExpected = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
        "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        "Singapore (dollar)","Thailand (baht)"));
         */
    }
}
