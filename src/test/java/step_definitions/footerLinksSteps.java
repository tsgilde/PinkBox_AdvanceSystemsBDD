package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.footerLinksPage;
import utils.BrowserUtils;

public class footerLinksSteps {
    footerLinksPage page;

    public footerLinksSteps(){
        page = new footerLinksPage();
    }

    @Then("Then Verify following input fields are displayed:")
    public void thenVerifyFollowingInputFieldsAreDisplayed() {
        BrowserUtils.isDisplayed(page.socialMediabtn);



    }

    @When("I click link text {string}")
    public void iClickLinkText(String linkText) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.linkText(linkText)));
    }

    @Then("Verify destination window has url as {string}")
    public void verifyDestinationWindowHasUrlAs(String URL) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
    }
}
