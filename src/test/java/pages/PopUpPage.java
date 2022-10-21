package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class PopUpPage {
    public PopUpPage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Message']")
    public WebElement messageBtn;

    @FindBy(xpath = "//button[text()='BMI Calculator']")
    public WebElement bmiCalcBtn;

    @FindBy(id = "exampleModalLabel")
    public WebElement headerNewMsg;

    @FindBy(id = "staticBackdropLabel")
    public WebElement headerBMICalc;


}

