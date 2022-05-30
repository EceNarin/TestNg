package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPages {
    public FaceBookPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@class=\"inputtext _55r1 _6luy\"]")
    public WebElement emailBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitLogin;
    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement passwordBox;


    }

