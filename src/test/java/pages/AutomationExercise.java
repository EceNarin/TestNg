package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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
    @FindBy(xpath = "//ul[@class=\"nav nav-pills nav-justified\"]//a")
    public List<WebElement> allProducts;
    @FindBy (xpath = "//a[@href=\"/product_details/1\"]")
    public WebElement viewProductButton;
    @FindBy (xpath = "//a[@href=\"/view_cart\"]")
    public WebElement viewButtonCart;
    //(//a[@href="/view_cart"])[2]
    //(//a[@href="/login"])[1]
    @FindBy(xpath = "(//a[@href=\"/login\"])[1]")
    public WebElement signInSignUp;
    @FindBy(xpath = "//a[@data-product-id=\"1\"]")
    public WebElement buttonAddToCart;
    @FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]//li[5]/a")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//input[@name=\"name\"]")
    public WebElement newUserName;
    @FindBy(xpath = "//button[@data-dismiss=\"modal\"]")
    public  WebElement continueShop;
    @FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]//li[9]/a/b")
    public WebElement visibleTopNameAsUser;
    @FindBy (xpath = "//input[@min=\"1\"]")
    public WebElement quantityButton;
    @FindBy
    public WebElement productByIndex;
    @FindBy
    public WebElement productDetailsByIndex;
    public WebElement choiceProductChartByIndex(int x){

        return productByIndex=Driver.getDriver().findElement(By.xpath("(//a[@data-product-id=\""+x+"\"])[1]"));
    }
    public WebElement choiceProductDetailsByIndex(int x){

        return productDetailsByIndex=Driver.getDriver().findElement(By.xpath("//a[@href='/product_details/"+x+"']"));
    }

}
