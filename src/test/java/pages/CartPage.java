package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the Cart Page of the application.
 * Contains methods to interact with cart elements and verify cart page functionalities.
 */
public class CartPage extends BasePage {

    @FindBy(id = "cart_info")
    private WebElement cartInfoTable;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC16 Step 9: Verify that cart page is displayed
     */
    public boolean isCartPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(cartInfoTable));
        return cartInfoTable.isDisplayed();
    }

    /**
     * TC16 Step 10: Click 'Proceed To Checkout'
     */
    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        safeClick(proceedToCheckoutBtn);
    }
}
