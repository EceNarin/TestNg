package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercise {
    public AutomationExercise(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h1")
    public WebElement homePage;
    @FindBy(xpath = "(//a[@href=\"/test_cases\"])[1]")
    public WebElement testCaseButton;
    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public WebElement visibleTestText;
    @FindBy (xpath = "//a[@href=\"/products\"]")
    public WebElement productButton;
    //u can change change by number
    @FindBy (xpath = "//a[@href=\"/product_details/1\"]")
    public WebElement viewProductButton;
    @FindBy
    public WebElement jc;

}
