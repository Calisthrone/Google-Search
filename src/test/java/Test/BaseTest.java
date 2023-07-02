package Test;

import PageObject.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static WebDriver driver;

    public static GooglePage googlePage;

    // this will run before each suite
    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        googlePage = new GooglePage(driver);
    }
}
