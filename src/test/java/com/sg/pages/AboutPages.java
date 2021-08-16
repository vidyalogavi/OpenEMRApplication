package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPages {
	
	private By headerLocator = By.tagName("h1");
	private By versionLocator = By.tagName("h4");
	
	WebDriver driver;
	public AboutPages(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getHeader()
	{
		return driver.findElement(headerLocator).getText();
	}

	public String getVersion()
	{
		return driver.findElement(versionLocator).getText();
	}
}
