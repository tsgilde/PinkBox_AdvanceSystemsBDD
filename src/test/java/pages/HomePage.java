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


    @FindBy(xpath = "//span[@class='right_arrow icon-arrows']")
    public WebElement next_nav;

    @FindBy(xpath = "//div[@class='owl-item active']//h3")
    public WebElement activeName;

    @FindBy(xpath = "//div[@class='owl-item active']//div[@class='text']")
    public WebElement activeText;

    @FindBy(xpath = "//div[@class='owl-item']//h3")
    public List<WebElement> listOfName;

    public String socialMediaBtn = "//ul[@class='social-icon-six']//a[contains(@href, '%s')]";


    public String footerContact = "//ul[@class='list-info']//li[contains(text(),'%s')]";
}

