package Elf;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ScreenShoot;

public class AlertDependsOn {
    @Test
    public void test1() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. CLICK ME of JavaScript Alert e tıklayın
        ScreenShoot.takeShootAllScreen();
        Driver.getDriver().findElement(By.xpath("//span[@id=\"button1\"]")).click();
        // 3. pop up text i alın
        String alertText=Driver.getDriver().switchTo().alert().getText();
        SoftAssert soft=new SoftAssert();
        // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
        soft.assertTrue(alertText.equals("I am an alert box!"));
        // 5. pop up i kabul edin
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test (dependsOnMethods = "test1")
    public void test2() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
        SoftAssert soft=new SoftAssert();
        Driver.getDriver().findElement(By.xpath("//span[@id=\"button4\"]")).click();
        // 3.  pop up text i alın
        String alertText=Driver.getDriver().switchTo().alert().getText();
        // 4. Mesajın "Press a button!" olduğunu doğrulayın
        soft.assertTrue(alertText.equals("Press a button!"));
        // 5. Açılır pencereyi kapat
        // 6. pop up i iptal edin,
        Driver.getDriver().switchTo().alert().dismiss();
        // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
        String cancelText=Driver.getDriver().findElement(By.xpath("//p[@id=\"confirm-alert-text\"]")).getText();
        ScreenShoot.takeShootWebElement(Driver.getDriver().findElement(By.xpath("//p[@id=\"confirm-alert-text\"]")));
        soft.assertTrue(cancelText.equals("You pressed Cancel!"));
        soft.assertAll("all test finished");
        Driver.getClose();
        // 8. alert1'e göre dependsOnMethods kullanın
    }
}
