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

    @FindBy(id = "Firstname")
    public WebElement firstNameInput;

    @FindBy(id = "Lastname")
    public WebElement lastNameInput;

    @FindBy(id = "Phonenumber")
    public WebElement phoneInput;

    @FindBy(id = "Email")
    public WebElement emailInput;

    @FindBy(id = "Select-role")
    public WebElement selectRole;


}
