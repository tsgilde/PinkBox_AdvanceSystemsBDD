package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ListCompaniesPage {
    public ListCompaniesPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
    @FindBy(xpath = "(//div[@class='owl-stage-outer'])[3]")
    public WebElement list;
}
