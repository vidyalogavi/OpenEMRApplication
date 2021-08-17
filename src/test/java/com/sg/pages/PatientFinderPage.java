package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {
	WebDriver driver;
	private String finframeName="fin"; 
	private By addNewPatientLocator= By.id("create_patient_btn1");

	public PatientFinderPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchToFinFrame()
	{
		driver.switchTo().frame(finframeName);
	}
	
	public void clickAddNewPatient()
	{
		driver.findElement(addNewPatientLocator).click();
	}
	
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}

}
