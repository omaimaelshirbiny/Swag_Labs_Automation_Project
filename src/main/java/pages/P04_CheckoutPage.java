package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P04_CheckoutPage {

    public final By firstName = By.id("first-name");
    public final By lastName = By.id("last-name");
    public final By zip = By.id("postal-code");
    public final By continueButton = By.id("continue");
    //elements
    private final WebDriver driver;

    //constructor
    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P05_OverviewPage fillInfoCheckout(String fName, String lName, String ZIPCode) {
        Utility.sendData(driver, firstName, fName);
        Utility.sendData(driver, lastName, lName);
        Utility.sendData(driver, zip, ZIPCode);
        Utility.clickOnButton(driver, continueButton);
        return new P05_OverviewPage(driver);
    }
}
