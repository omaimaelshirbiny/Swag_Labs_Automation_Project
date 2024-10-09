package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestLestenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utilities.DataUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({IInvokedMethodListenerClass.class, ITestLestenerClass.class})
public class TC01_LoginTest {

    private final String USERNAME = DataUtils.getJsonData("validLoginData", "userName");
    private final String PASSWORD = DataUtils.getJsonData("validLoginData", "password");

    public TC01_LoginTest() throws FileNotFoundException {
    }

    @BeforeMethod
    public void setup() throws IOException {
        //  setupDriver("chrome");  //instead of givin fixed , static data manually in code , i read them from a generated data file that is easy to change data in
        //initiation for driver
        setupDriver(DataUtils.getPropertyValue("environment", "Browser"));
        // driver.get("https://www.saucedemo.com/");
        getDriver().get(DataUtils.getPropertyValue("environment", "BaseURL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void validLoginTC() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), DataUtils.getPropertyValue("environment", "Landing-page"));
        // Assert.assertNotEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
