package com.sg.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper
{

	
	
	@Test
	public void validCredentialTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select s = new Select(driver.findElement(By.name("languageChoice")));
		s.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		String actString =driver.getTitle();
		System.out.println(actString);
		Assert.assertEquals(actString, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin1");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select s = new Select(driver.findElement(By.name("languageChoice")));
		s.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actMSG=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		Assert.assertEquals(actMSG,"Invalid username or password");

	}


}
