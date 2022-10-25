package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.UserMgtPage;
import utils.BrowserUtils;

import java.util.List;
import java.util.Map;

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

//    @Then("Verify First Name input field is displayed")
//    public void verifyFirstNameInputFieldIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "First Name")))
//        );
//    }
//
//    @Then("Verify Last Name input field is displayed")
//    public void verifyLastNameInputFieldIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "Last Name")))
//        );
//    }
//
//    @Then("Verify Phone Number input field is displayed")
//    public void verifyPhoneNumberInputFieldIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "Phone Number")))
//        );
//    }
//
//    @Then("Verify E-mail input field is displayed")
//    public void verifyEMailInputFieldIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, "E-mail")))
//        );
//    }

    @Then("Verify {string} input field is displayed")
    public void verifyInputFieldIsDisplayed(String inputField) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, inputField)))
        );
    }

    @Then("Verify following input fields are displayed:")
    public void verify_following_input_fields_are_displayed(List<String> dataTable) {
        for(String each: dataTable){
            BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(
                            By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, each))
                    )
            );
        }
    }

    @When("I fill out user registration form with following info:")
    public void iFillOutUserRegistrationFormWithFollowingInfo(Map<String, String> map) {
        for(String key: map.keySet()){
            if (key.equalsIgnoreCase("role")){
                BrowserUtils.selectByVisibleText(page.selectRole, map.get(key));
            }else {
                BrowserUtils.sendKeys(BrowserUtils.getDriver().findElement(By.xpath(
                        String.format(XPATH_TEMPLATE_INPUT_FIELD, key)
                )), map.get(key));
            }
        }
    }
}
