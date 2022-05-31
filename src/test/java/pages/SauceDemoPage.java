package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {
    public SauceDemoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@placeholder=\"Username\"]")
    public WebElement demoUsername;
    @FindBy(xpath = "//input[@placeholder=\"Password\"]")
    public WebElement demoPassword;
    @FindBy(xpath = "//input[@id=\"login-button\"]")
    public WebElement login;
    @FindBy(xpath = "//span[@class=\"title\"]")
    public WebElement verify;
}
