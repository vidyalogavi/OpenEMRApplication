package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		login.enterPassword(password);
		
		login.selectLanguage(language);
		
		login.clickLogin();
		
		DashboardPages dashboard = new DashboardPages(driver);
		
		
		dashboard.clickAbout();
		
		dashboard.switchToMSCFrame();
		
		AboutPages about = new AboutPages(driver);
		String actHeader=about.getHeader();
		String actVersion=about.getVersion();
		
		dashboard.switchToDefaultFrame();
		
		Assert.assertEquals(actHeader, expHeader);
		Assert.assertTrue(actVersion.contains(expVersion));
	}

}
