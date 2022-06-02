package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueCar {
        public BlueCar(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//a[@href=\"/login\"]")
        public WebElement login;

        @FindBy(xpath = "//input[@name=\"email\"]")
        public WebElement userMail;

        @FindBy(xpath = "//input[@name=\"password\"]")
        public WebElement password;

        @FindBy(xpath = "//button[@type=\"submit\"]")
        public WebElement submit;
        @FindBy(id = "dropdown-basic-button")
        public WebElement succesLogin;

        @FindBy (linkText = "Create new user")
        public WebElement createNewUser;

        @FindBy(xpath = "//input[@name=\"firstName\"]")
        public WebElement firstName;

    }


