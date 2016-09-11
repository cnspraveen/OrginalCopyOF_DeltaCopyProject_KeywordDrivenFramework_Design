package com.company.pack.MainScripts;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.company.pack.GenericScripts.Excel_Transactions;
import com.company.pack.GenericScripts.InputPropertyFile;
import com.company.pack.GenericScripts.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Delta extends BaseDriver
{
	public String PropertyFilePath = "./InputFile/propertiesFile/inputfile.properties";
	public String reportFilePath = "./report/result.html";
	//public String ScrenarioPath ="./InputFile/ExcelFile/ExcelFile.xlsx";
	public String ScrenarioPath ="./InputFile/ExcelFile/VariousTypesOFLocators.xlsx";
	public String imageFolderPath="./screenShots";
	public ExtentReports EReports;
	public ExtentTest ETest;
	public WebDriver driver;
	
	@BeforeTest
	public void InitFramework()
	{
		EReports = new ExtentReports(reportFilePath);
		String erpo =EReports.toString();
		System.out.println(erpo);
	}
	
	@AfterTest
	public void  endFramework()
	{
		EReports.flush();
	}
	
	/*@BeforeMethod
	public void AppLaunch()
	{
		String URL = InputPropertyFile.Property(PropertyFilePath, "url");
		String TimeOut = InputPropertyFile.Property(PropertyFilePath, "Time");
		Reporter.log(URL + "  :   TimeOut is  :  "  + TimeOut, true);
		
		
		System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TimeOut), TimeUnit.SECONDS);
		System.out.println(TimeOut);
	}/*
//======================================================
 */
	//Reading the Sheet from DataProvider
    /*@Test(dataProvider="getScenario")
	public void Login(String ScenarioSheet)
	{
		ETest = EReports.startTest(ScenarioSheet);
		
		int rc = Excel_Transactions.getRowCount(ScrenarioPath, ScenarioSheet);
		for(int j=1;j<=rc;j++)
		{
			String Desc = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, j, 0);
			String Action = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, j, 1);
			String ElementRepo = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, j, 2);
			String input = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, j, 3);
			
			String msg = Desc +  "  : " + Action +  "  : " + ElementRepo +  "  : " + input;
			Reporter.log(msg, true);
			ETest.log(LogStatus.INFO, msg);
			KeyWord.ExecuteKeyWord(driver, Action, ElementRepo, input);
		}

	}*/
//======================================================
 /*@Test(dataProvider ="getScenarios")
 public void LoginActitime(String ScenarioSheet, String ExecutionStatus)
 {
	 ETest = EReports.startTest(ScenarioSheet);
	 
	 if(ExecutionStatus.equalsIgnoreCase("Yes"))
	 {
		 int rcount2 = Excel_Transactions.getRowCount(ScrenarioPath, ScenarioSheet);
		 for(int k=1;k<=rcount2;k++)
		 {
			 String Desc = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 0);
			 String Action = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 1);
			 String ElementRepo = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 2);
			 String input = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 3);
			 String Msg  = Desc + " :   " + Action + " :   " +  ElementRepo + " : " + input;
			 Reporter.log(Msg, true);
			 ETest.log(LogStatus.INFO, Msg);
			 KeyWord.ExecuteKeyWord(driver, Action, ElementRepo, input);
			 //Assert.fail();
		 }
	 }
	 else
		{
			ETest.log(LogStatus.SKIP, "Execution Status is 'NO' ");
			throw new SkipException("Skipping this scenario");
		}
 } */
	
 //======================================================
	
	@BeforeMethod
	public void AppLaunch(XmlTest x)
	{
		String URL = InputPropertyFile.Property(PropertyFilePath, "url");
		String TimeOut = InputPropertyFile.Property(PropertyFilePath, "Time");
		Reporter.log(URL + "  :   TimeOut is  :  "  + TimeOut, true);
		
		String browserType = x.getParameter("browser");
		if(browserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./ExeFiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("ie is launched");
		}
		else if(browserType.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "./ExeFiles/chromedriver.exe");
		driver = new ChromeDriver();	
		System.out.println("chrome is launched");
		}
		else
		{
			driver = new FirefoxDriver();
			System.out.println("Firefox is launched");
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(TimeOut), TimeUnit.SECONDS);
		System.out.println(TimeOut);
	}
 @Test(dataProvider ="getMultipleScenarios")
 public void MultipleLoginActitime(String ScenarioSheet, String ExecutionStatus) throws InterruptedException
 {
	 ETest = EReports.startTest(ScenarioSheet);
	 
	 if(ExecutionStatus.equalsIgnoreCase("Yes"))
	 {
		 int rcount2 = Excel_Transactions.getRowCount(ScrenarioPath, ScenarioSheet);
		 for(int k=1;k<=rcount2;k++)
		 {
			 String Desc = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 0);
			 String Action = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 1);
			 String ElementRepo = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 2);
			 String input = Excel_Transactions.getCellValue(ScrenarioPath, ScenarioSheet, k, 3);
			 String Msg  = Desc + " :   " + Action + " :   " +  ElementRepo + " : " + input;
			 Reporter.log(Msg, true);
			 ETest.log(LogStatus.INFO, Msg);
			 KeyWord.ExecuteKeyWord(driver, Action, ElementRepo, input);
			 Assert.fail();
		 }
	 }
	 else    // Incase if Contorller file has   Execution Status column as "No", then this Block will get executed 
		{
			ETest.log(LogStatus.SKIP, "Execution Status is 'NO,Hence this case will SKIP (Login Scenario 2' ");
			throw new SkipException("Skipping this scenario");
		}
 }
	@AfterMethod
	public void quitApp(ITestResult test) throws InterruptedException
	{
		
		System.out.println(test.getStatus());
		if(test.getStatus() == test.FAILURE)  // or (test.getStatus()==2);
		{
			String imageFolder = Utility.GetPageScreenShot(driver, imageFolderPath);
			System.out.println(imageFolder);
			String P = ETest.addScreenCapture("." +imageFolder );
			ETest.log(LogStatus.FAIL, "Page csreen shot " + P);
		}
		EReports.endTest(ETest);
		//System.out.println("skipped");
		Thread.sleep(5000);
		driver.close();
	}
}
