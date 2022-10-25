package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.InputsPage;
import utils.BrowserUtils;

import java.util.Map;

public class InputsSteps implements CommonPage {
    InputsPage page;

    public InputsSteps(){
        page = new InputsPage();
    }

    @When("I fill out contact us form with following details:")
    public void iFillOutContactUsFormWithFollowingDetails(Map<String, String> map) {
        for(String key: map.keySet()){
            if (key.equalsIgnoreCase("state")){
                BrowserUtils.selectByVisibleText(page.selectState,map.get(key));
            }else{
                BrowserUtils.sendKeys(
                        BrowserUtils.getDriver().findElement(By.name(key)), map.get(key)
                );
            }
        }

    }

    @Then("Verify text {string} is displayed")
    public void verifyTextIsDisplayed(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, txt)
        )));
    }
}
