package SeleniumForthWeeks.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HardTask {
    @Test
    public void test() {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        List<WebElement> allProducts= Driver.getDriver().findElements(By.xpath("//div[@class=\"sc-uhudcz-0 iZZGui\"]/div"));
        allProducts.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println(allProducts.size());
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(allProducts.size()==16);
        AtomicInteger i= new AtomicInteger();
        allProducts.stream().forEach(t-> System.out.println( (i.getAndIncrement() +1) +". urun \n" +t.getText() ));
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> productFields=new ArrayList<>();
        List<WebElement> proFi=Driver.getDriver().findElements(By.xpath("//*[@id=\"root\"]/div/main/main/div/div/p"));
        productFields.addAll(proFi.stream().map(t->t.getText()).collect(Collectors.toList()));
        AtomicInteger k= new AtomicInteger();
        productFields.stream().forEach(t-> System.out.println(k.getAndIncrement()+1 +". urun " + t));
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        List<WebElement> randomAddChart=Driver.getDriver().findElements(By.xpath("//button[@class=\"sc-124al1g-0 jCsgpZ\"]\n"));
        List<WebElement> elements=new ArrayList<>();
        int size= randomAddChart.size();
        Random rnd=new Random();
        double subTotal=0.0;
        while(elements.size()!=5){
             int num= rnd.nextInt(size);
            if(elements.contains(randomAddChart.get(num))){
               continue;
            }else{
                randomAddChart.get(num).click();
                elements.add(randomAddChart.get(num));
                String str=Driver.getDriver().findElements(By.xpath("//p[@class=\"sc-124al1g-6 ljgnQL\"]")).get(num).getText();
                double proPrice=Double.parseDouble(str.replaceAll("\\$","").trim());
                subTotal+=proPrice;
                elements.stream().forEach(t-> System.out.println("All choices are : "+ t));
            }
        }
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        System.out.println("All chart price : "+subTotal);

        String actualPriceS=Driver.getDriver().findElement(By.xpath("//p[@class=\"sc-1h98xa9-9 jzywDV\"]")).getText();
        double actualPrice=Double.parseDouble(actualPriceS.replaceAll("\\$","").trim());
        System.out.println(actualPrice);
        soft.assertTrue(subTotal==actualPrice);
        soft.assertAll();
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        System.out.println("Test Passed");
        // 7.Checkout'a tıklayın
        Driver.getDriver().findElement(By.xpath("//button[@class=\"sc-1h98xa9-11 gnXVNU\"]")).click();
        Driver.getDriver().switchTo().alert().accept();
        Driver.getClose();
    }
}
