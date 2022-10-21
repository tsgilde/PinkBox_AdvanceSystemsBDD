package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(id = "title")
    public WebElement headerTitle;

    @FindBy(xpath = "//nav/a[text()='Calendar']")
    public WebElement calendarBtn;

    @FindBy(xpath = "//nav/a[text()='Others']")
    public WebElement othersBtn;

    @FindBy(xpath = "//nav/a[text()='User-Mgt']")
    public WebElement userMgtBtn;

    @FindBy(xpath = "//nav/a[text()='Pop-Up']")
    public WebElement popUpBtn;

    @FindBy(linkText = "Home")
    public WebElement homeLinkText;

    @FindBy(linkText = "Tables")
    public WebElement tablesLinkText;

    @FindBy(linkText = "Synchronization")
    public WebElement synchronizationLinkText;

    @FindBy(linkText = "iFrames")
    public WebElement iframesLinkText;

}
