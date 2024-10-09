package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Utility {


    //element declaration
    private static final String screenPath = ("test-outputs/screenShoots/");


    //actions
    //    TODO: Clicking on Element
    public static void clickOnButton(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(locator));
        driver.findElement(locator).click();

    }


    //    TODO: Send Data ToElement
    public static void sendData(WebDriver driver, By locator, String sendText) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(sendText);
    }

    //    TODO: get text FromElement
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    // Todo: general wait
    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    //TODO : SCOROLLING USING JAVASCRIPT SCREEN 1
    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebElement(driver, locator));
    }

    // TODO: LOCATOR TO WEBELEMENT
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    // TODO: SELECT FROM DROPDOWN
    public static void selectFromDropDown(WebDriver driver, By locator, String option) {
        new Select(findWebElement(driver, locator)).selectByVisibleText(option);
    }

    // TODO : TIME STAMP TO MAKE SCREENSHOT NAME UNIQUE
    public static String getTimeStamp() {
        return new SimpleDateFormat("YYYY-MM-DDa").format(new Date());
    }


    // TODO: Send screenshot in a report
    public static void sendScreenshotToAllure(WebDriver driver, String screenName) throws IOException {
        File screenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenDest = new File(screenPath + screenName + "-" + getTimeStamp() + ".png");
        FileUtils.copyFile(screenSrc, screenDest);
        Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenDest.getPath())));

    }

    public static String intToSting(int x) {
        return "" + x;
    }

    public static boolean verifyURL(WebDriver driver, String ExpectedURL) {
        try {
            Utility.generalWait(driver).until(ExpectedConditions.urlToBe(ExpectedURL));
        } catch (Exception e) {

            return false;
        }
        return true;
    }

    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        if (files.length == 0) {
            return null;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }

}
