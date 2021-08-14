package com.sg.test;

import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;

public class AckLiecenceAndCertTest extends WebDriverWrapper
{
	@Test
	public void ackLiecenceAndCertTest()
	{
		LoginPage login = new LoginPage(driver);
		login.clickAcknowledgmentsLicensingAndCertification();
	}

}
