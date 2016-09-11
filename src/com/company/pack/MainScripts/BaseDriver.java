package com.company.pack.MainScripts;

import org.testng.annotations.DataProvider;

import com.company.pack.GenericScripts.Excel_Transactions;

public class BaseDriver
{
	public String Controllerpath = "./InputFile/ExcelFile/Controller.xlsx";
	public String suiteSheet = "Sheet1";
	
   @DataProvider     // Using ExcelFile.xlsx  (which has  LoginScenario   & LoginScenario2 sheets)
   public String[][] getScenario()
   {
	   String[][] data = new String[2][1];
	   data[0][0] = "LoginScenario";
	   data[1][0]=  "LoginScenario2";
	   return data;
   }
   
   @DataProvider   //(Reading only 1 row (2 columns)  by using Contoller File 
   public String[][] getScenarios()
   {
	   
	   String[][] data2 = new String[1][2];
	   
	   data2[0][0] = Excel_Transactions.getCellValue(Controllerpath, suiteSheet, 1, 0);
	   data2[0][1]  = Excel_Transactions.getCellValue(Controllerpath, suiteSheet, 1, 1);
	   return data2;
   }
  
   @DataProvider   //(Reading Multiple rows (Multiple columns)  by using Contoller File 
   public String[][] getMultipleScenarios()
   {
	   int ScenarioCount = Excel_Transactions.getRowCount(Controllerpath, suiteSheet);
	   String[][] data2 = new String[ScenarioCount][2];
	   
	   for(int j=1;j<=ScenarioCount;j++)
	   {
	   data2[j-1][0] = Excel_Transactions.getCellValue(Controllerpath, suiteSheet, j, 0);
	   data2[j-1][1]  = Excel_Transactions.getCellValue(Controllerpath, suiteSheet, j, 1);
	   }
	   return data2;
   }

}
