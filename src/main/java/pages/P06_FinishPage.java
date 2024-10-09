package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P06_FinishPage {
    private final WebDriver driver;
    private final By thanksMessage = By.tagName("h2");

    public P06_FinishPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean chickFinalMessageExist() {
        return Utility.findWebElement(driver, thanksMessage).isDisplayed();
    }
}
