package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class InputsPage {

    public InputsPage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(name = "state")
    public WebElement selectState;
}
