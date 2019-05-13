package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.hubspot.BasePage.basePage;

public class ExcelUtil
{
	
	public static String TESTDATA_SHEET_PATH="/Users/bharat/eclipse-workspace/MarchPOMSeries_bharat/src/main/java/com/qa/hubspot/testdata/apptestdata.xlsx";

	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname)
	{
		// fetch the data from excel sheet:
		
		System.out.println("SheetName :: " + sheetname);
		
		FileInputStream file=null;
		
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try 
		{
			book= WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		sheet = book.getSheet(sheetname);
		
		System.out.println("*************");
		
		System.out.println("Get Last Row Numver :: "  + sheet.getLastRowNum());
		System.out.println("Get Last Cell/Column Numver :: "  + sheet.getRow(0).getLastCellNum());
		
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // rows =100,column = 4
		
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;

	}
	
}
