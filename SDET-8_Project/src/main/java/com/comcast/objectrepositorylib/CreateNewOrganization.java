package com.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comcast.commonutils.WebDriverUTils;


/**
 * 
 * @author Deepak
 * @author Ram
 *
 */
public class CreateNewOrganization extends WebDriverUTils{
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industriesLst;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "accounttype")
	private WebElement typeLst;
	
	@FindBy(name = "rating")
	private WebElement ratingLst;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustriesLst() {
		return industriesLst;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	

	/**
	 *  used to create org with mandatory feilds  
	 * @param orgName
	 */
	public void creatOrganization(String orgName) {
		orgNameEdt.sendKeys(orgName);
		waitForElemnetToBeClickable(driver, saveBtn);
		saveBtn.click();
		
	}
	/**
	 * used create orgnization with below parameter
	 * @param orgName
	 * @param indsutry
	 * @param type
	 * @param rating
	 */
	public void creatOrganization(String orgName , String indsutry, String type , String rating) {
		orgNameEdt.sendKeys(orgName);
		select(industriesLst, indsutry);
		select(typeLst, type);
		select(ratingLst, rating);
		saveBtn.click();
	}
	
	public void creatOrganization(String orgName , String indsutry) {
		orgNameEdt.sendKeys(orgName);
		select(industriesLst, indsutry);

		saveBtn.click();
	}
	
}
