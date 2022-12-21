package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.ContactUsPage;
import utils.BrowserUtils;

import java.util.List;

public class ContactUsSteps implements CommonPage {
    ContactUsPage page;

    public ContactUsSteps(){

        page = new ContactUsPage();
    }
    @Then("Verify following input fields are displayed:")
    public void verifyFollowingInputFieldsAreDisplayed(List<String> dataTable) {
        BrowserUtils.waitForPageLoad();
        for(String each: dataTable){
            if (each.equals("Choose Service")) {
                BrowserUtils.isDisplayed(page.chooseService);
            } else if (each.equals("Your Message...")) {
                BrowserUtils.isDisplayed(
                        BrowserUtils.getDriver().findElement(
                                By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD2, each))));
            } else {
                BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(
                            By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, each))));
            }
        }
    }

    @Then("I verify {string} button is displayed")
    public void iVerifyButtonIsDisplayed(String button) {
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_BUTTON, button))));
    }
}
