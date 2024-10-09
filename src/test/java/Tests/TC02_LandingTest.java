package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestLestenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_LandingPage;
import utilities.DataUtils;
import utilities.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({IInvokedMethodListenerClass.class, ITestLestenerClass.class})
public class TC02_LandingTest {

    private final String USERNAME = DataUtils.getJsonData("validLoginData", "userName");
    private final String PASSWORD = DataUtils.getJsonData("validLoginData", "password");

    public TC02_LandingTest() throws FileNotFoundException {
    }


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtils.getPropertyValue("environment", "Browser"));
        getDriver().get(DataUtils.getPropertyValue("environment", "BaseURL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void addingAllItemsToCartTC() {
        new P01_LoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnButton()
                .addAllItemsToCart();
        Assert.assertTrue(new P02_LandingPage(getDriver()).checkSelectedProductsIsAdded());
    }

    @Test
    public void clickOnCartIcon() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnButton()
                .clickOnCartIcon();
        Assert.assertTrue(Utility.verifyURL(getDriver(), DataUtils.getPropertyValue("environment", "CartURL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
