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

    @When("I verify the home page is display the contact info")
    public void iVerifyTheHomePageIsDisplayTheContactInfo() {
        List<WebElement> each = BrowserUtils.getDriver().findElements(By.xpath("//div[@class=\"info-box-one\"]"));
        for(WebElement list : each){
            BrowserUtils.isDisplayed(list);
            System.out.println(list.getText());
        }
    }

    @Then("Verify header text is {string}")
    public void verifyHeaderTextIs(String url) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), url);
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

    @Then("I verify {string}  section is displayed")
    public void iVerifySectionIsDisplayed(String header) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT, header))
                )
        );
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
    @Then("Verify company names is displayed in {int} row.")
    public void verifyCompanyNamesIsDisplayedInRow(int arg0) {
        BrowserUtils.isDisplayed(page.companyNames);
    }
}


