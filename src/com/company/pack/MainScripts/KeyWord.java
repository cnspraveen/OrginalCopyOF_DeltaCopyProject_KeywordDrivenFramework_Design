package com.company.pack.MainScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyWord
{
  /* public static void ExecuteKeyWord(WebDriver driver,String Action, String ElementRepo, String input )
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   driver.findElement(By.xpath(ElementRepo)).sendKeys(input);
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   driver.findElement(By.xpath(ElementRepo)).click();
	   }
	   else
	   {
		   System.out.println("invalid action"+Action);
	   }
   } */
   
   
   
   public static void ExecuteKeyWord(WebDriver driver, String Action, String ElementRepo, String input) throws InterruptedException
   {
	   if(Action.equalsIgnoreCase("Enter"))
	   {
		   driver.findElement(Locator.getLocator(ElementRepo)).sendKeys(input);
	   }
	   else if(Action.equalsIgnoreCase("Click"))
	   {
		   Thread.sleep(2000);
		   driver.findElement(Locator.getLocator(ElementRepo)).click();
	   }
	   else
	   {
		   System.out.println("invalid action"+Action);
	   }
}
}
