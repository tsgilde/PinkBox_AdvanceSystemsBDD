package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.ContactUsPage;
import pages.ServicesPage;
import utils.BrowserUtils;

import java.util.List;

public class ServicesSteps implements CommonPage {
    WebDriverWait wait;
    ServicesPage page;

    public ServicesSteps() {

        page = new ServicesPage();
    }

    @Then("I click link  {string}")
    public void iClickLink(String division) {
        try {
            Thread.sleep(7000);
            BrowserUtils.click(BrowserUtils.getDriver().findElement(
                    By.xpath(String.format(XPATH_TEMPLATE_TEXT, division))));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I click in the in ech division and go back to services")
    public void iClickInTheInEchDivisionAndGoBackToServices() {
        List<WebElement> each = BrowserUtils.getDriver().findElements(By.xpath("//h4"));

        for (WebElement list : each) {
            try {
                Thread.sleep(7000);
                BrowserUtils.click(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(7000);
                BrowserUtils.isDisplayed(page.title);
                System.out.println(BrowserUtils.getDriver().getTitle());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BrowserUtils.getDriver().navigate().back();

        }
    }

    @Then("I click in each Divion and verify header, main image, description and a quote")
    public void iClickInEachDivionAndVerifyHeaderMainImageDescriptionAndAQuote() {
        List<WebElement> each = BrowserUtils.getDriver().findElements(By.xpath("//h4"));
        for (WebElement list : each) {
            try {
                Thread.sleep(7000);
                BrowserUtils.click(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(7000);
                BrowserUtils.isDisplayed(page.title);
                BrowserUtils.isDisplayed(page.img);
                BrowserUtils.isDisplayed(page.textRow);
                BrowserUtils.isDisplayed(page.quoteContent);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BrowserUtils.getDriver().navigate().back();

        }

    }

}

