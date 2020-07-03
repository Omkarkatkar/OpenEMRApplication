package com.tieto.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	//john,john123
	//peter,peter123
	//paul,paul123
//	@DataProvider
//	public String[][] fillFormData()
//	{
//		String[][] main=new String[3][2];
//		// i --> number of test case
//		// j-->number of parameter
//		main[0][0]="john";
//		main[0][1]="john123";
//		
//		main[1][0]="peter";
//		main[1][1]="peter123";
//		
//		main[2][0]="paul";
//		main[2][1]="paul123";
//		
//		return main;
//	}
//	
//	@Test(dataProvider = "fillFormData")
//	public void fillFormTest(String username,String password)
//	{
//		System.out.println(username+password);
//	}
//	
	
	public void readProperties() throws IOException
	{
		FileInputStream file=new FileInputStream("TestData/OpenEMRData.xlsx");
		Properties prop = new Properties();
		prop.load(file);
		
		
		
	}
	
	
	//@Test
    public void excelRead() throws IOException {
       
        FileInputStream file = new FileInputStream("TestData/OpenEMRData.xlsx");
       
        XSSFWorkbook book = new XSSFWorkbook(file);
       
        XSSFSheet sheet = book.getSheet("validCredentialData");
        
        int rowCount= sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
        
        XSSFRow rowCheck=sheet.getRow(0);
        int cellCount= rowCheck.getPhysicalNumberOfCells();
        System.out.println(cellCount);
        Object[][] main= new Object[rowCount-1][cellCount];
        DataFormatter format= new DataFormatter();
     //   System.out.println(new DataFormatter().formatCellValue(sheet.getRow(1).getCell(0)));
       
        for(int r=1;r<rowCount;r++)
        {
        	XSSFRow row=sheet.getRow(r);
        	for(int c=0;c<cellCount;c++)
        	{
        		 XSSFCell cell=row.getCell(c);
        	               	    
        	       String cellValue= format.formatCellValue(cell);
        	      System.out.print( cellValue+ "\t");
        	       
        	       main[r-1][c]=cellValue;
        	}
        	System.out.println("");
        }
        book.close();
        file.close();
       
    }
}







