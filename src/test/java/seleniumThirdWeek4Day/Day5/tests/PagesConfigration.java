package tests;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class PagesConfigration {
    @Test
    public void test() {
        AmazonPage amazonPage=new AmazonPage();
        //Amazon'a girelim
        Driver.getDriver().get("https://www.amazon.com");
        //nutella aratalim
        amazonPage.searchbox.sendKeys("Nutella" + Keys.ENTER);
        //Sonuc yazisinin nutella icerdigini test edelim
        Assert.assertTrue(amazonPage.result.getText().contains("Nutella"));
        Driver.getClose();

    }
}
