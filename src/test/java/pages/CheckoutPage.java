package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the Checkout Page of the application.
 * Contains methods to interact with checkout elements and verify checkout functionalities.
 */
public class CheckoutPage extends BasePage {

    @FindBy(id = "address_delivery")
    private WebElement addressDeliverySection;

    @FindBy(id = "cart_info")
    private WebElement reviewYourOrderSection;

    @FindBy(name = "message")
    private WebElement commentTextArea;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    private WebElement placeOrderBtn;

    @FindBy(name = "name_on_card")
    private WebElement nameOnCardInput;

    @FindBy(name = "card_number")
    private WebElement cardNumberInput;

    @FindBy(name = "cvc")
    private WebElement cvcInput;

    @FindBy(name = "expiry_month")
    private WebElement expiryMonthInput;

    @FindBy(name = "expiry_year")
    private WebElement expiryYearInput;

    @FindBy(id = "submit")
    private WebElement payAndConfirmBtn;

    @FindBy(xpath = "//b[text()='Order Placed!']")
    private WebElement orderPlacedHeader;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement continueAfterOrderBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC16 Step 11: Verify Address Details and Review Your Order
     */
    public boolean isAddressDetailsVisible() {
        wait.until(ExpectedConditions.visibilityOf(addressDeliverySection));
        return addressDeliverySection.isDisplayed();
    }

    public boolean isReviewYourOrderVisible() {
        wait.until(ExpectedConditions.visibilityOf(reviewYourOrderSection));
        return reviewYourOrderSection.isDisplayed();
    }

    /**
     * TC16 Step 12: Enter description in comment text area and click 'Place Order'
     */
    public void enterCommentAndPlaceOrder(String comment) {
        wait.until(ExpectedConditions.visibilityOf(commentTextArea));
        commentTextArea.sendKeys(comment);
        safeClick(placeOrderBtn);
    }

    /**
     * TC16 Step 13-14: Enter payment details and click 'Pay and Confirm Order'
     */
    public void enterPaymentDetails(String nameOnCard, String cardNumber,
                                    String cvc, String expiryMonth, String expiryYear) {
        wait.until(ExpectedConditions.visibilityOf(nameOnCardInput));
        nameOnCardInput.sendKeys(nameOnCard);
        cardNumberInput.sendKeys(cardNumber);
        cvcInput.sendKeys(cvc);
        expiryMonthInput.sendKeys(expiryMonth);
        expiryYearInput.sendKeys(expiryYear);
        payAndConfirmBtn.click();
    }

    /**
     * TC16 Step 15: Verify that the order was placed successfully.
     * The page /payment_done shows "ORDER PLACED!" as heading — that confirms success.
     */
    public boolean isOrderPlacedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOf(orderPlacedHeader));
        return orderPlacedHeader.isDisplayed();
    }

    /**
     * Clicks 'Continue' on the confirmation page to go back to home.
     */
    public void clickContinueAfterOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(continueAfterOrderBtn));
        safeClick(continueAfterOrderBtn);
    }
}
