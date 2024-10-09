package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LogsUtils;
import utilities.Utility;

import java.util.List;

public class P02_LandingPage {

    static float totalSelectedPrice = 0;
    //elements
    private static List<WebElement> allProducts;
    private final By addAllItemsToCartLocator = By.className("btn_inventory");
    //private final By addAllItemsToCartLocator = By.xpath("//button[@class]");
    private final By numberOfProductsOnCartLocator = By.className("shopping_cart_badge");
    private final WebDriver driver;
    private final By cartIcon = By.className("shopping_cart_link");
    private final By pricesOfSelectedProductsLocator = By.xpath("//button[.=\"Remove\"]//preceding-sibling::div[@class=\"inventory_item_price\"]");


    //constructor
    public P02_LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //actions
    public P02_LandingPage addAllItemsToCart() {
        allProducts = driver.findElements(addAllItemsToCartLocator);
        for (int i = 1; i <= allProducts.size(); i++) {
            By addAllItemsToCartLocator = By.xpath("(//button[@class])[" + i + "]"); //dynamic locator
            Utility.clickOnButton(driver, addAllItemsToCartLocator);
        }

        return this;
    }

    public String getNumberOfProductOnCartIcon() {
        try {
            return Utility.getText(driver, numberOfProductsOnCartLocator);
        } catch (Exception e) {
            // throw new RuntimeException(e);
            return "0"; //if there is no elements found
        }
    }

    public boolean checkSelectedProductsIsAdded() {
        return getNumberOfProductOnCartIcon().equals(Utility.intToSting(allProducts.size()));

    }

    public P03_CartPage clickOnCartIcon() {
        Utility.clickOnButton(driver, cartIcon);
        return new P03_CartPage(driver);
    }


    public String getselectedProductPrices() {
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


}
