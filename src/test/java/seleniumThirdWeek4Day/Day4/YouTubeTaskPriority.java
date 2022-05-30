package seleniumThirdWeek4Day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class YouTubeTaskPriority {

    WebDriver driver;
    @Test (priority = -3)
    public void titleTest(){
        // ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertTrue(driver.getTitle().equals("YouTube"));

    }
    @Test (priority = 2)
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"logo-icon\"]\n")).isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.id("search")).isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
    @BeforeClass
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public void close(){
        driver.quit();

    }

}
