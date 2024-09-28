package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Screenshot {
	    private static String screenshotFilename(final String testCaseName) {
	        return Paths.get(
	            System.getProperty("user.dir"), "target", "screenshots", testCaseName + ".png"
	        ).toString();
	    }

	    public static String takeScreenshot(String testCaseName, AndroidDriver<AndroidElement> driver) throws IOException {
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String filename = screenshotFilename(testCaseName);
	        FileUtils.copyFile(source, new File(filename));
	        return filename;
	    }
	}


