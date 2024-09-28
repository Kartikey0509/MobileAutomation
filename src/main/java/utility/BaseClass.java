package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public AndroidDriver<AndroidElement> driver;
	  public AndroidDriver<AndroidElement> getDriver() {
	        return this.driver;
	    }
	
	@BeforeMethod
	public void BrowserCall()throws MalformedURLException {
		
		File f = new File("src/test/resources/app");
		File fs= new File(f,"mobile-we-universal-prod (14).apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
