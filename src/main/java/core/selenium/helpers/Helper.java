package core.selenium.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class.
 */
public final class Helper {

    private Helper() {

    }

    /**
     * This method return a date using the format yyyy-MM-dd HH:mm:ss.
     * @return simpleDateFormat
     */
    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static void takeScreenShot(final WebDriver driver, final String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(filePath);
        srcFile.renameTo(targetFile);
    }
}
