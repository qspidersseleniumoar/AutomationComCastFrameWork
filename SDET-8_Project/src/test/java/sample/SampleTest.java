package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.objectrepositorylib.Login;

public class SampleTest {
	
	@Test
	public void sampleTest() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
            Login lp = new Login(driver);//
            
          
          
            lp.loginToApp("admin", "admin");
		
	}

}
