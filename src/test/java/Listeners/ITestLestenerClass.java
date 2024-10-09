package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.LogsUtils;

public class ITestLestenerClass implements ITestListener {

    public void onTestStart(ITestResult result) {
        LogsUtils.info("Testcase " + result.getMethod().getMethodName()
                + " started");
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Testcase " + result.getMethod().getMethodName() + " passed");
    }


    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Testcase " + result.getTestName() + " is skipped");
    }
}
