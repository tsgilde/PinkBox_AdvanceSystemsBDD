package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.UserMgtPage;
import utils.BrowserUtils;

public class UserMgtSteps implements CommonPage {
    UserMgtPage page;

    public UserMgtSteps(){

        page = new UserMgtPage();
    }

    @Then("Verify title of the page is Register New User")
    public void verifyTitleOfThePageIsRegisterNewUser() {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(),
                "Register New User");
    }

    @Then("Verify Login button is present")
    public void verifyLoginButtonIsPresent() {

        BrowserUtils.assertTrue(BrowserUtils.isEnabled(page.loginBtn));
    }

    @Then("Verify First Name input field is displayed")
    public void verifyFirstNameInputFieldIsDisplayed() {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "First Name")))
        );
    }

    @Then("Verify Last Name input field is displayed")
    public void verifyLastNameInputFieldIsDisplayed() {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "Last Name")))
        );
    }

    @Then("Verify Phone Number input field is displayed")
    public void verifyPhoneNumberInputFieldIsDisplayed() {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "Phone Number")))
        );
    }

    @Then("Verify E-mail input field is displayed")
    public void verifyEMailInputFieldIsDisplayed() {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "E-mail")))
        );
    }
}
