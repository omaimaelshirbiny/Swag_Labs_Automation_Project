package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LogsUtils;
import utilities.Utility;

public class P05_OverviewPage {

    //elements
    private final WebDriver driver;
    private final By subTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By total = By.className("summary_total_label");
    private final By finishButton = By.id("finish");


    public P05_OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public float getSubTotal() {
        return Float.parseFloat(Utility.getText(driver, subTotal).replace("Item total: $", ""));
    }

    public float getTax() {
        return Float.parseFloat(Utility.getText(driver, tax).replace("Tax: $", ""));
    }

    public float getTotal() {
        LogsUtils.info("Total Price exists : " + (Utility.getText(driver, total).replace("Total: $", "")));
        return Float.parseFloat(Utility.getText(driver, total).replace("Total: $", ""));
    }

    public Float calcTotal() {
        LogsUtils.info("Total Price calculated : " + (getSubTotal() + getTax()));
        return (getSubTotal() + getTax());
    }

    public boolean comparePrice() {
        return calcTotal().equals(getTotal());
    }

    public P06_FinishPage clickOnFinish() {
        Utility.clickOnButton(driver, finishButton);
        return new P06_FinishPage(driver);
    }

}
