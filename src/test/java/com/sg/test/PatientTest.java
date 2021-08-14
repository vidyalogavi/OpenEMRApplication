package com.sg.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class PatientTest extends WebDriverWrapper
{
	@Test
	public void addPatient() throws InterruptedException
	{
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select s = new Select(driver.findElement(By.name("languageChoice")));
		s.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();
		driver.findElement(By.xpath("//div[text()='Patients']")).click();
		
		driver.switchTo().frame("fin");
		
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("pat");
		
		Select s1 = new Select(driver.findElement(By.id("form_title")));
		s1.selectByVisibleText("Ms.");
		
		driver.findElement(By.name("form_fname")).sendKeys("Abc2");
		driver.findElement(By.name("form_lname")).sendKeys("Def2");
		driver.findElement(By.id("form_DOB")).sendKeys("2021-08-12");
		
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class=\"xdsoft_today_button\"]"))));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//button[@class=\"xdsoft_today_button\"]"))).doubleClick().perform();
		
		Thread.sleep(2000);
		Select s2=new Select(driver.findElement(By.id("form_sex")));
		s2.selectByVisibleText("Female");
		
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		driver.findElement(By.xpath("//input[@value=\"Confirm Create New Patient\"]")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class=\"closeDlgIframe\"]")).click();

	}

}
