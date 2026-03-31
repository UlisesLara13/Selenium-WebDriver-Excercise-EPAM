package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the Products Page of the application.
 * Contains methods to interact with product elements and verify product page functionalities.
 */
public class ProductsPage extends BasePage {

    @FindBy(xpath = "(//a[@data-product-id])[1]")
    private WebElement firstAddToCartBtn;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartMenuBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC16 Step 7: Add products to cart
     */
    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.visibilityOf(firstAddToCartBtn));
        safeClick(firstAddToCartBtn);
    }

    /**
     * After modal appears, click 'Continue Shopping'
     */
    public void clickContinueShopping() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
        safeClick(continueShoppingBtn);
    }

    /**
     * TC16 Step 8: Click 'Cart' button
     */
    public void clickCart() {
        safeClick(cartMenuBtn);
    }
}
