package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserUtils;
import utils.CucumberLogUtils;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        //initialized the driver object to open the browser
        BrowserUtils.getDriver();
        CucumberLogUtils.initScenario(scenario);
 //       scenario.log(CucumberLogUtils.getLogTime() + "My custom Message");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            CucumberLogUtils.logFail("Scenario failed", true);
        }

        BrowserUtils.quitDriver();
    }

}
