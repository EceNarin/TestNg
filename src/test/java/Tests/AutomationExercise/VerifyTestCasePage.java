package Tests.AutomationExercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class VerifyTestCasePage {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        AutomationExercise auto=new AutomationExercise();
        Assert.assertTrue(auto.homePage.isDisplayed());
        //4. Click on 'Test Cases' button
        auto.testCaseButton.click();
        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(auto.visibleTestText.isDisplayed());
        boolean isNavigate= Driver.getDriver().getCurrentUrl().contains("test_cases");
        Assert.assertTrue(isNavigate);
        Driver.getClose();
    }
}
