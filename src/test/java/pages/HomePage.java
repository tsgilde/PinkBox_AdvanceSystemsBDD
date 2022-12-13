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

    @FindBy(xpath = "//div[@class='sec-title light centered']")
    public WebElement testimonials;

    @FindBy(xpath = "//div[@class='owl-item']//h3")
    public List<WebElement> listOfName;

    public String socialMediaBtn = "//ul[@class='social-icon-six']//a[contains(@href, '%s')]";

    public String footerContact = "//ul[@class='list-info']//li[contains(text(),'%s')]";

    @FindBy(xpath = "//div[@class = 'tp-caption']//h2[contains(text(), 'A bright career')]")
    public WebElement careerHeader;

    @FindBy(xpath = "//div[@class = 'tp-caption']//h2[contains(text(), 'Think Big.')]")
    public WebElement thinkBigHeader;

    @FindBy(xpath = "//div[@class = 'tp-caption']//div[contains(text(), 'Lorem Ipsum')]")
    public WebElement thinkBigDescription;

    @FindBy(xpath = "//div[@class = 'tp-caption']//div[contains(text(), 'Our Career Network')]")
    public WebElement careerDescription;
    @FindBy(xpath = "//li[contains(@class, 'active')]//a[contains(text(),'Read More')]")
    public WebElement readMoreBtn;

    @FindBy(xpath= "//*[text()='Join Now']")
    public WebElement jnBtn;

    @FindBy(xpath = "//div[@class='nav-outer clearfix']//nav[@class='main-menu']//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[@class='current']//a[@href='joinUs.html'][normalize-space()='Join Us']")
    public WebElement jsBtn;

    @FindBy(className = "footer-copyright")
    public WebElement footerCopyright;

    @FindBy(className = "main-menu")
    public  WebElement mainMenu;

}

