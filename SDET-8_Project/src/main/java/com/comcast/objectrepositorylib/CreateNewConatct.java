package com.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.commonutils.WebDriverUTils;



public class CreateNewConatct  extends WebDriverUTils{
	
	WebDriver driver;
	public CreateNewConatct(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	  private WebElement organizationLookUpImage;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	/**
	 * Ragvendra
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContact(String lastName , String orgName) {
		lastNameEdt.sendKeys(lastName);
		organizationLookUpImage.click();
		switchToWindow(driver, "Accounts&action");
		Organizations op = new Organizations(driver);
		op.getSearchEdt().sendKeys(orgName);
		op.getSearchNow().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
}
