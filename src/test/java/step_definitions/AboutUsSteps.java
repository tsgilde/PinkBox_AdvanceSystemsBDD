package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutUsPage;
import pages.CommonPage;
import utils.BrowserUtils;

public class AboutUsSteps implements CommonPage {
    AboutUsPage page;
    WebDriverWait wait;

    public AboutUsSteps() {

        page = new AboutUsPage();
    }

    @Then("Verify the section should have four headers with description {string}")
    public void verifyTheSectionShouldHaveFourHeadersWithDescription(String text) {

        BrowserUtils.waitForPageLoad();

        BrowserUtils.waitForElementVisibility(page.aboutUs);

        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))
                )
        );

    }
}
