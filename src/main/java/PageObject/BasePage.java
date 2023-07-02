package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {this.driver = driver;}

    // create all other types of elements
    public WebElement createElement(By locator) {

        return (new WebDriverWait(driver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // clicks on any element (no need to trigger waits, already implemented in the createClickableElement method
    protected void clickOn(By locator) {createElement(locator).click();}

    // enter text in any kind of fields
    // clearText -> if you want to clear the text field before entering text
    // clickEnter -> if you want to mimic pressing enter after entering a text
    protected void enterText(boolean clearText, By locator, String text, boolean clickEnter) {
        WebElement textField = createElement(locator);
        if (clearText) textField.clear();
        textField.sendKeys(text);
        if (clickEnter) textField.sendKeys(Keys.RETURN);
    }

    // sleeps the thread, takes in double, where 1 is one second and 0.5 is half second and so on
    protected void sleepThread(double seconds) {
        try {
            long waitTimeInSeconds = (long) (1000 * seconds);
            Thread.sleep(Duration.ofMillis(waitTimeInSeconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
