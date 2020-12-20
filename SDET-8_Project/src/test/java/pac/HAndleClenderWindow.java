package pac;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HAndleClenderWindow {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='From']")));		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Bengaluru, India']")));
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Goa");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Goa, India']")));
		driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
		
		
		  Date dateObj = new Date(); 
		  String curentSystemtDate = dateObj.toString(); 
        System.out.println(curentSystemtDate);    //Fri Dec 11 15:51:55 IST 2020
        String[] arr = curentSystemtDate.split(" ");
        String day = arr[0];
        String date = arr[2];
        String month = arr[1];
        String year = arr[5];
        
		
		String x = "//div[@aria-label='"+day+" "+month+" "+date+" "+year+"']";    //dynamic Xpath
		driver.findElement(By.xpath(x)).click();
		
	}

}
