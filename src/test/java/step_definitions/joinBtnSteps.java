package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.joinBtnPage;
import utils.BrowserUtils;

public class joinBtnSteps implements CommonPage {
    joinBtnPage page;

    public joinBtnSteps() {
        page = new joinBtnPage();
    }

    @Then("I verify the button is displayed {string}")
    public void iVerifyTheButtonIsDisplayed(String jnBtn) {
        BrowserUtils.isDisplayed(page.jnBtn);
    }

    @Then("I click the button {string}")
    public void iClickTheButton(String jnBtn) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_TEXT, jnBtn))
        ));

    }

    @And("I verify if it took me to {string} page")
    public void iVerifyIfItTookMeToPage(String jsBtn) {
        BrowserUtils.isDisplayed(page.jsBtn);

    }
}
