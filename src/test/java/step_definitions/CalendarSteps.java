package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CalendarPage;
import pages.CommonPage;
import utils.BrowserUtils;

public class CalendarSteps implements CommonPage {
    CalendarPage page;

    public CalendarSteps(){
        this.page = new CalendarPage();
    }

    @When("I click a button endDateInput")
    public void i_click_a_button_end_date_input() {
        BrowserUtils.click(page.endDateInput);
    }

    @When("I click a button endDateCalendar")
    public void i_click_a_button_end_date_calendar() {
        BrowserUtils.click(page.endDateCalendar);
    }

    @When("I click a button Submit")
    public void i_click_a_button_submit() {
        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_BUTTON, "Submit")))
        );
    }

    @Then("text will display {int} day difference")
    public void textWillDisplayDayDifference(Integer int1) {
        String startDate = page.startDateTxt.getAttribute("value");
        String endDate = page.endDateTxt.getAttribute("value");

        if(startDate.charAt(0) == '0')
            startDate = startDate.substring(1);

        if(endDate.charAt(0) == '0')
            endDate = endDate.substring(1);

        String expectedTxt = "There are 1 days between " + startDate + " and " + endDate + "";
        String actualTxt = BrowserUtils.getText(page.numberOfDaysTxt);

        BrowserUtils.assertEquals(expectedTxt, actualTxt);
    }
}
