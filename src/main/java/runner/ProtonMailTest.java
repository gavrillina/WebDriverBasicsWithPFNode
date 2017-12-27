package runner;

import buissnesObject.Mail;
import buissnesObject.User;
import org.testng.annotations.*;
import page.*;
import exeptions.CannotLoginException;
import exeptions.DraftNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ProtonMailTest {
    WebDriver driver;
    HomePage homePageFactory;
    InboxPage inboxPageFactory;

    @BeforeClass
    private void openBrauser() {
//        try {
//            driver = new RemoteWebDriver(new URL("http://10.12.12.191:4444/wd/hub"), DesiredCapabilities.chrome());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        ;
//        driver.manage().window().maximize();

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://protonmail.com/");
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "testDataForLogIn")
    private void logInToBox(User user) throws CannotLoginException {

        homePageFactory = new HomePage(driver);
        inboxPageFactory = new InboxPage(driver);
        homePageFactory.clickLoginButton().doLogIn(user);

    }

    @Test(dataProvider = "testDataForMail", dependsOnMethods = {"logInToBox"})
    private void createNewMail(Mail mail) {

        inboxPageFactory.createNewMessage(mail);
    }

    @Test(dataProvider = "testDataForMail", dependsOnMethods = {"createNewMail"})
    private void checkingDraftPresence(Mail mail) throws DraftNotFoundException {

        inboxPageFactory.veryfySendMessage(mail);
    }

    @DataProvider
    public Object[][] testDataForMail() {
        Mail mail = new Mail("tani455@mail.ru", "Tatyana", "Some text");
        return new Object[][]{{mail}};
    }

    @DataProvider
    public Object[][] testDataForLogIn() {

        return new Object[][]{{User.PROTON_LOGIN}};
    }

    @AfterTest
    private void closeBrowser() {
        driver.quit();
    }

}