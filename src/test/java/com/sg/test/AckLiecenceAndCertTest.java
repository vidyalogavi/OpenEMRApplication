package com.sg.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.AcknowledgmentsLicensingAndCertificationPage;
import com.sg.pages.LoginPage;

public class AckLiecenceAndCertTest extends WebDriverWrapper
{
	@Test
	public void ackLiecenceAndCertTest()
	{
		LoginPage login = new LoginPage(driver);		
		login.clickAcknowledgmentsLicensingAndCertification();
		test.log(Status.INFO, "Clicked on Acknowledgments Licensing And Certification");
		
		AcknowledgmentsLicensingAndCertificationPage ack= new AcknowledgmentsLicensingAndCertificationPage(driver);
	
		String s_winID=ack.getWinID()[1];		
		ack.switchToAckWindow(s_winID);
		test.log(Status.INFO, "Switch focus to Acknowledgments Licensing And Certification page");
		
		String actTitle = ack.getTitle();
		test.log(Status.INFO, "Captured the Page Title");
		
		Assert.assertEquals(actTitle, "Acknowledgments, Licensing and Certification");
		
	}

}
