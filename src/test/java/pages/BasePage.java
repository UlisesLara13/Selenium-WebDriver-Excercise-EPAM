package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class that provides common functionalities for all page classes.
 * It includes methods for safe clicking, scrolling into view, and removing ads.
 */
public class BasePage {

    protected final Logger log = LogManager.getLogger(getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        log.debug("Initializing page: {}", getClass().getSimpleName());
    }

    /**
     * Clicks on a web element safely by ensuring it's visible, removing ads, and scrolling into view.
     *
     * @param element The WebElement to be clicked.
     */
    protected void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        removeAds();
        scrollIntoView(element);
        pause(300);
        log.debug("Clicking element: {}", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls the specified web element into view using JavaScript.
     *
     * @param element The WebElement to be scrolled into view.
     */
    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Removes all iframes from the page to prevent interference with interactions.
     */
    protected void removeAds() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(el => el.remove());"
        );
    }

    /**
     * Pauses the execution for a specified duration.
     *
     * @param millis The duration in milliseconds to pause the execution.
     */
    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
