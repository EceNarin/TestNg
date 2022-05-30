package seleniumThirdWeek4Day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.TestBase;

import java.time.Duration;

public class DependOnMethod4  {
    /*
    bagimsiz olan method'u ilk alip calistirir, burada alphabetic order'a gore yapmaz. bagimsiz olan yani @Test annotations'in yanindaki
    parantezde dependOnMethod yazmayan method'u il calistırır daha sonra kurala gore gidr. burada testBase class'iyla baglantıyı kestik before ve after class
    kulandık cunku bir kez amazon'a baglnamaını ıstıyoruz ve bir kez kapanmasını istiyoruz
     */
    WebDriver driver;
    @BeforeClass
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public void close(){
        driver.quit();

    }
    @Test
    public void amazon(){
        //amazon sitesine gidin
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods ="amazon")
    public void searchNutella(){
        //arama kutusuna Nutella yazip clik yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
    }
    @Test (dependsOnMethods ="searchNutella")
    public void resultOfNutella(){
        //sonucun icersinde "Nutella" oldugunu test edin ve oncesinde sonucu yazdirin
        WebElement result=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div\n"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().contains("Nutella"));
    }
}
