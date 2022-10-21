package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class UserMgtPage {

    public UserMgtPage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

//    @FindBy(xpath = "//button[text()='Login']")
//    public WebElement loginBtn;

    @FindBy(id = "practice-form")
    public WebElement loginBtn;
}
