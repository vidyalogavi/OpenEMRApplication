package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.AboutPages;
import com.sg.pages.DashboardPages;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataProviderUtils;

public class AboutTest extends WebDriverWrapper {
	
	@Test(dataProvider="commonDataProvider" , dataProviderClass= DataProviderUtils.class)
	public void checkAboutHeaderAndVersionTest(String username,String password,String language,String expHeader,String expVersion) throws InterruptedException
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
		
		dashboard.clickAbout();
		test.log(Status.INFO, "Clicked on About");
		dashboard.switchToMSCFrame();
		test.log(Status.INFO, "Switched to MSC Frame");
		
		AboutPages about = new AboutPages(driver);
		String actHeader=about.getHeader();
		test.log(Status.INFO, "Captured Header");
		String actVersion=about.getVersion();
		test.log(Status.INFO, "Captured Version Number");
		
		dashboard.switchToDefaultFrame();
		
		Assert.assertEquals(actHeader, expHeader);
		Assert.assertTrue(actVersion.contains(expVersion));
	}

}
