package com.sg.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class WebDriverWrapper 
{
	
	protected WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void start() {
		if(extent == null)
		{
			extent = new ExtentReports();
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("src/test/resources/report/testReport.html");
			extent.attachReporter(htmlReporter);
		}
	}

	@AfterSuite
	public void end() {
		// to write or update test information to reporter
		extent.flush();
	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(@Optional("ch") String browser, Method method)
	{
		
		if(browser.equals("ch"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();			
		}
		else if(browser.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.openemr.io/b/openemr/");
		test = extent.createTest(method.getName());
	}
	
    @AfterMethod
    public void tearDown(ITestResult result)
    {
    	if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
    	driver.quit();
    }

}
