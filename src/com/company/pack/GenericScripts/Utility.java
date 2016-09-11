package com.company.pack.GenericScripts;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Response.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Utility 
{
	
  public  static String getFormatCurrentDate()
  {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			  String date = sdf.format(new Date());
			  System.out.println( "date is:  " + date);
			  return date;
  }
  
  public static String GetPageScreenShot(WebDriver  driver , String ImageFolderPath)
  {
	  String imagePath = ImageFolderPath + "/" + getFormatCurrentDate() + ".png";
	  EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	  try{
		  FileUtils.copyFile(edriver.getScreenshotAs(org.openqa.selenium.OutputType.FILE), new File(imagePath));}
	  catch(Exception e){System.out.println("Exception caught in GetPageScreenShot()");}
	  return imagePath;
  }
  
 
	

}
