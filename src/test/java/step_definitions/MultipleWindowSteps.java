package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.MultipleWindowPage;
import utils.BrowserUtils;

import java.util.List;

public class MultipleWindowSteps implements CommonPage {

    MultipleWindowPage page;

    public MultipleWindowSteps(){

        page = new MultipleWindowPage();
    }

//    @Then("Verify Launch TLA button is enabled")
//    public void verifyLaunchTLAButtonIsEnabled() {
//        BrowserUtils.isEnabled(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch TLA")))
//        );
//    }
//
//    @Then("Verify Launch Google button is enabled")
//    public void verifyLaunchGoogleButtonIsEnabled() {
//        BrowserUtils.isEnabled(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch Google")))
//        );
//    }
//
//    @Then("Verify Launch Facebook button is enabled")
//    public void verifyLaunchFacebookButtonIsEnabled() {
//        BrowserUtils.isEnabled(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Launch Facebook")))
//        );
//    }


    @Then("Verify {string} button is enabled")
    public void verifyButtonIsEnabled(String buttonName) {
        BrowserUtils.isEnabled(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, buttonName)))
        );
    }


    @Then("Verify link text {string} is displayed")
    public void verifyLinkTextIsDisplayed(String buttonName) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(By.xpath(
                        String.format(XPATH_TEMPLATE_LINKTEXT, buttonName)
                ))
        );
    }

    @Then("Verify following link texts are displayed:")
    public void verifyFollowingLinkTextsAreDisplayed(List<String> data) {
        for(String each: data){
            BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(By.xpath(
                            String.format(XPATH_TEMPLATE_LINKTEXT, each)
                    ))
            );
        }
    }
}