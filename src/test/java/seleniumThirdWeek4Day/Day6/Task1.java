package seleniumThirdWeek4Day.Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseCross;

import java.time.Duration;

public class Task1 extends TestBaseCross {
    WebDriver driver;
    @Test
    public void name() {
        //TASK 1 - JUnit ve TestBase kullanmadan main metot ile yapılacak.
//1. Driver oluştur.
//2. Pencereyi tam ekran yap.
//3. 15 saniye bekleme ayarı yap.
        WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //4. https://www.trivago.com/ adresine git
        driver.get("https://www.trivago.com/");
        //5. Site başlığının "hotel" kelimesi içerdiğini doğrula. Başlığı yazdır.
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("hotel"));
        //6. Site adresinin https://www.trivago.com/ olduğunu doğrula. Adresi yazdır
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.trivago.com/"));
        System.out.println(driver.getCurrentUrl());
        //7. Tepe menüdeki Cars linkini üç farklı locator kullanarak locate et. Locatorleri yazdır.
        //first locate of cars element
        WebElement we=driver.findElement(By.xpath("//li[@class=\"flex items-center relative px-4 text-m hover:bg-grey-200\"]"));
        //second locate of cars element
        //driver.findElement(By.xpath("(//a[@class=\"flex items-center h-full\"])[1]"));
        //third locate of cars element
        //driver.findElement(By.tagName("/en-US/vrt/cars"));

        driver.close();


    }

    }





