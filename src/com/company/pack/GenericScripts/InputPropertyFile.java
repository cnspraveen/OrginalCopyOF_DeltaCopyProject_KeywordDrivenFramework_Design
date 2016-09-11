package com.company.pack.GenericScripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class InputPropertyFile 
{
	public static String Property(String PropFile, String KEY)
	{
		String value= "";
		Properties prop = new Properties();
		
		try{	prop.load(new FileInputStream(PropFile));
		        value = prop.getProperty(KEY);}
		catch(Exception e){System.out.println("Exception caught in  Property() ");}
		return value;
	   
	}

}
