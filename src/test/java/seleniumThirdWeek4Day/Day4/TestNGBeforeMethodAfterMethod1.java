package seleniumThirdWeek4Day;

import org.testng.annotations.Test;
import utilities.TestBase;

public class TestNGBeforeMethodAfterMethod1 extends TestBase {
   // working order as alphabethic order
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }
    @Test
    public void a(){
        driver.get("https://www.facebook.com");
    }
    @Test
    public void b(){
        driver.get("https://www.bestbuy.com");
    }
}
