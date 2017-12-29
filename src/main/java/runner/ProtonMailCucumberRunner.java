package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.WebDriverManager;
import utility.WebDriverSingleton;


import java.util.concurrent.TimeUnit;


@CucumberOptions(strict = true, tags = "@all", features = "src/main/resources/cucumber.feature", glue = {
        "steps"})

public class ProtonMailCucumberRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver ;

    @BeforeTest(description = "Start browser, add implicit wait and maximize window")
    public void startBrowser() {
        // set a certain implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Maximize browser window
        driver.manage().window().maximize();
    }


    @AfterTest(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

}
