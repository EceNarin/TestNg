package Elf;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class DependsOn {
    @Test
    public void facebook() {
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
         /*
    birbirine bagimli testler olusturun..
    .beforClass olusturup setUp ayarlarini yapin..
      birbirine bagimli testler olusturarak;
          ilk once facebook a gidin
          sonra facebook a bagimli olarak google a gidin,
          daha sonra google a bagimli olarak amazon a gidin
    driver i kapatin
 */
    }

    @Test(dependsOnMethods = "google")
    public void amazon() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Test(dependsOnMethods = "facebook")
    public void google() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }

}
