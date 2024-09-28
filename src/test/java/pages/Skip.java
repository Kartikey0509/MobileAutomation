package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Skip {
	public AndroidDriver<AndroidElement> driver;
	private final WebDriverWait wait;
	 public Skip(final AndroidDriver<AndroidElement> driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	        wait = new WebDriverWait(this.driver, 60);
	       
	 }

	@AndroidFindBy(id = "com.windstream.enterprise.we:id/skip")
	AndroidElement skipBtn;

	public void skipPage() {
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		skipBtn.click();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	}

}
