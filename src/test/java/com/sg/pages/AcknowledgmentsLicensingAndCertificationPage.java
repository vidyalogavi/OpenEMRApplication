package com.sg.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class AcknowledgmentsLicensingAndCertificationPage {
	WebDriver driver;
	public AcknowledgmentsLicensingAndCertificationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String[] getWinID()
	{
		Set<String> winID = driver.getWindowHandles();
		Iterator<String> it = winID.iterator();
		String[] win_ID= new String[2];
		win_ID[0]=it.next();
		win_ID[1]=it.next();
		
		return win_ID;
	}
	
	public void switchToAckWindow(String s_winID)
	{
		driver.switchTo().window(s_winID);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}

}
