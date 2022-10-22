package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;
import utils.BrowserUtils;

public class HomeSteps implements CommonPage {
    HomePage page;
    CalendarPage calendarPage;
    MultipleWindowPage multipleWindowPage;
    OthersPage othersPage;
    PopUpPage popUpPage;
    UserMgtPage userMgtPage;


    public HomeSteps() {
        page = new HomePage();
        calendarPage = new CalendarPage();
        multipleWindowPage = new MultipleWindowPage();
        othersPage = new OthersPage();
        popUpPage = new PopUpPage();
        userMgtPage = new UserMgtPage();
    }

    @Given("I open url of homepage")
    public void iOpenUrlOfHomepage() {
        BrowserUtils.getDriver();
    }

    @Then("Verify header text is {string}")
    public void verifyHeaderTextIs(String headerTxt) {
        WebElement element = null;

        switch (headerTxt.toLowerCase()) {
            case "Automation with Selenium": element = page.headerTitle;
            break;
            default:
                System.out.println("WebElement is not defined");
        }
        BrowserUtils.assertEquals(element.getText(), headerTxt);
    }

//    @Then("Verify header text is Automation with Selenium")
//    public void verify_header_text_is_automation_with_selenium() {
//        BrowserUtils.assertEquals(page.headerTitle.getText(), "Automation with Selenium");
//    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, button)))
        );
    }

//    @Then("Verify button Home is displayed")
//    public void verify_button_home_is_displayed() {
//        //BrowserUtils.isEnabled(page.homeLinkText);
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Home")))
//        );
//    }
//
//    @Then("Verify button Calendar is displayed")
//    public void verify_button_calendar_is_displayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Calendar")))
//        );
//    }
//
//    @Then("Verify button UserMgt is displayed")
//    public void verify_button_user_mgt_is_displayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "User-Mgt")))
//        );    }
//
//    @Then("Verify button Others is displayed")
//    public void verify_button_others_is_displayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Others")))
//        );    }
//
//    @Then("Verify button Tables is displayed")
//    public void verifyButtonTablesIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Tables")))
//        );    }
//
//    @Then("Verify button Synchronization is displayed")
//    public void verifyButtonSynchronizationIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Synchronization")))
//        );    }
//
//    @Then("Verify button iFrames is displayed")
//    public void verifyButtonIFramesIsDisplayed() {
//        BrowserUtils.isDisplayed(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "iFrames")))
//        );    }
//
//    @When("I click a button Others")
//    public void i_click_a_button_others() {
//        BrowserUtils.click(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Others")))
//        );
//    }
//
//    @When("I click a button Calendar")
//    public void i_click_a_button_calendar() {
//        BrowserUtils.click(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Calendar")))
//        );
//    }
//
//    @When("I click a button User-Mgt")
//    public void iClickAButtonUserMgt() {
//        BrowserUtils.click(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "User-Mgt")))
//        );
//    }
//
//    @When("I click a button Pop-Up")
//    public void iClickAButtonPopUp() {
//        BrowserUtils.click(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Pop-Up")))
//        );
//    }
//
//    @When("I click a button Multiple-Window")
//    public void iClickAButtonMultipleWindow() {
//        BrowserUtils.click(
//                BrowserUtils.getDriver().findElement(
//                        By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, "Multiple-window")))
//        );
//    }

    //TODO: Update link text related steps with this new step
    @Then("Verify link text Home is displayed")
    public void verifyLinkTextHomeIsDisplayed() {

    }

    @When("I click a button {string}")
    public void iClickAButton(String button) {
        switch (button.toLowerCase()) {
            case "enddateinput":
                BrowserUtils.click(calendarPage.endDateInput);
                break;
            case "enddatecalendar":
                BrowserUtils.click(calendarPage.endDateCalendar);
                break;
            case "message":
                BrowserUtils.click(popUpPage.messageBtn);
                break;
            case "bmi calculator":
                BrowserUtils.click(popUpPage.bmiCalcBtn);
                break;
            default:
                BrowserUtils.click(BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_BUTTON, button))));
        }
    }

    @When("I click nav button {string}")
    public void iClickNavButton(String button) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, button))));
    }
}

