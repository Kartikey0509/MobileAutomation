package test;

import static utility.ExtentReport.startTest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import pages.Login;
import pages.Skip;
import utility.BaseClass;

public class Runner extends BaseClass{
	
	@Test
	@Parameters({"username", "password"})
public void basePage(final String username, final String password, Method method) {
		
	Login lt = new Login(driver);
	Skip sk = new Skip(driver);
	ExtentTest test = startTest(
            method.getName(),
            "Test login screen on valid credentials"
        );
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	System.out.println("@@@@@");
	lt.setUserName(username);
	System.out.println("@@@@@");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	lt.setPassword(password);
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	lt.submit();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	sk.skipPage();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	lt.HBMenu();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	lt.signOut();
	
}	
	 @Test
	    public void loginWithIncorrectCredentials(Method method) {
		 Login lt = new Login(driver);
	    	Skip sk = new Skip(driver);
	        ExtentTest test = startTest(
	            method.getName(),
	            "Test error message on login screen with incorrect credentials"
	        );
	        test.assignAuthor("Kartikey");
	        test.assignCategory("Android", "WEConnect");
	        test.info("Waiting for login screen to load");
	        
	        test.info("Enter username");
	       lt.setUserName("idonotexist");
	        test.info("Enter password");
	        lt.setPassword("ialsodonotexist");
	        test.info("Tap Sign In");
	        lt.submit();
	        Assert.assertEquals(
	            lt.errorLoginText(),
	            "We didn't recognize the username or password you entered. Please try again."
	        );
	    }

	    @Test
	    public void failLoginTestWithIncorrectUser(Method method) {
	    	Login lt = new Login(driver);
	    	Skip sk = new Skip(driver);
	        ExtentTest test = startTest(
	            method.getName(),
	            "Failing a testcase for the demonstration"
	        );
	        test.assignAuthor("Kartikey");
	        test.assignCategory("Android", "WEConnect");
	        test.info("Waiting for login screen to load");
	       
	        test.info("Enter username");
	        lt.setUserName("idonotexist");
	        test.info("Enter password");
	        lt.setPassword("ialsodonotexist");
	        test.info("Tap Sign In");
	        lt.submit();
	        lt.errorLoginText();
	        Assert.fail(
	            "Entered wrong username or password"
	        );
	    }

	    @Test
	    public void skipLoginTest(Method method) {
	        ExtentTest test = startTest(
	            method.getName(),
	            "Failing a testcase for the demonstration"
	        );
	        test.assignAuthor("Kartikey");
	        test.assignCategory("Android", "WEConnect");
	        throw new SkipException("Skipping this Log.");
	    }
	}



