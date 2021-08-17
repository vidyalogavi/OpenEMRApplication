package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPages;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataProviderUtils;
import com.sg.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper
{
		
	@Test(dataProvider="validCredentialData" , dataProviderClass= DataProviderUtils.class)
	public void validCredentialTest(String username,String password, String language, String expTitle)
	{
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(username);
		test.log(Status.INFO, "Entered username as "+username);
		login.enterPassword(password);
		test.log(Status.INFO, "Entered passowrd as "+password);
		login.selectLanguage(language);
		test.log(Status.INFO, "Selected language as "+language);
		login.clickLogin();
		test.log(Status.INFO, "Clicked on Login");
		
		DashboardPages dashboard = new DashboardPages(driver);
		dashboard.waitForPresenceOfFlowBoard();
		test.log(Status.INFO, "Waited for presence of Flow Board");
		
		Assert.assertEquals(dashboard.getPageTitle(), expTitle);
	}
	
	@Test(dataProvider="invalidCredentialData" , dataProviderClass= DataProviderUtils.class)
	public void invalidCredentialTest(String username,String password, String language, String expError)
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		test.log(Status.INFO, "Entered username as "+username);
		login.enterPassword(password);
		test.log(Status.INFO, "Entered passowrd as "+password);
		login.selectLanguage(language);
		test.log(Status.INFO, "Selected language as "+language);
		login.clickLogin();
		test.log(Status.INFO, "Clicked on Login");
		
		Assert.assertEquals(login.getInvalidLoginMessage(),expError);

	}


}
