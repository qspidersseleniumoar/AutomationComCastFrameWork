package com.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {
	public ContactInfo(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successFullMSG;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInfo;

	public WebElement getSuccessFullMSG() {
		return successFullMSG;
	}

	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}
	
	
	
}
