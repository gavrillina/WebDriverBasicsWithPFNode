package page.move;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JQueryTest {
    WebDriver driver;


    @BeforeTest
    private void initDriver() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void droppableTest() {
        JQueryMove jQueryMove = new JQueryMove(driver);
        jQueryMove.drugAndDrop();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
