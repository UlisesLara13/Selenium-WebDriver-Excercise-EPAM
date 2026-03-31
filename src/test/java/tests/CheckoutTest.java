package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.TestData;

/**
 * Test Case 16: Place Order: Login before Checkout
 * https://automationexercise.com/test_cases
 */
public class CheckoutTest extends BaseTest {
    @Test
    public void placeOrderLogin() {
        log.info("PRECONDITION - Creating account to use in this test");
        String uniqueEmail = TestData.generateEmail();
        log.info("Generated email: {}", uniqueEmail);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page should be visible");

        homePage.clickSignupLogin();

        AuthPage authPage = new AuthPage(driver);
        authPage.fillSignupForm(TestData.NAME, uniqueEmail);
        authPage.clickSignup();

        SignupFormPage signupFormPage = new SignupFormPage(driver);
        signupFormPage.fillAccountDetails(TestData.PASSWORD);
        signupFormPage.selectNewsletter();
        signupFormPage.selectSpecialOffers();
        signupFormPage.fillAddressDetails(
                TestData.FIRST_NAME, TestData.LAST_NAME, TestData.COMPANY,
                TestData.ADDRESS, TestData.ADDRESS_2, TestData.COUNTRY,
                TestData.STATE, TestData.CITY, TestData.ZIPCODE, TestData.MOBILE
        );
        signupFormPage.clickCreateAccount();
        signupFormPage.clickContinue();

        log.info("PRECONDITION - Account created, logging out to test login before checkout flow");
        driver.navigate().to("https://automationexercise.com/logout");

        // --- TC16 actual steps begin here ---

        log.info("STEP 2 - Navigating to automationexercise.com");
        driver.navigate().to("https://automationexercise.com");

        log.info("STEP 3 - Verifying home page is visible");
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page should be visible after navigation");

        log.info("STEP 4 - Clicking 'Signup / Login' button");
        homePage.clickSignupLogin();

        log.info("STEP 5 - Entering credentials and clicking Login");
        authPage.fillLoginForm(uniqueEmail, TestData.PASSWORD);
        authPage.clickLogin();

        log.info("STEP 6 - Verifying 'Logged in as username' is visible in navbar");
        Assert.assertTrue(homePage.isLoggedInAsVisible(),
                "'Logged in as username' should be visible in the navbar");


        log.info("STEP 7 - Adding first product to cart");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShopping();

        log.info("STEP 8 - Clicking 'Cart' button");
        productsPage.clickCart();

        log.info("STEP 9 - Verifying cart page is displayed");
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartPageDisplayed(),
                "Cart page should be displayed with products");

        log.info("STEP 10 - Clicking 'Proceed To Checkout'");
        cartPage.clickProceedToCheckout();

        log.info("STEP 11 - Verifying Address Details and Review Your Order sections");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(),
                "Address Details section should be visible");
        Assert.assertTrue(checkoutPage.isReviewYourOrderVisible(),
                "Review Your Order section should be visible");

        log.info("STEP 12 - Entering comment and clicking 'Place Order'");
        checkoutPage.enterCommentAndPlaceOrder(TestData.ORDER_COMMENT);

        log.info("STEP 13-14 - Entering payment details and confirming order");
        checkoutPage.enterPaymentDetails(
                TestData.CARD_NAME, TestData.CARD_NUMBER,
                TestData.CARD_CVC, TestData.CARD_EXPIRY_MONTH, TestData.CARD_EXPIRY_YEAR
        );

        log.info("STEP 15 - Verifying success message 'Your order has been placed successfully!'");
        Assert.assertTrue(checkoutPage.isOrderPlacedSuccessfully(),
                "Success message 'Your order has been placed successfully!' should appear");

        log.info("Clicking Continue to return to home page");
        checkoutPage.clickContinueAfterOrder();

        log.info("STEP 16 - Clicking 'Delete Account' button");
        homePage.clickDeleteAccount();

        log.info("STEP 17 - Verifying 'ACCOUNT DELETED!' is visible");
        Assert.assertTrue(homePage.isAccountDeletedVisible(),
                "'Account Deleted!' message should be visible");
    }
}
