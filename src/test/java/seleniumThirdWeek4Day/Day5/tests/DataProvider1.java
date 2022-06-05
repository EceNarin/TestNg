package seleniumThirdWeek4Day.Day5.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueCar;
import utilities.ConfigReader;
import utilities.Driver;
public class DataProvider1 {


        BlueCar brcPage;
        @DataProvider
        public static Object[][] kullaniciListesi() {
            Object[][] kullaniciBilgileri={{"firuze@nehaber.com","54678"},
                    {"murat@benbuisibilirim.com","65874"},
                    {"ilyas@hollandadanselam.com","85967"}};
            return kullaniciBilgileri;
        }
        @Test(dataProvider = "kullaniciListesi")
        public void yanlisSifre(String userEmail, String password) throws InterruptedException {
            brcPage=new BlueCar();
            // Bir test method olustur positiveLoginTest()
            //       https://www.bluerentalcars.com/ adresine git
            Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
            //      login butonuna bas
            Thread.sleep(2000);
            brcPage.login.click();
            // test data user email: dataprovider'dan alalim,
            brcPage.userMail.sendKeys(userEmail);
            // test data password : dataprovider'dan alalim
            brcPage.password.sendKeys(password);
            // login butonuna tiklayin
            brcPage.submit.click();
            // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
            Assert.assertTrue(brcPage.submit.isDisplayed());
            Driver.getClose();
        }
    }


