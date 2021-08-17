package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPages;
import com.sg.pages.LoginPage;
import com.sg.pages.PatientFinderPage;
import com.sg.pages.SearchOrAddPatientPage;
import com.sg.utilities.DataProviderUtils;


public class PatientTest extends WebDriverWrapper
{
	@Test(dataProvider="commonDataProvider" , dataProviderClass= DataProviderUtils.class)
	public void addPatientTest(String username,String password,String language,String nameprefix,String pfname, String plname, String dob, String gender) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(username);
		test.log(Status.INFO, "Entered username as "+username);
		login.enterPassword(password);
		test.log(Status.INFO, "Entered passowrd as "+password);
		login.selectLanguage(language);
		test.log(Status.INFO, "Selected language as "+language);
		login.clickLogin();
		test.log(Status.INFO, "Clicked on Login");
		
		DashboardPages dashboard = new DashboardPages(driver);
		
		dashboard.mousehoverPatientClient();
		test.log(Status.INFO, "Cursor Moved on Patient/Client");
		dashboard.selectPatients();	
		test.log(Status.INFO, "Selected Patients");
		
		PatientFinderPage patientfind = new PatientFinderPage(driver);
		patientfind.switchToFinFrame();	
		test.log(Status.INFO, "Switched to Fin Frame");
		patientfind.clickAddNewPatient();
		test.log(Status.INFO, "Clicked on Add New Patient");
		patientfind.switchToDefaultFrame();
		test.log(Status.INFO, "Switched back to default content");
		
		SearchOrAddPatientPage searchoraddpatient = new SearchOrAddPatientPage(driver);
		searchoraddpatient.switchToPATFrame();
		test.log(Status.INFO, "Switched to PAT Frame");
		searchoraddpatient.selectNamePrefix(nameprefix);
		test.log(Status.INFO, "Selected Name prefix as: "+ nameprefix);
		searchoraddpatient.setFirstName(pfname);
		test.log(Status.INFO, "Selected First Name as: "+ pfname);
		searchoraddpatient.setLastName(plname);
		test.log(Status.INFO, "Selected Last Name as: "+ plname);
		searchoraddpatient.selectDOB(dob);
		test.log(Status.INFO, "Selected Date of Birth as: "+ dob);
		searchoraddpatient.selectGender(gender);
		test.log(Status.INFO, "Selected Gender as: "+ gender);
		searchoraddpatient.clickCreateNewPatient();
		test.log(Status.INFO, "Clicked on Create New Patient");
		searchoraddpatient.switchToDefaultFrame();
		test.log(Status.INFO, "Switched back to default content");
		searchoraddpatient.switchToModalFrame();
		test.log(Status.INFO, "Switched to Modal Frame");
		searchoraddpatient.clickConfirmCreateNewPatient();
		test.log(Status.INFO, "Clicked on Confirm Create New Patient");
		searchoraddpatient.waitForAlert();
		test.log(Status.INFO, "Waited for Alert");
		searchoraddpatient.acceptAlert();
		test.log(Status.INFO, "Accepted Alert");
		searchoraddpatient.switchToDefaultFrame();
		test.log(Status.INFO, "Switched back to default content");

		Assert.assertTrue(dashboard.getPatientName().contains(pfname));
		

	}

}
