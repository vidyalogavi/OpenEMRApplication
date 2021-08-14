package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		login.enterPassword(password);
		
		login.selectLanguage(language);
		
		login.clickLogin();
		
		DashboardPages dashboard = new DashboardPages(driver);
		dashboard.waitForPresenceOfFlowBoard();
		
		Assert.assertEquals(dashboard.getPageTitle(), expTitle);
	}
	
	@Test(dataProvider="invalidCredentialData" , dataProviderClass= DataProviderUtils.class)
	public void invalidCredentialTest(String username,String password, String language, String expError)
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		login.selectLanguage(language);
		
		login.clickLogin();
		Assert.assertEquals(login.getInvalidLoginMessage(),expError);

	}


}
