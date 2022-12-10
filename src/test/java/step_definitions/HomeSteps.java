package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomeSteps implements CommonPage {
    HomePage page;
    WebDriverWait wait;
    
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
    @Then("Verify header text is {string} is displayed")
    public void verifyHeaderTextIsIsDisplayed(String text) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT, text)))
        );
    }

    @Then("Verify that each testimonial has message displayed")
    public void verifyThatEachTestimonialHasMessageDisplayed() {
        Map<String, String> nameAndText = new LinkedHashMap<>();
        String currentName = "";
        String currentText = "";

        wait = new WebDriverWait(BrowserUtils.getDriver(), 10);

        try {
            while (nameAndText.size() < page.listOfName.size()) {
                if (nameAndText.containsKey(currentName)) {
                    page.next_nav.click();
                }

                wait.until(ExpectedConditions.visibilityOf(page.activeText));
                currentName = page.activeName.getText();
                currentText = page.activeText.getText();

                if (!nameAndText.containsKey(currentName)) {
                    nameAndText.put(currentName, currentText);
                }
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (String ea : nameAndText.keySet()) {
            Assert.assertTrue(!nameAndText.get(ea).isEmpty());
        }
    }

    @Then("Verify social media button {string} is displayed")
    public void verifySocialMediaButtonIsDisplayed(String button) {
        String link = BrowserUtils.getDriver().findElement(By.xpath(
                String.format(page.socialMediaBtn, button.toLowerCase()))).getAttribute("href");

        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(page.socialMediaBtn, button.toLowerCase()))));

        BrowserUtils.assertTrue(link.contains(button.toLowerCase()));

    }

}


