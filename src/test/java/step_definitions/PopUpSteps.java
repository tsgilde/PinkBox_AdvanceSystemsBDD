package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PopUpPage;
import utils.BrowserUtils;

public class PopUpSteps {
    PopUpPage page;

    public PopUpSteps(){
        page = new PopUpPage();
    }

    @And("I click a button Message")
    public void iClickAButtonMessage() {
        BrowserUtils.click(page.messageBtn);
    }

    @Then("Verify header New Message is displayed")
    public void verifyHeaderNewMessageIsDisplayed() {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.headerNewMsg), "New message");
    }

    @And("I click a button BMI Calculator")
    public void iClickAButtonBMICalculator() {
        BrowserUtils.click(page.bmiCalcBtn);
    }

    @Then("Verify header BMI Calculator is displayed")
    public void verifyHeaderBMICalculatorIsDisplayed() {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.headerBMICalc), "BMI Calculator");
    }
}
