package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BrowserUtils;

import java.util.List;

public class ContactInfoSteps {

    @When("I verify the home page is display the contact info")
    public void iVerifyTheHomePageIsDisplayTheContactInfo() {
        List<WebElement> each = BrowserUtils.getDriver().findElements(By.xpath("//div[@class=\"info-box-one\"]"));
        for(WebElement list : each){
            BrowserUtils.isDisplayed(list);
            System.out.println(list.getText());
        }
    }

    @Given("I open home page url of home steps")
    public void iOpenHomePageUrlOfHomeSteps() {
        BrowserUtils.getDriver();
    }
}
