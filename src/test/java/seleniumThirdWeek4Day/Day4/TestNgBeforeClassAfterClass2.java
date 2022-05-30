package seleniumThirdWeek4Day;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class TestNgBeforeClassAfterClass2 extends TestBase {
    /*
    beforeClass tum testlerden once sadece bir kez calisr
    testbase parent classımızda bulunan before method ve aftermethod ise her testettn once birer kez calisir
    TestNg'de @Test annotation JUnit'ten farklş olarak testleri alphabetic order'a göre calistirir
     */
    @BeforeClass
    public void beforeclassmethodu(){
        System.out.println("first");
    }
   @Test
        public void amazon(){
            driver.get("https://www.amazon.com");
        }
        @Test
        public void facebook(){
            driver.get("https://www.facebook.com");
        }
        @Test
        public void bestbuy(){
            driver.get("https://www.bestBuy.com");
    }
    @AfterClass
    public void afterclassmethodu(){
        System.out.println("last");
    }
}
