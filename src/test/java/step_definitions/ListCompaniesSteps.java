package step_definitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ListCompaniesPage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class ListCompaniesSteps {
    ListCompaniesPage page;
    public ListCompaniesSteps(){
        page = new ListCompaniesPage();
    }

    @When("I verify the list of companies names it should be displayed")
    public void iVerifyTheListOfCompaniesNamesItShouldBeDisplayed() {
        List<String> temp = new ArrayList<>();
        for (WebElement img : page.list) {
            temp.add(img.getAttribute("alt"));
        }
        BrowserUtils.isDisplayed(temp.contains("Awesome Image"));


    }
}
