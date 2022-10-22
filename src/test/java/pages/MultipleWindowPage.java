package pages;

import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class MultipleWindowPage {

    public MultipleWindowPage(){

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
}
