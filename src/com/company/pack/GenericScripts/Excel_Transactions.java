package com.company.pack.GenericScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Excel_Transactions
{
	@Test
	public static int getRowCount(String xlpath, String sheet)
	{
    int rc=0;
	try{rc = WorkbookFactory.create(new FileInputStream(xlpath)).getSheet(sheet).getLastRowNum();
           System.out.println(rc);}
	catch(Exception e){System.out.println("Exception is caught in GetRowCount()");}
	return rc;
    }
	
	@Test
	public static String getCellValue(String xlpath, String sheet, int r, int c)
	{
		String s="";
		try{		s = WorkbookFactory.create(new FileInputStream(xlpath)).getSheet(sheet).getRow(r).getCell(c).toString();
		            //System.out.println(s);
		     }
		catch(Exception e){System.out.println("Exception is caught in getCellValue()");}
		return s;
	}
	
	
	}
