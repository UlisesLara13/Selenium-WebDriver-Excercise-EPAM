package base;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotUtils;

/**
 * BaseTest class that serves as a parent for all test classes.
 * It manages the WebDriver lifecycle and provides common setup and teardown methods.
 */
public class BaseTest {

    protected final Logger log = LogManager.getLogger(getClass());
    protected WebDriver driver;

    /**
     * Sets up the WebDriver before each test method.
     * Navigates to the base URL of the application.
     */
    @BeforeMethod
    public void setUp(java.lang.reflect.Method method) {
        log.info("========== STARTING TEST: {} ==========", method.getName());
        driver = DriverSingleton.getDriver();
        driver.get("https://automationexercise.com");
        log.info("Navigating to automationexercise.com");
    }

    /**
     * Tears down the WebDriver after each test method.
     * If the test fails, it takes a screenshot of the error.
     *
     * @param result the result of the test method execution
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getName();

        if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("TEST PASSED: {}", testName);
            ScreenshotUtils.takeEvidenceScreenshot(driver, testName);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            log.error("TEST FAILED: {}", testName);
            log.error("Cause: {}", result.getThrowable().getMessage());
            ScreenshotUtils.takeScreenshot(driver, testName);
        } else if (result.getStatus() == ITestResult.SKIP) {
            log.warn("TEST SKIPPED: {}", testName);
        }

        log.info("========== END TEST: {} ==========\n", testName);
        DriverSingleton.quitDriver();
    }
}
