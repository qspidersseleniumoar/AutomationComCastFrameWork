package com.comcast.conatcttest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.ListDocumentImpl.ListImpl;
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
import com.comcast.commonutils.ExcelUtility;
import com.comcast.commonutils.FileUtility;
import com.comcast.commonutils.JavaUtils;
import com.comcast.commonutils.WebDriverUTils;
import com.comcast.objectrepositorylib.Contacts;
import com.comcast.objectrepositorylib.CreateNewConatct;
import com.comcast.objectrepositorylib.Home;
import com.comcast.objectrepositorylib.Login;

@Listeners(com.comcast.commonutils.ListenerImplemenation.class)
public class CreateCoantctTest  extends BaseClass{

	@Test(groups = "SmokeTest")
	public void createConatct() throws Throwable {

		/*Test  Data*/
		String contactLastNAme  = elib.getExcelData("Contact", "tc_02", "LastName")+JavaUtils.getRanDomData();

			/*step 2 : navigate to  Organization page */
			Home hp = new Home(driver);
			hp.getContactLnk().click();
			
			/*step 3: navigate to create Contact Page*/
			Contacts cp = new Contacts(driver);
			cp.getCreateOrgImg().click();
			
			/*step 4 create Conatct with Org Name*/
			CreateNewConatct cnc = new CreateNewConatct(driver);
			cnc.createContact(contactLastNAme);		 
	}

}
