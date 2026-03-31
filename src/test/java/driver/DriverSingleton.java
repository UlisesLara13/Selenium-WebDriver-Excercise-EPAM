package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Singleton class for managing the WebDriver instance.
 * Ensures that only one instance of WebDriver is created and provides methods to access and quit the driver.
 */
public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    /**
     * Returns the WebDriver instance. If it doesn't exist, it creates a new one.
     * The driver is configured to maximize the window and set an implicit wait of 10 seconds.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * Quits the WebDriver instance and sets it to null.
     * This method should be called to clean up resources after tests are completed.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
