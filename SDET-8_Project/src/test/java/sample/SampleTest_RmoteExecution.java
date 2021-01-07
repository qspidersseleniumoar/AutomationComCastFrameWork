package sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.dom.ParentSetter;

public class SampleTest_RmoteExecution {
	
	RemoteWebDriver driver;
	
	
   @Parameters("browser")
	@BeforeClass
	public void beforeclass(String BROWSER) throws MalformedURLException {
		DesiredCapabilities caps= null;
		URL url = new URL("http://13.235.24.60:4444/wd/hub");
		caps = DesiredCapabilities.firefox();
	
		  if(BROWSER.equals("chrome")) 
		  { caps = DesiredCapabilities.chrome(); } else if
		  (BROWSER.equals("firefox")) { caps = DesiredCapabilities.firefox(); }
		 
		 driver = new RemoteWebDriver(url, caps);
	}
	@Test
	public void sampleTest() throws MalformedURLException {
		
	
		driver.get("http://gmail.com");
		
		
	}

}
