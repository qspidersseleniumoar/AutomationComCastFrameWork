package com.comcast.orgnaizationtest;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.commonutils.BaseClass;
import com.comcast.commonutils.DataBaseUtilities;
import com.comcast.commonutils.ExcelUtility;
import com.comcast.commonutils.FileUtility;
import com.comcast.commonutils.JavaUtils;
import com.comcast.commonutils.WebDriverUTils;
import com.comcast.objectrepositorylib.Contacts;
import com.comcast.objectrepositorylib.CreateNewConatct;
import com.comcast.objectrepositorylib.CreateNewOrganization;
import com.comcast.objectrepositorylib.Home;
import com.comcast.objectrepositorylib.Login;
import com.comcast.objectrepositorylib.OrganizationInfo;
import com.comcast.objectrepositorylib.Organizations;

@Listeners(com.comcast.commonutils.ListenerImplemenation.class)
public class CreateOrganixzationTest extends BaseClass{
	@Test(groups = "SmokeTest")
	public void createOrg() throws Throwable {
          
		/*Test  Data*/
		String orgNAme = elib.getExcelData("Org", "tc_01", "OrgName")+JavaUtils.getRanDomData() ;
	 
	
		/*step 2 : navigate to  Organization page */
		Home hp = new Home(driver);
		hp.getOrgLnk().click();
		
		/*step 3 : navigate to create Organization Page*/
		Organizations orgPage = new Organizations(driver);
		orgPage.getCreateOrgImg().click();
		
		/*step 4 : create a Organization*/
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.creatOrganization(orgNAme);
		
		/*verify */
		OrganizationInfo orginfo = new OrganizationInfo(driver);
		String actMsg = orginfo.getSuccessFullMsg().getText();
		Assert.assertTrue(actMsg.contains(orgNAme));
		
	}
	
	
	

}







