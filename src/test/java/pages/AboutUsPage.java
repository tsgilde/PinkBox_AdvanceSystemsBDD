package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class AboutUsPage {
    public AboutUsPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='sec-title centered']/h5[text()='About Us']")
    public WebElement aboutUs;
    
    @FindBy(xpath = "//h3[text()='On Time Services']")
    public WebElement OnTimeText;

    @FindBy(xpath = "//h3[text()='Experienced Team']")
    public WebElement TeamText;

    @FindBy(xpath = "//h3[text()='Good Track Records']")
    public WebElement GoodText;

    @FindBy(xpath = "//img[contains(@src,'team')]")
    public List<WebElement> teamPicture;

    @FindBy(xpath = "//div[@class='lower-content']/div[@class='designation']")
    public List<WebElement> teamTittle;

    @FindBy(xpath = "//div[@class='lower-content']//div[@class='text']")
    public List<WebElement> teamQuote;

    @FindBy(xpath = "//ul[@class='social-icon-one']")
    public List<WebElement> teamSocialMedia;

    public String socialBtn = "(//ul[@class='social-icon-one'])[%s]/li/a[contains(@href,'%s')]";
    public String socialLink = "//ul[@class='social-icon-one']/li/a[contains(@href,'%s')]";



}