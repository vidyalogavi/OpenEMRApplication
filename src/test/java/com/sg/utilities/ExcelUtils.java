package com.sg.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {
	
	public static Object[][] getSheetToObjectArray(String FilePath, String sheetName) throws IOException
	{
		FileInputStream fin = new FileInputStream(FilePath);
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sheet=book.getSheet(sheetName);
	
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(1).getPhysicalNumberOfCells();	
		
		DataFormatter format = new DataFormatter();
		
		Object[][] main=new Object[rowNum-1][colNum];
		
		for (int i=1;i<rowNum;i++)
		{
			for(int j=0;j<colNum;j++) 
			{
				XSSFRow row = sheet.getRow(i);				
				XSSFCell cell = row.getCell(j);				
				main[i-1][j]=format.formatCellValue(cell);		
				
			}
		}
		
		return main;
	}

}
