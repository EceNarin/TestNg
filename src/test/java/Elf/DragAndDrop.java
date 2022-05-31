package Elf;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ScreenShoot;

public class DragAndDrop {
    @Test
    public void testName() throws InterruptedException {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        // Fill in capitals by country.
        Actions action=new Actions(Driver.getDriver());
        action.dragAndDrop(Driver.getDriver()
        .findElement(By.xpath("//div[@id='box5']")),Driver.getDriver().findElement(By.xpath("//div[@id='box105']")))
        .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box4']")),Driver.getDriver().findElement(By.xpath("//div[@id='box104']")))
         .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box3']")),Driver.getDriver().findElement(By.xpath("//div[@id='box103']")))
         .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box2']")),Driver.getDriver().findElement(By.xpath("//div[@id='box102']")))
         .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box1']")),Driver.getDriver().findElement(By.xpath("//div[@id='box101']")))
         .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box6']")),Driver.getDriver().findElement(By.xpath("//div[@id='box106']")))
         .dragAndDrop(Driver.getDriver()
         .findElement(By.xpath("//div[@id='box7']")),Driver.getDriver().findElement(By.xpath("//div[@id='box107']")))
                .perform();
        Thread.sleep(1600);
        ScreenShoot.takeShootAllScreen();
        Driver.getClose();
    }
}
