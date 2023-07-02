package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

    By searchBox = By.xpath("//textarea[@id=\"APjFqb\"]");
    By toolsButton = By.xpath("//div[@id=\"hdtb-tls\"]");
    By selectMenu = By.xpath("//*[@id=\"tn_1\"]/span[2]/g-popup/div[1]/div/div/span");
    By verbatimButton = By.xpath("//*[@id=\"lb\"]/div/g-menu/g-menu-item[2]");

    String head_website = "//*[@id=\"rso\"]/div[";
    String tail_website = "]/div/div/div[1]/div/a/div/div/span";

    String head_url = "//*[@id=\"rso\"]/div[";
    String tail_url = "]/div/div/div[1]/div/a";

    String head_title = "//*[@id=\"rso\"]/div[";
    String tail_title = "]/div/div/div[1]/div/a/h3";

    String head_body = "//*[@id=\"rso\"]/div[";
    String tail_body = "]/div/div/div[2]/div";

    // override superclass constructor
    public GooglePage(WebDriver driver) {super(driver);}

    public GooglePage gotoGooglePage() {
        driver.get("https://www.google.com/ncr");
        return this;
    }

    public GooglePage switchToVerbatim() {
        clickOn(toolsButton);
        clickOn(selectMenu);
        sleepThread(0.5);
        clickOn(verbatimButton);

        return this;
    }

    public GooglePage searchFor(String searchCriteria) {
        enterText(false, searchBox, searchCriteria, true);
        return this;
    }

    public void extractResults(int position) {

        int index = position + 2;

        By websiteLocator = getLocator(head_website, index, tail_website);
        String website = getElementText(websiteLocator);

        By urlLocator = getLocator(head_url, index, tail_url);
        String url = createElement(urlLocator).getAttribute("href");

        By titleLocator = getLocator(head_title, index, tail_title);
        String title = getElementText(titleLocator);

        By bodyLocator = getLocator(head_body, index, tail_body);
        String body = getElementText(bodyLocator);

        System.out.println(" ");
        System.out.println("Search Result Info For Element Number " + position);
        System.out.println("website: " + website);
        System.out.println("url: " + url);
        System.out.println("title: " + title);
        System.out.println("body: " + body);

    }

    private By getLocator(String urlHead, int index, String urlTail) {

        return By.xpath(urlHead + index + urlTail);
    }

    private String getElementText(By locator) {

        WebElement element = createElement(locator);

        return element.getAttribute("textContent");
    }
}
