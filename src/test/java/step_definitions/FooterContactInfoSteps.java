package step_definitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.FooterContactInfoPage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class FooterContactInfoSteps implements CommonPage {
    FooterContactInfoPage page;
    public FooterContactInfoSteps(){
        page = new FooterContactInfoPage();
    }

    @When("Verify contact info is displayed in the footer section:")
    public void verifyContactInfoIsDisplayedInTheFooterSection(List<String> data) {
        List<String> temp = new ArrayList<>();
        for (WebElement each : page.footercontact) {
            temp.add(each.getText());
        }
        BrowserUtils.isDisplayed(temp.equals(data));

    }
}
