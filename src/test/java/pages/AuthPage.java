package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model for the Authentication Page (Signup/Login)
 */
public class AuthPage extends BasePage {

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignupHeader;

    @FindBy(name = "name")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginToYourAccountHeader;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC1 Step 5: Verify 'New User Signup!' is visible
     */
    public boolean isNewUserSignupVisible() {
        wait.until(ExpectedConditions.visibilityOf(newUserSignupHeader));
        return newUserSignupHeader.isDisplayed();
    }

    /**
     * TC1 Step 6: Enter name and email
     */
    public void fillSignupForm(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
    }

    /**
     * TC1 Step 7: Click 'Signup' button
     */
    public void clickSignup() {
        safeClick(signupButton);
    }

    /**
     * TC2 Step 5: Verify 'Login to your account' is visible
     */
    public boolean isLoginToYourAccountVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginToYourAccountHeader));
        return loginToYourAccountHeader.isDisplayed();
    }

    /**
     * TC2 Step 6: Enter credentials
     */
    public void fillLoginForm(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
    }

    /**
     * TC2 Step 7: Click 'login' button
     */
    public void clickLogin() {
        safeClick(loginButton);
    }

}
