package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utility;

public class P01_LoginPage {


    // elements
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final WebDriver driver;

    //constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //actions
    public P01_LoginPage enterUserName(String userNameText) {
        Utility.sendData(driver, userName, userNameText);
        return this;
    }

    public P01_LoginPage enterPassword(String passwordText) {
        Utility.sendData(driver, password, passwordText);
        return this;
    }

    public P02_LandingPage clickOnButton() {
        Utility.clickOnButton(driver, loginButton);
        return new P02_LandingPage(driver);
    }
}
