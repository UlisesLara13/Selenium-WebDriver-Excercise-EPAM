package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Represents the Signup Form Page of the application.
 * Contains methods to interact with signup form elements and verify signup form functionalities.
 */
public class SignupFormPage extends BasePage {

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement enterAccountInfoHeader;

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadio;

    @FindBy(css = "input[data-qa='password']")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(css = "input[data-qa='first_name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[data-qa='last_name']")
    private WebElement lastNameInput;

    @FindBy(css = "input[data-qa='company']")
    private WebElement companyInput;

    @FindBy(css = "input[data-qa='address']")
    private WebElement addressInput;

    @FindBy(css = "input[data-qa='address2']")
    private WebElement address2Input;

    @FindBy(css = "select[data-qa='country']")
    private WebElement countrySelect;

    @FindBy(css = "input[data-qa='state']")
    private WebElement stateInput;

    @FindBy(css = "input[data-qa='city']")
    private WebElement cityInput;

    @FindBy(css = "input[data-qa='zipcode']")
    private WebElement zipcodeInput;

    @FindBy(css = "input[data-qa='mobile_number']")
    private WebElement mobileInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedHeader;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueBtn;

    public SignupFormPage(WebDriver driver) {
        super(driver);
    }

    /**
     * TC1 Step 8: Verify that 'ENTER ACCOUNT INFORMATION' is visible
     */
    public boolean isEnterAccountInformationVisible() {
        wait.until(ExpectedConditions.visibilityOf(enterAccountInfoHeader));
        return enterAccountInfoHeader.isDisplayed();
    }

    /**
     * TC1 Step 9: Fill details: Title, Name, Email, Password, Date of birth
     * Note: Name and Email are pre-filled from previous step
     */
    public void fillAccountDetails(String password) {
        titleMrRadio.click();
        passwordInput.sendKeys(password);
        new Select(daysSelect).selectByValue("10");
        new Select(monthsSelect).selectByVisibleText("May");
        new Select(yearsSelect).selectByValue("2000");
    }

    /**
     * TC1 Step 10: Select checkbox 'Sign up for our newsletter!'
     */
    public void selectNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }
    }

    /**
     * TC1 Step 11: Select checkbox 'Receive special offers from our partners!'
     */
    public void selectSpecialOffers() {
        if (!specialOffersCheckbox.isSelected()) {
            specialOffersCheckbox.click();
        }
    }

    /**
     * TC1 Step 12: Fill details: First name, Last name, Company, Address, etc.
     */
    public void fillAddressDetails(String firstName, String lastName, String company,
                                   String address, String address2, String country,
                                   String state, String city, String zipcode, String mobile) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        addressInput.sendKeys(address);
        address2Input.sendKeys(address2);
        new Select(countrySelect).selectByVisibleText(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileInput.sendKeys(mobile);
    }

    /**
     * TC1 Step 13: Click 'Create Account' button
     */
    public void clickCreateAccount() {
        safeClick(createAccountBtn);
    }

    /**
     * TC1 Step 14: Verify that 'ACCOUNT CREATED!' is visible
     */
    public boolean isAccountCreatedVisible() {
        wait.until(ExpectedConditions.visibilityOf(accountCreatedHeader));
        return accountCreatedHeader.isDisplayed();
    }

    /**
     * TC1 Step 15: Click 'Continue' button
     */
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        safeClick(continueBtn);
    }

}
