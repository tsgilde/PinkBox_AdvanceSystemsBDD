package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class joinBtnPage {
    public joinBtnPage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath= "//*[text()='Join Now']")
    public WebElement jnBtn;

    @FindBy(xpath = "//div[@class='nav-outer clearfix']//nav[@class='main-menu']//div[@class='navbar-collapse collapse clearfix']//ul[@class='navigation clearfix']//li[@class='current']//a[@href='joinUs.html'][normalize-space()='Join Us']")
      public WebElement jsBtn;
}
