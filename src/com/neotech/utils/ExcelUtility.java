package com.neotech.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;
	
private static void openExcel(String filePath) {
	try {
		FileInputStream fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	public static void loadSheet(String sheetName)
	{
		sheet=book.getSheet(sheetName);
	}
	
	public static int rowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colCount(int rowIndex)
	{
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	public static String cellData(int rowIndex, int colIndex)
	{
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	//return a 2D-String Array
	public static Object[][] excelIntoArray(String filePath, String sheetName)
	{
		openExcel(filePath);
		loadSheet(sheetName);
		int rows= rowCount();
		int cols = colCount(0);
		
		
		//I used row-1 to skip the header
		Object[][] data = new Object[rows-1][cols];
		
		//iterating rows
		//Starting from1 to skip the header
		
		for(int row=1; row<rows; row++)
		{
			for(int col=0; col<cols; col++)
			{   //Read from excel into 2D-Object Array
				data[row-1][col]= cellData(row, col);
			}
		}
		
		
		//return the object that has been filled
		return data;
	}
	
	
}

