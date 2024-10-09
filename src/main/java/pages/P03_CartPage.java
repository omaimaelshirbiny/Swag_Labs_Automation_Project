package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LogsUtils;
import utilities.Utility;

import java.util.List;

public class P03_CartPage {


    static float totalSelectedPrice = 0;
    //elements
    private final WebDriver driver;
    private final By continueShoppingLocator = By.id("continue-shopping");
    private final By checkOutLocator = By.id("checkout");
    private final By pricesOfSelectedProductsLocator = By.xpath("//button[.=\"Remove\"]//preceding-sibling::div[@class=\"inventory_item_price\"]");

    //constructor
    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //events
    public P03_CartPage clickOnContinueShopping() {
        Utility.clickOnButton(driver, continueShoppingLocator);
        return this;
    }

    public P04_CheckoutPage clickOnCheckOutButton() {
        Utility.clickOnButton(driver, checkOutLocator);
        return new P04_CheckoutPage(driver);
    }


    public String getTotalPrice() {
        try {
            List<WebElement> pricesOfSelectedProducts = driver.findElements(pricesOfSelectedProductsLocator);
            for (int i = 1; i <= pricesOfSelectedProducts.size(); i++) {
                By elements = By.xpath("(//button[.=\"Remove\"]//preceding-sibling::div[@class=\"inventory_item_price\"])[" + i + "]");
                String fullText = Utility.getText(driver, elements);
                totalSelectedPrice += Float.parseFloat(fullText.replace("$", ""));
            }
            LogsUtils.info("Total Price " + totalSelectedPrice);
            return String.valueOf(totalSelectedPrice);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
            return "0";
        }
    }

    public boolean comparingPrices(String price) {
        return getTotalPrice().equals(price);
    }

}
