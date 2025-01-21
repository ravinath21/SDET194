package selenium;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Screen {

    public static void takeScreenshot(String stepName) throws IOException {
        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://selenium.dev");

            // Explicit wait for an element on the page to be visible
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            String TCName = "TC_001";
            String dir = System.getProperty("user.dir");

            // Use Timestamp
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String formattedTimestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(timestamp);

            String path = dir + "/src/test/resources/screenshots/" + TCName + "/screenshot_" + stepName + "_" + formattedTimestamp + ".jpeg";

            File destFile = new File(path);

            // Create directories if they do not exist  - Another change from Ravi's github
            destFile.getParentFile().mkdirs();

            FileUtils.copyFile(srcFile, destFile);
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) throws IOException {
        takeScreenshot("SeleniumHomePage");
    }
}



