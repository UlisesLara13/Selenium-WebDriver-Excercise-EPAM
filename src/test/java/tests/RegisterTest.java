package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.HomePage;
import pages.SignupFormPage;
import utils.TestData;

/**
 * Test Case 1: Register User
 * https://automationexercise.com/test_cases
 */
public class RegisterTest extends BaseTest {

    @Test
    public void registerUser() {
        log.info("STEP 3 - Verifying home page is visible");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
                "Home page should be visible after navigation");

        log.info("STEP 4 - Clicking 'Signup / Login' button");
        homePage.clickSignupLogin();

        log.info("STEP 5 - Verifying 'New User Signup!' is visible");
        AuthPage authPage = new AuthPage(driver);
        Assert.assertTrue(authPage.isNewUserSignupVisible(),
                "'New User Signup!' should be visible");

        log.info("STEP 6 - Entering name and email address");
        String uniqueEmail = TestData.generateEmail();
        log.info("Generated email: {}", uniqueEmail);
        authPage.fillSignupForm(TestData.NAME, uniqueEmail);

        log.info("STEP 7 - Clicking 'Signup' button");
        authPage.clickSignup();

        log.info("STEP 8 - Verifying 'ENTER ACCOUNT INFORMATION' is visible");
        SignupFormPage signupFormPage = new SignupFormPage(driver);
        Assert.assertTrue(signupFormPage.isEnterAccountInformationVisible(),
                "'Enter Account Information' should be visible");

        log.info("STEP 9 - Filling account details: title, password, date of birth");
        signupFormPage.fillAccountDetails(TestData.PASSWORD);

        log.info("STEP 10 - Selecting 'Sign up for our newsletter!' checkbox");
        signupFormPage.selectNewsletter();

        log.info("STEP 11 - Selecting 'Receive special offers from our partners!' checkbox");
        signupFormPage.selectSpecialOffers();

        log.info("STEP 12 - Filling address details");
        signupFormPage.fillAddressDetails(
                TestData.FIRST_NAME, TestData.LAST_NAME, TestData.COMPANY,
                TestData.ADDRESS, TestData.ADDRESS_2, TestData.COUNTRY,
                TestData.STATE, TestData.CITY, TestData.ZIPCODE, TestData.MOBILE
        );

        log.info("STEP 13 - Clicking 'Create Account' button");
        signupFormPage.clickCreateAccount();

        log.info("STEP 14 - Verifying 'ACCOUNT CREATED!' is visible");
        Assert.assertTrue(signupFormPage.isAccountCreatedVisible(),
                "'Account Created!' should be visible");

        log.info("STEP 15 - Clicking 'Continue' button");
        signupFormPage.clickContinue();

        log.info("STEP 16 - Verifying 'Logged in as username' is visible in navbar");
        Assert.assertTrue(homePage.isLoggedInAsVisible(),
                "'Logged in as username' should be visible in the navbar");

        log.info("STEP 17 - Clicking 'Delete Account' button");
        homePage.clickDeleteAccount();

        log.info("STEP 18 - Verifying 'ACCOUNT DELETED!' is visible");
        Assert.assertTrue(homePage.isAccountDeletedVisible(),
                "'Account Deleted!' message should be visible");
    }
}
