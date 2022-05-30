package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMoly {
    public HotelMoly(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//input[@id=\"UserName\"]")
    public WebElement username;
    @FindBy(xpath = "//input[@id=\"Password\"]")
    public WebElement password;
    @FindBy(xpath = "//input[@id=\"btnSubmit\"]")
    public WebElement submit;
    @FindBy(linkText = "Log in")
    public WebElement logIn;
    @FindBy(xpath = "//span[@class=\"caption-subject font-green-sharp bold uppercase\"]")
    public WebElement successLogin;


}
