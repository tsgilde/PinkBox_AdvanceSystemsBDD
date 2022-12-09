package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(id = "dropdownMenu1")
    public WebElement languageBtn;

    @FindBy(xpath = "//ul[@class='dropdown-menu style-one']//a")
    public List<WebElement> languages;

    @FindBy(xpath = "//ul[@class='social-icon-six']")
    public WebElement socialMediabtn;

    @FindBy(id = "title")
    public WebElement headerTitle;

    @FindBy(xpath = "(//div[@class = 'owl-stage-outer'])[3]")
    public WebElement companyNames;
}
