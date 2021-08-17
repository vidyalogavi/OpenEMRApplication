package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPages 
{
	WebDriver driver;
	public DashboardPages(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By flowBoardLocator = By.xpath("//div[text()='Flow Board']");
	private By AboutLocator = By.xpath("//div[text()='About']");
	private String mscframeName="msc";
	private By patientClientLocator = By.xpath("//div[text()='Patient/Client']");
	private By patientsLocator=By.xpath("//div[text()='Patients']");
	private By patientNameLocator = By.xpath("//a[@class='ptName']");
	
	
	public void waitForPresenceOfFlowBoard()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowBoardLocator));
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickAbout()
	{
		driver.findElement(AboutLocator).click();
	}
	
	public void switchToMSCFrame()
	{
		driver.switchTo().frame(mscframeName);
	}
	
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	public void mousehoverPatientClient()
	{
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(patientClientLocator)).perform();
	}
	
	public void selectPatients()
	{
		driver.findElement(patientsLocator).click();
	}
	
	public String getPatientName()
	{
		return driver.findElement(patientNameLocator).getText();
	}


}
