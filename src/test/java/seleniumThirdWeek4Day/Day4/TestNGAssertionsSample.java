package seleniumThirdWeek4Day.Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class TestNGAssertionsSample extends TestBase {
    @Test
    public void test(){
        SoftAssert softAssert=new SoftAssert();
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")).click();
        //1.Test : Amazon ana sayfaya gittiginizi test edin
        softAssert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"),"url tutmadi");
        //2.Test : search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div\n")).getText().contains("Nutella"),"nutella bulamadik");
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
        driver.findElement(By.xpath("//img[@data-image-index=\"1\"]")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-price\"]")).getText().equals("$16.83"),"fiyat tutmadi");
        softAssert.assertAll();
        System.out.println("bagalim caliscak mi");
    }
}
