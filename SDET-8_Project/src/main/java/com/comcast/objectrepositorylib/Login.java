package com.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {            // Rule 1 : create a separte java class for Every page in a Application
	
	public Login(WebDriver driver){          //Rule 4 :   provoide a single arg constructor which driver argument as refernce , inside                                           // pageFactory class to execute all the @findBy annotation & intilze the element at the time object creation
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")           // Rule 2 : IDentify all the elemnets using @findBy & @findBys annoation & store them in specific java Class
	private WebElement userNameEdt;
	
	                                   
	@FindBy(name="user_password")      
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUserNameEdt() {  // Rule  3 : decalre all the WebElements in private & provide public getters mtd to provide read access to test scripts 
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	public void loginToApp(String username , String password) {  //Rule 5 : Busniess /WorkFlow Lib
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}

}
