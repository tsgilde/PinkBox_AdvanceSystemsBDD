package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeSteps implements CommonPage {
    HomePage page;
    
    public HomeSteps() {
        page = new HomePage();
       }
    @Given("I open url to homepage")
    public void iOpenUrlOfHomepage() {
        BrowserUtils.getDriver();
    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, button)))
        );
    }

    @When("I click on language button")
    public void iClickOnLanguageButton() {
        page.languageBtn.click();
    }

    @Then("I should see {string} in dropdown menu")
    public void iShouldSeeInDropdownMenu(String language) {
        List<String> temp = new ArrayList<>();
        for (WebElement each : page.languages) {
            temp.add(each.getText());
        }
        Assert.assertTrue(temp.contains(language));
    }
}
