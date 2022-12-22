package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

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



}