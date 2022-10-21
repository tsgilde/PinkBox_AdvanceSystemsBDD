package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserUtils;

public class Hooks {

    @Before
    public void setUp(){
        //initialized the driver object to open the browser
        BrowserUtils.getDriver();
    }

    @After
    public void tearDown(){
        BrowserUtils.quitDriver();
    }

}
