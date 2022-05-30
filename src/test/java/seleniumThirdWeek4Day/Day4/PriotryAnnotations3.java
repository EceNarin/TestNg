package seleniumThirdWeek4Day.Day4;

import org.testng.annotations.Test;
import utilities.TestBase;

public class PriotryAnnotations3 extends TestBase {
    /*
    TestNG'de onceden de dedigimiz gibi methodlar alphabetic order'a gore calisirdi
    eger kendimiz bir siralama belirlemek istersek;
    priority ozelligini kullanbiliriz, kucukten buyuge calisir eger diger methoda atanmazsa default olarak sıfır(0)
    degerini alir
     */
    @Test(priority = 3)
    public void amazon(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void facebook(){
        driver.get("https://www.facebook.com");
    }
    @Test (priority = 2)
    public void bestbuy(){
        driver.get("https://www.bestBuy.com");
    }
}
