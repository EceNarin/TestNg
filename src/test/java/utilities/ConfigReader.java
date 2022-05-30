package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
   static Properties properties;

   // static blok wiil work first
    static {
        String filePath="configration.properties";
        try {
            FileInputStream fis=new FileInputStream(filePath);
            properties=new Properties();
            //filePath ile fileoutputstream'e attigimiz dosya okundu
            properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
        } /*catch (FileNotFoundException e) {
            throw new RuntimeException(e); //IO exception is enough
        }*/ catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}
