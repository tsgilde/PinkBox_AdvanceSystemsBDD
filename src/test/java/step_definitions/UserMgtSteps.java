package step_definitions;

import io.cucumber.java.en.Then;
import pages.UserMgtPage;
import utils.BrowserUtils;

public class UserMgtSteps {
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
}
