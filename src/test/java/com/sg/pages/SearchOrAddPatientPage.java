package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchOrAddPatientPage {
	WebDriver driver;
	public SearchOrAddPatientPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private String patframeName="pat"; 
	private By namePrefixLocator = By.id("form_title");
	private By firstNameLocator = By.name("form_fname");
	private By lastNameLocator = By.name("form_lname");
	private By dobLocator = By.id("form_DOB");
	private By genderLocator= By.id("form_sex");
	private By createNewPatientLocator =By.id("create");
	private By modalFrameLocator = By.xpath("//iframe[@id='modalframe']");
	private By confirmCreateNewPatientLocator= By.xpath("//input[@value=\"Confirm Create New Patient\"]");
	//private WebDriverWait wait = new WebDriverWait(driver,50);


	
	public void switchToPATFrame()
	{
		driver.switchTo().frame(patframeName);
	}
	
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}

	public void selectNamePrefix(String prefix)
	{
		Select selectNamePrefixLocator = new Select(driver.findElement(namePrefixLocator));
		selectNamePrefixLocator.selectByVisibleText(prefix);
	}
	
	public void setFirstName(String firstname)
	{
		driver.findElement(firstNameLocator).sendKeys(firstname);
	}
	
	public void setLastName(String lasttname)
	{
		driver.findElement(lastNameLocator).sendKeys(lasttname);
	}
	
	public void selectDOB(String dob)
	{
		driver.findElement(dobLocator).sendKeys(dob);
	}
	
	public void selectGender(String gender)
	{
		Select selectGenderLocator=new Select(driver.findElement(genderLocator));
		selectGenderLocator.selectByVisibleText(gender);
	}
	
	public void clickCreateNewPatient()
	{
		driver.findElement(createNewPatientLocator).click();
	}
	
	public void clickConfirmCreateNewPatient()
	{
		driver.findElement(confirmCreateNewPatientLocator).click();
	}
	
	public void switchToModalFrame()
	{
		driver.switchTo().frame(driver.findElement(modalFrameLocator));
	}
	
	public void waitForAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertString()
	{
		
		return driver.switchTo().alert().getText();
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
}
