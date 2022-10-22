package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.MultipleWindowPage;
import pages.UserMgtPage;
import utils.BrowserUtils;

public class MultipleWindowSteps implements CommonPage {

    MultipleWindowPage page;

    public MultipleWindowSteps(){

        page = new MultipleWindowPage();
    }

    @When("I click a button Multiple-window")
    public void iClickAButtonMultipleWindow() {
        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Multiple-window")))
        );
    }

    @Then("Verify Launch TLA button is enabled")
    public void verifyLaunchTLAButtonIsEnabled() {
        BrowserUtils.isEnabled(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch TLA")))
        );
    }

    @Then("Verify Launch Google button is enabled")
    public void verifyLaunchGoogleButtonIsEnabled() {
        BrowserUtils.isEnabled(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch Google")))
        );
    }

    @Then("Verify Launch Facebook button is enabled")
    public void verifyLaunchFacebookButtonIsEnabled() {
        BrowserUtils.isEnabled(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch Facebook")))
        );
    }


}
