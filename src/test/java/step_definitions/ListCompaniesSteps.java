package step_definitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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



    @When("I verify the list of companies names it should be displayed {int} row")
    public void iVerifyTheListOfCompaniesNamesItShouldBeDisplayedRow(int number) {
        if (page.list.getText().length() == number){
            BrowserUtils.isDisplayed(page.list);
        }
    }
}
