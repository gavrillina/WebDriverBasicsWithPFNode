package page.move;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class JQueryMove extends AbstractPage {


    public JQueryMove(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://jqueryui.com/droppable/']")
    private WebElement droppablePage;

    @FindBy(xpath = "//iframe[@class = 'demo-frame']")
    private WebElement iFrame;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement fromObject;

    @FindBy(xpath = "//div[@id='droppable']")
    private WebElement toObject;

    public JQueryMove drugAndDrop() {
        getDriver().get("https://jqueryui.com/droppable/");
        waitForVisibilityOfAllElementsLocatedBy(iFrame);
        getDriver().switchTo().frame(iFrame);
        new Actions(getDriver()).dragAndDrop(fromObject, toObject).build().perform();
        return this;
    }
}
