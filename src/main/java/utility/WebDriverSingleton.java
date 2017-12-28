package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSingleton  {


    private WebDriver driver;


    public WebDriver getDriver() {

        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriver getRemotedriver(String urlHub){

        if (driver != null) {
            driver = null;
        }
        try {
            driver = new RemoteWebDriver(new URL(urlHub), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  driver;

    }
}
