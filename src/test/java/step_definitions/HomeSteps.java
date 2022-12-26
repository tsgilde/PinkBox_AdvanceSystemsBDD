package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (WebElement list : each) {
            BrowserUtils.isDisplayed(list);
            System.out.println(list.getText());

        }
    }

    @Then("Verify Header is displayed")
    public void verifyHeaderIsDisplayed() {
        BrowserUtils.isDisplayed(page.careerHeader);
        System.out.println(page.careerHeader.getText());

        wait = new WebDriverWait(BrowserUtils.getDriver(), 15);
        BrowserUtils.isDisplayed(page.thinkBigHeader);
        System.out.println(page.thinkBigHeader.getText());

    }

    @Then("Verify description is displayed")
    public void verify_description_is_displayed() {

        BrowserUtils.isDisplayed(page.thinkBigDescription);
        System.out.println(page.thinkBigDescription.getText());

        BrowserUtils.isDisplayed(page.careerDescription);
        System.out.println(page.careerDescription.getText());

    }

    @Then("Verify if page refresh every {int}{int} seconds")
    public void verifyIfPageRefreshEverySeconds(int arg0, int arg1) {

        BrowserUtils.waitForElementVisibility(page.thinkBigHeader);
        BrowserUtils.isDisplayed(page.thinkBigHeader);

    }

    @Then("User clicks READ MORE button and Verify services page is opened")
    public void userClicksREADMOREButtonAndVerifyServicesPageIsOpened() {

        if (page.readMoreBtn.isDisplayed()) {
            page.readMoreBtn.click();
        } else {
            try {
                Thread.sleep(2000);
                page.readMoreBtn.click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(BrowserUtils.getDriver().getTitle().contains("Services"));
    }
    @Then("Verify header text is {string}")
    public void verifyHeaderTextIs(String url) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), url);
    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, button)))
        );
    }

    @When("I click on language button")
    public void iClickOnLanguageButton() {
        page.languageBtn.click();
    }

    @Then("Verify {string} selection is displayed")
    public void verifySelectionIsDisplayed(String arg0) {

        for (WebElement each : page.languages) {
            BrowserUtils.isDisplayed(each);
            System.out.println(each.getText());
        }
    }
    @Then("I verify {string}  section is displayed")
    public void iVerifySectionIsDisplayed(String header) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BrowserUtils.isDisplayed(page.companyNames);
    }

    @Then("Verify header text is {string} is displayed")
    public void verifyHeaderTextIsIsDisplayed(String text) {
        BrowserUtils.moveIntoView(page.section);

        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT, text)))
        );
    }

    @Then("Verify that each testimonial has message displayed")
    public void verifyThatEachTestimonialHasMessageDisplayed() {
        BrowserUtils.moveIntoView(page.testimonials);

        Map<String, String> nameAndText = new LinkedHashMap<>();
        String currentName = "";
        String currentText = "";

        wait = new WebDriverWait(BrowserUtils.getDriver(), 10);

        try {
            while (nameAndText.size() < page.listOfName.size()) {
                if (nameAndText.containsKey(currentName)) {
                    page.next_nav.click();
                }

                wait.until(ExpectedConditions.visibilityOf(page.activeName));
                wait.until(ExpectedConditions.visibilityOf(page.activeText));

                currentName = page.activeName.getText();
                currentText = page.activeText.getText();

                if (!nameAndText.containsKey(currentName)) {
                    System.out.println(currentName);
                    System.out.println(currentText);
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

    @When("I click a {string} button")
    public void iClickAButton(String button) {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_HREF_CONTAINS, button))));
    }

    @Then("It should take me to corresponding page. {string}")
    public void itShouldTakeMeToCorrespondingPage(String socialMedia) {
        BrowserUtils.switchToNewWindow();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BrowserUtils.assertEquals(BrowserUtils.getDriver().findElement(
                By.xpath("//meta[@property='og:site_name']")).getAttribute("content"), socialMedia);
    }

    @When("Verify {string} info is displayed in the footer section:")
    public void verifyInfoIsDisplayedInTheFooterSection(String text) {
        try {
            String contact = BrowserUtils.getDriver().findElement(By.xpath(
                    String.format(page.footerContact, text))).getText();
            Thread.sleep(6000);

            BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                    String.format(page.footerContact, text))));

            BrowserUtils.assertTrue(contact.contains(text));


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("I verify the button is displayed {string}")
    public void iVerifyTheButtonIsDisplayed(String jnBtn) {
        BrowserUtils.isDisplayed(page.jnBtn);
    }

    @Then("I click the button {string}")
    public void iClickTheButton(String jnBtn) {
        try {
            Thread.sleep(6000);

            BrowserUtils.click(BrowserUtils.getDriver().findElement(
                    By.xpath(String.format(XPATH_TEMPLATE_TEXT, jnBtn))
            ));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("I verify if it took me to {string} page")
    public void iVerifyIfItTookMeToPage(String jsBtn) {
        BrowserUtils.isDisplayed(page.jsBtn);

    }

    @Then("Verify social media button {string} is displayed")
    public void verifySocialMediaButtonIsDisplayed(String button) {
        String link = BrowserUtils.getDriver().findElement(By.xpath(
                String.format(page.socialMediaBtn, button.toLowerCase()))).getAttribute("href");

        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(page.socialMediaBtn, button.toLowerCase()))));

        BrowserUtils.assertTrue(link.contains(button.toLowerCase()));

    }

    @When("I scroll down the home page I verify navigation options are displayed")
    public void iScrollDownTheHomePageIVerifyNavigationOptionsAreDisplayed() {
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(page.footerCopyright);
        BrowserUtils.isDisplayed((page.mainMenu));
    }

    @When("I click the navigation {string}")
    public void iClickTheNavigation(String button) {
        BrowserUtils.waitForPageLoad();
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_OPTION_TEXT, button))));
    }

    @Then("I verify {string}  field is displayed")
    public void iVerifyFieldIsDisplayed(String email) {
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, email)))
        );
    }

    @Then("I verify the text header {string} in the Expert section")
    public void iVerifyTheTextHeaderInTheExpertSection(String text) {
        try {
            Thread.sleep(6000);
            BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(
                            By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("It should take me to the page {string}")
    public void itShouldTakeMeToThePage(String text) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), text);
    }

    @Then("I verify the text header {string}")
    public void iVerifyTheTextHeader(String text) {
        try {
            Thread.sleep(6000);
            BrowserUtils.isDisplayed(
                    BrowserUtils.getDriver().findElement(
                            By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("I verify the name and title are displayed")
    public void iVerifyTheNameAndTitleAreDisplayed() {
        try {
            Thread.sleep(6000);
            BrowserUtils.isDisplayed(page.title);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Verify header text {string} is displayed")
    public void verifyHeaderTextIsDisplayed(String text) {

        BrowserUtils.moveIntoView(page.thinkBigHeader);
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))));

    }

    @Then("Verify second header text is {string} is displayed")
    public void verifySecondHeaderTextIsIsDisplayed(String text) {
        BrowserUtils.moveIntoView(page.thinkBigHeader);
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_TEXT, text))));
        BrowserUtils.waitForPageLoad();
        BrowserUtils.moveIntoView(page.thinkBigHeader);
    }

    @And("Verify description text should be displayed under header")
    public void verifyDescriptionTextShouldBeDisplayedUnderHeader() {
        BrowserUtils.moveIntoView(page.thinkBigHeader);
        BrowserUtils.waitForPageLoad();
        BrowserUtils.isDisplayed(page.headerDescription);

        System.out.println(page.headerDescription.getText());
    }

    @When("I scroll down to the bottom part of the page")
    public void iScrollDownToTheBottomPartOfThePage() {
        BrowserUtils.moveIntoView(page.scrollTo);
        BrowserUtils.waitForPageLoad();
    }

    @And("I see the button at the bottom right corner of the page")
    public void iSeeTheButtonAtTheBottomRightCornerOfThePage() {
        BrowserUtils.waitForElementVisibility(page.upArrowBtn);
        Assert.assertTrue(page.upArrowBtn.isDisplayed());
    }

    @When("I click the bottom right corner")
    public void iClickTheBottomRightCorner() {
        BrowserUtils.waitForElementVisibility(page.upArrowBtn);

        wait = new WebDriverWait(BrowserUtils.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(page.upArrowBtn));

        System.out.println("====Up Arrow Button====");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BrowserUtils.actionsClick(page.upArrowBtn);
    }

    @Then("I should see the window move to the top and the button should disappear")
    public void iShouldSeeTheWindowMoveToTheTopAndTheButtonShouldDisappear() {

        Assert.assertTrue(!page.upArrowBtn.isDisplayed());
    }


    @Then("I verify if bottom is updated {string}")
    public void iVerifyIfBottomIsUpdated(String text) {
        BrowserUtils.assertEquals(text, "Copyright  © 2022 Advance Systems LLC. All Rights Reserved.");
        }

    }



