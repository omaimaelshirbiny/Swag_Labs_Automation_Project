package Listeners;

import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.LogsUtils;
import utilities.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedMethodListenerClass implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        // Example of attaching a log file to Allure
        File logFile = Utility.getLatestFile(LogsUtils.LOGS_PATH);
        try {
            assert logFile != null;
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                LogsUtils.info("Testcase " + testResult.getMethod().getMethodName() + " failed");
                Utility.sendScreenshotToAllure(getDriver(), testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
