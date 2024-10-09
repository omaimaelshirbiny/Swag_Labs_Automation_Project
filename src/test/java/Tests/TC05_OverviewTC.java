package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestLestenerClass;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P05_OverviewPage;
import utilities.DataUtils;
import utilities.LogsUtils;
import utilities.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({IInvokedMethodListenerClass.class, ITestLestenerClass.class})

public class TC05_OverviewTC {
    private final String USERNAME = DataUtils.getJsonData("validLoginData", "userName");
    private final String PASSWORD = DataUtils.getJsonData("validLoginData", "password");
    private final String FIRSTNAME = DataUtils.getJsonData("checkoutData", "firstName") + " - " + Utility.getTimeStamp();    //
    private final String LASTNAME = DataUtils.getJsonData("checkoutData", "lastName") + " - " + Utility.getTimeStamp();
    private final String ZIPCODE = new Faker().number().digits(5);


    public TC05_OverviewTC() throws FileNotFoundException {
    }


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(DataUtils.getPropertyValue("environment", "Browser"));
        getDriver().get(DataUtils.getPropertyValue("environment", "BaseURL"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void checkoutStepTwoTC() throws IOException {
        new P01_LoginPage(getDriver())
                .enterUserName(USERNAME)
                .enterPassword(PASSWORD)
                .clickOnButton()
                .addAllItemsToCart()
                .clickOnCartIcon()
                .clickOnCheckOutButton()
                .fillInfoCheckout(FIRSTNAME, LASTNAME, ZIPCODE);
        LogsUtils.info(FIRSTNAME + " " + LASTNAME + " " + ZIPCODE);
        Assert.assertTrue(new P05_OverviewPage(getDriver()).comparePrice());
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
