package MySpecificTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;

import java.time.Duration;
import java.util.Set;

public class Task2 {

         @Test
        public void test1()  {
            //1. https://www.trivago.com/ adresine git
            Driver.getDriver().get("https://www.trivago.com/");
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            WebElement cookies=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")));
            cookies.click();
            String firstPageHandle=Driver.getDriver().getWindowHandle();
            //2. Tepe menüdeki Flights linkine tıkla. Kendisi yeni sekmede açılacak. Oraya gidecek.
            Driver.getDriver().findElement(By.xpath("//a[@href=\"/en-US/vrt/flights\"]")).click();
            Set<String> handles=Driver.getDriver().getWindowHandles();
            //3. Sayfayı en aşağı kaydır. Sonra tekrar en yukarı kaydır. (Göz attık.)(ssAl)
            JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
            WebElement we=Driver.getDriver().findElement(By.xpath("//input[@type=\"email\"]"));
            js.executeScript("arguments[0].scrollIntoView(true)",we);
             //4. Ana sayfaya (açık olan önceki sekmeye) dön.
             Driver.getDriver().switchTo().window(firstPageHandle);
        }

        @Test
        public void test2() {
            //10. Gelen sonuçlarda Guest rating üzerine gel ve Very good'u seç.
            //11. More filters üzerine gel, Hotel class'ta 4 ve 5 yıldızı seç, popular filters'tan Beach seç.
            //12. En üstteki sonucun resmi üzerine gel. More photos linkinin göründüğünü doğrula. Linke tıkla.
        }
        @Test (dependsOnMethods="test1")
        public void test3() throws InterruptedException {
            //5. All stays - Hotel - House / Apartment sekmelerinden Hotel sekmesine tıkla.
            Driver.getDriver().findElement(By.xpath("//label[@data-title=\"Hotel\"]")).click();
            //6. Arama kutusuna Seychelles yaz.
            //7. 2022 yazı için 2 haftalık bir tarih aralığı seç.
            //8. 2 yetişkin seç.
            Thread.sleep(3000);
            Actions action=new Actions(Driver.getDriver());
            action.click(Driver.getDriver().findElement(By.xpath("//input[@type=\"search\"]"))).sendKeys("Seychelles").sendKeys(Keys.TAB).perform();
            action.click(Driver.getDriver().findElement(By.xpath("//span[@data-testid=\"checkin-calendar-subline\"]")))
            .sendKeys("20220617").sendKeys(Keys.ENTER).sendKeys("20220630").click().perform();
            Thread.sleep(3000);
            Driver.getClose();

            //9. Search'e tıkla.
        }
        @Test
        public void test4() {
            //13. Resimlerin altta göründüğünü doğrula.
            //14. En üstteki sonucun adının ve yıldızlarının altında konumu yazıyor, tıkla.
            //15. Sağ taraftaki haritada otel işaretlenecek. Haritayı locate et.
        }
        @Test
        public void test5() {
            //16. Hoteli haritada drag & drop yaparak ortala, + tuşuyla zoom yap
        }

    }


