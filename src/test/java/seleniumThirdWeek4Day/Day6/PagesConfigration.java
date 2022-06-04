package seleniumThirdWeek4Day.Day6;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PagesConfigration extends TestBaseRapor {
    @Test
    public void test() {
        extentTest=extentReports.createTest("pozitif","pageconfigration");
        AmazonPage amazonPage=new AmazonPage();
        //Amazon'a girelim
        extentTest.pass("get amazon site");
        Driver.getDriver().get("https://www.amazon.com");
        //nutella aratalim
        extentTest.pass("seacrh nutella");
        amazonPage.searchbox.sendKeys("Nutella" + Keys.ENTER);
        //Sonuc yazisinin nutella icerdigini test edelim
        extentTest.pass("test passed");
        Assert.assertTrue(amazonPage.result.getText().contains("Nutella"));
        Driver.getClose();

    }
}
