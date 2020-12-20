package sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDyanamicWebtable_1 {

	public static void main(String[] args) {

		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		String expData = "Abin994";
		int actRowCount = 0;
		
		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a"));
		
	       for(WebElement wb : lst) {
	    	  String actData = wb.getText();
	    	  if(expData.equals(actData)) {
	    		 
	    		  break;
	    	  }
	    	  actRowCount++;
	    	  
	       } 
	       
	       List<WebElement> lst2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr["+(actRowCount+2)+"]/td[*]/*"));
          for(WebElement wb : lst2) {
        	  System.out.println(wb.getText());
   
          }

	}

}
