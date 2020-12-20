package pac;

import java.awt.Desktop.Action;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HAndleClenderWindowAndSelectFutureDate {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		try {
			driver.findElement(By.xpath("//span[text()='Google']")).isEnabled();
			Actions act = new Actions(driver);
			act.moveByOffset(100, 100).click().perform();
			act.clickAndHold().perform();;
			act.moveByOffset(120, 10).perform();
		}catch (Exception e) {
			System.out.println("handle");
		}
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='From']")));		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Bengaluru, India']")));
		driver.findElement(By.xpath("//p[text()='Bengaluru, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Goa");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text()='Goa, India']"),"Goa, India"));
		driver.findElement(By.xpath("//p[text()='Goa, India']")).click();
		
		//select next year date
        while(true) {
			try {
			   driver.findElement(By.xpath("//div[contains(@aria-label,'Jun 11 2021')]")).click();
			   break;
			}catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
        }
		
	}

}
