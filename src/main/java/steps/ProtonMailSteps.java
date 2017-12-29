package steps;

import buissnes_object.Mail;
import buissnes_object.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exeptions.CannotLoginException;
import exeptions.DraftNotFoundException;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.InboxPage;
import page.LoginPage;
import utility.WebDriverManager;
import utility.WebDriverSingleton;

public class ProtonMailSteps {

    private static WebDriver driver = WebDriverManager.getWebDriverInstance();
    private static final String START_URL = "https://protonmail.com/";


    @Given("^user navigates to proton mail home page$")
    public void navigate_to_home_page() {
        driver.get(START_URL);
    }

    @When("^click signIn button$")
    public void click_signIn() {
        // Login via user-defined method
        new HomePage(driver).clickLoginButton();

    }

    @And("^enters user credentials and submits login form$")
    public void enter_user_credentials(User user) throws CannotLoginException {
        new LoginPage(driver).doLogIn(user.PROTON_LOGIN);

    }

    @And("^create new message and save of drafts \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$\"")
    public void create_new_mwssage_and_save(String sender, String subject, String body){
       Mail mail = new Mail(sender,subject,body);
        new InboxPage(driver).createNewMessage(mail);

    }

    @Then("^send_message_from_draft$")
    public void send_message_from_draft(Mail mail) throws DraftNotFoundException {
        new InboxPage(driver).veryfySendMessage(mail);
        }


    }
