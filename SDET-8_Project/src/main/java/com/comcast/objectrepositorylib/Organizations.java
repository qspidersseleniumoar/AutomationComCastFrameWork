package com.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	
	public Organizations(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgImg;

	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchNow;
	
	
	
	
	
	
	public WebElement getInDropDown() {
		return inDropDown;
	}






	public WebElement getSearchEdt() {
		return searchEdt;
	}






	public WebElement getSearchNow() {
		return searchNow;
	}






	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	

}
