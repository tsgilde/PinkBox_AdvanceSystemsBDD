package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ServicesPage {
    public ServicesPage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
    @FindBy(xpath = "//h1")
    public WebElement title;
    @FindBy(xpath = "//div[@class='image']")
    public WebElement img;

    @FindBy(xpath = "//div[@class='text']/p")
    public WebElement textRow;

    @FindBy(xpath = "//div[@class='text']//div[1]")
    public WebElement quoteContent;

}
