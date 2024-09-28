package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.function.*;


public class Login {
	private final AndroidDriver<AndroidElement> driver;
	private final WebDriverWait wait;
	private final static Logger Log = LogManager.getLogger(Login.class);
	
	

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='username']")
	AndroidElement uName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
	AndroidElement pswd;

	////android.view.View[@text=' Sign In'] (accessibility = " Sign In")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View[2]")
	AndroidElement signInBtn;

	@AndroidFindBy(id = "com.windstream.enterprise.we:id/contact_initials")
	AndroidElement DPBtn;
	
	@AndroidFindBy(id = "com.windstream.enterprise.we:id/id_signout_layout")
	AndroidElement signOutBtn;
	
	 @AndroidFindAll(
		        @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget" +
		            ".FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
		    )
		    public List<AndroidElement> middleElements;
	
	
	public Login(final AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 60);
		
		
		   Log.info("Waiting for login screen to load");
	        wait.until(ExpectedConditions.and(
	            ExpectedConditions.visibilityOf(uName),
	            ExpectedConditions.visibilityOf(pswd),
	            ExpectedConditions.visibilityOf(signInBtn)
	        ));
	    }
	

	public void setUserName(String username) {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		  Log.info("Enter username");
		uName.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		uName.sendKeys(username);
	}

	public void setPassword(String password) {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

		pswd.click();
		 Log.info("Enter password");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		pswd.sendKeys(password);
	}

	public void submit() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		 Log.info("Tap Sign In button");
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}

	public void HBMenu() {
		Log.info("Tap on Profile image");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		DPBtn.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	}

	public void signOut() {
		Log.info("Tap on Sign Out Button");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	    signOutBtn.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


}


	public String errorLoginText() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}