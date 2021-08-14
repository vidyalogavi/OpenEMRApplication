package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By languageLocator = By.name("languageChoice");
	private By loginButtonLocator = By.xpath("//button[@type=\"submit\"]");
	private By ackLiecenceAndCertTestLocator = By.linkText("Acknowledgments, Licensing and Certification");
	private By descriptionLocator=By.xpath("//p[contains(text(),'The most')]");
	private By errorMessageLocator = By.xpath("//div[contains(text(),'Invalid')]");
	
	public void enterUsername(String username)
	{
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password)
	{
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void selectLanguage(String language)
	{
		Select s = new Select(driver.findElement(languageLocator));
		s.selectByVisibleText(language);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButtonLocator).click();
	}
	
	public void clickAcknowledgmentsLicensingAndCertification()
	{
		driver.findElement(ackLiecenceAndCertTestLocator).click();
	}
	
	public String getApplicationDescription()
	{
		return driver.findElement(descriptionLocator).getText();
	}
	
	public String getInvalidLoginMessage()
	{
		return driver.findElement(errorMessageLocator).getText();

	}

}
