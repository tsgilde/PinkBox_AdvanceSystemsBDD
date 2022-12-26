package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutUsPage;
import pages.CommonPage;
import utils.BrowserUtils;

import java.util.List;

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

    @Then("I verify if {string} is display")
    public void iVerifyIfIsDisplay(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, txt))));
    }

    @Then("I verify if subtitle {string},{string},{string} is displayed")
    public void iVerifyIfSubtitleIsDisplayed(String arg0, String arg1, String arg2) {
        BrowserUtils.isDisplayed(page.OnTimeText);
        BrowserUtils.isDisplayed(page.TeamText);
        BrowserUtils.isDisplayed(page.GoodText);

    }

    @Then("Verify header {string} is displayed")
    public void verifyHeaderIsDisplayed(String text) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))));
    }

    @Then("Verify picture of each employee is displayed")
    public void verifyPictureOfEachEmployeeIsDisplayed() {
        for(WebElement eachImg : page.teamPicture){
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BrowserUtils.isDisplayed(eachImg);
        }
    }

    @Then("Verify title of each employee is displayed")
    public void verifyTitleOfEachEmployeeIsDisplayed() {
        for(WebElement eachTitle : page.teamTittle){
            BrowserUtils.isDisplayed(eachTitle);
        }
    }

    @Then("Verify quote of each employee is displayed")
    public void verifyQuoteOfEachEmployeeIsDisplayed() {
        for(WebElement eachQuote : page.teamQuote){
            BrowserUtils.isDisplayed(eachQuote);
        }
    }

    @And("Verify social media button of each employee is displayed")
    public void verifySocialMediaButtonOfEachEmployeeIsDisplayed(List<String> list) {
        for (int i = 1; i <= page.teamSocialMedia.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    try {
                        Thread.sleep(9000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath
                            (String.format(page.socialBtn, i ,list.get(j).toLowerCase()))));
                }
        }
    }

    @When("I click a social {string} button")
    public void iClickASocialButton(String button) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath
                        (String.format(page.socialLink, button.toLowerCase()))));

    }

    @Then("Social media buttons should take to corresponding page {string}")
    public void socialMediaButtonsShouldTakeToCorrespondingPage(String socialMedia) {
        System.out.println(socialMedia);
        BrowserUtils.switchToNewWindow();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(!socialMedia.equals("Skype")){
            Assert.assertTrue(BrowserUtils.getDriver().findElement(By.xpath
                    ("//meta[@property='og:site_name']")).getAttribute("content").contains(socialMedia));
        } else {
            Assert.assertTrue(BrowserUtils.getDriver().findElement(By.xpath
                    ("//meta[@property='og:title']")).getAttribute("content").contains(socialMedia));
        }
    }
}
