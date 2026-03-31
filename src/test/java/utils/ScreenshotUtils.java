package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for taking screenshots during test execution.
 * It provides methods to take screenshots for both passed and failed tests, saving them in organized directories.
 */
public class ScreenshotUtils {
    private static final String EVIDENCE_DIR = "evidence/";
    private static final String FAILURES_DIR = "screenshots/";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    /**
     * Takes a screenshot when a test passes, saving it in the evidence directory with the format
     * <testName>_PASS_<timestamp>.png.
     *
     * @param driver the WebDriver instance to take the screenshot from
     * @param testName the name of the test method, used to name the screenshot file
     */
    public static void takeEvidenceScreenshot(WebDriver driver, String testName) {
        saveScreenshot(driver, EVIDENCE_DIR, testName + "_PASS");
    }

    /**
     * Takes a screenshot when a test fails, saving it in the screenshots directory with the format
     * <testName>_FAIL_<timestamp>.png.
     *
     * @param driver the WebDriver instance to take the screenshot from
     * @param testName the name of the test method, used to name the screenshot file
     */
    public static void takeScreenshot(WebDriver driver, String testName) {
        saveScreenshot(driver, FAILURES_DIR, testName + "_FAIL");
    }

    /**
     * Helper method to save a screenshot to the specified folder with a timestamped filename.
     *
     * @param driver the WebDriver instance to take the screenshot from
     * @param folder the folder where the screenshot will be saved
     * @param baseName the base name for the screenshot file, which will be appended with a timestamp
     */
    private static void saveScreenshot(WebDriver driver, String folder, String baseName) {
        try {
            String timestamp = LocalDateTime.now().format(FORMATTER);
            String fileName = baseName + "_" + timestamp + ".png";
            File destFile = new File(folder + fileName);
            destFile.getParentFile().mkdirs();

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("Screenshot saved: " + destFile.getPath());
        } catch (IOException e) {
            System.err.println("Not possible to save screenshot: " + e.getMessage());
        }
    }
}
