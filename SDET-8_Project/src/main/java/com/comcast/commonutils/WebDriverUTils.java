package com.comcast.commonutils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import bsh.commands.dir;

/**
 * This class contains webDriver specific libarraies , which used to handle DropdWon , Popups . wait statmnet , action
 * @author Deepak
 *
 */
public class WebDriverUTils {
	/**
	 *  used to select the value from the dropDwon based on visible text
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , String data) {
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	
	/**
	 *  used to select the value from the dropDwon based on index
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * switch to any window based on Window title
	 * @param windowPartialTitle
	 */
	public void switchToWindow(WebDriver driver ,String windowParatilTitle) {
		 //switchTo new Window
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			if(driver.getCurrentUrl().contains(windowParatilTitle)) {
				break;
			}
		 }
	}
	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForPageTitle(WebDriver driver , String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
		
	}
	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForElemnetToBeClickable(WebDriver driver , WebElement elemnet){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(elemnet));
		
	}
	
/**
 *   wait for elemnet to be avibale
 * @param driver
 * @param elemnetXpath
 * @throws InterruptedException
 */
	public void waitForElementXpath(WebDriver driver , String elemnetXpath) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 driver.findElement(By.xpath(elemnetXpath)).isEnabled();
				 break;
			 }catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	/**
	 * used to perfrom mouse movement action on the elemnet
	 * @param driver
	 * @param elemnet
	 */
	public void moveMouseToElemnet(WebDriver driver , WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * used to perfrom rightClcik movement action on the elemnet
	 * @param driver
	 * @param elemnet
	 */
	public void rightClick(WebDriver driver , WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void accpetAllert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAllert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
      
        
}







