package step_definitions;

import io.cucumber.java.en.Then;
import pages.OthersPage;
import utils.BrowserUtils;

public class OthersSteps {
    OthersPage page;

    public OthersSteps(){

        page = new OthersPage();
    }

    @Then("Verify buttons is disabled")
    public void verify_buttons_is_disabled() {

        BrowserUtils.assertTrue(BrowserUtils.isDisabled(page.statusBtn));
    }
}

