package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the Home Page of the application.
 * Contains methods to interact with home page elements and verify home page functionalities.
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginBtn;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsLink;

    @FindBy(linkText = "Delete Account")
    private WebElement deleteAccountBtn;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedMsg;

    @FindBy(css = "div#slider-carousel")
    private WebElement homeCarousel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC Step 3: Verify that home page is visible successfully
     */
    public boolean isHomePageVisible() {
        wait.until(ExpectedConditions.visibilityOf(homeCarousel));
        return homeCarousel.isDisplayed();
    }

    /**
     * TC Step 4: Click on 'Signup / Login' button
     */
    public void clickSignupLogin() {
        safeClick(signupLoginBtn);
    }

    /**
     * TC Step 16/8: Verify that 'Logged in as username' is visible
     */
    public boolean isLoggedInAsVisible() {
        wait.until(ExpectedConditions.visibilityOf(loggedInAsLink));
        return loggedInAsLink.isDisplayed();
    }

    /**
     * TC Step 17/9/16: Click 'Delete Account' button
     */
    public void clickDeleteAccount() {
        safeClick(deleteAccountBtn);
    }

    /**
     * TC Step 18/10/17: Verify that 'ACCOUNT DELETED!' is visible
     */
    public boolean isAccountDeletedVisible() {
        wait.until(ExpectedConditions.visibilityOf(accountDeletedMsg));
        return accountDeletedMsg.isDisplayed();
    }
}
