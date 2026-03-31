package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.AuthPage;
import pages.SignupFormPage;
import utils.TestData;

/**
 * Test Case 2: Login User with correct email and password
 * https://automationexercise.com/test_cases
 */
public class LoginTest extends BaseTest {
    @Test
    public void loginUser() {
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

        log.info("PRECONDITION - Account created, logging out to test login flow");
        driver.navigate().to("https://automationexercise.com/logout");

        // --- TC2 actual steps begin here ---

        log.info("STEP 2 - Navigating to automationexercise.com");
        driver.navigate().to("https://automationexercise.com");

        log.info("STEP 3 - Verifying home page is visible");
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page should be visible after navigation");

        log.info("STEP 4 - Clicking 'Signup / Login' button");
        homePage.clickSignupLogin();

        log.info("STEP 5 - Verifying 'Login to your account' is visible");
        Assert.assertTrue(authPage.isLoginToYourAccountVisible(),
                "'Login to your account' should be visible");

        log.info("STEP 6 - Entering email and password");
        authPage.fillLoginForm(uniqueEmail, TestData.PASSWORD);

        log.info("STEP 7 - Clicking 'Login' button");
        authPage.clickLogin();

        log.info("STEP 8 - Verifying 'Logged in as username' is visible in navbar");
        Assert.assertTrue(homePage.isLoggedInAsVisible(),
                "'Logged in as username' should be visible in the navbar");

        log.info("STEP 9 - Clicking 'Delete Account' button");
        homePage.clickDeleteAccount();

        log.info("STEP 10 - Verifying 'ACCOUNT DELETED!' is visible");
        Assert.assertTrue(homePage.isAccountDeletedVisible(),
                "'Account Deleted!' message should be visible");
    }

}
