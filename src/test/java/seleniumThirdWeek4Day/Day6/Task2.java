package seleniumThirdWeek4Day.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class Task2 extends TestBaseCross {
    @Test
    public void test() {
        //    http://demo.guru99.com/test/drag_drop.html url e git
         Driver.getDriver().get(ConfigReader.getProperty("demoGuru99"));
        //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions action=new Actions(Driver.getDriver());
        WebElement source=Driver.getDriver().findElement(By.xpath("//li[@id=\"credit2\"]"));
        WebElement target=Driver.getDriver().findElement(By.xpath("(//li[@class=\"placeholder\"])[1]"));
        action.dragAndDrop(source,target).perform();
        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        WebElement source2=Driver.getDriver().findElement(By.xpath("//li[@data-id=\"6\"]"));
        WebElement target2=Driver.getDriver().findElement(By.xpath("//ol[@id=\"loan\"]"));
        action.dragAndDrop(source2,target2).perform();
        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        WebElement source3=Driver.getDriver().findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));
        WebElement target3=Driver.getDriver().findElement(By.xpath("//ol[@id=\"amt7\"]"));
        action.dragAndDrop(source3,target3).perform();
       //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        WebElement source4=Driver.getDriver().findElement(By.xpath("(//li[@data-id=\"2\"])[2]"));
        WebElement target4=Driver.getDriver().findElement(By.xpath("//ol[@id=\"amt8\"]"));
        action.dragAndDrop(source4,target4).perform();
        //    Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//a[@class=\"button button-green\"])[1]")).isDisplayed());
        Driver.getClose();


    }

}
