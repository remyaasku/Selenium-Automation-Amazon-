package com.amazon.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.amazon.base.TestBase;

public class TestUtil extends TestBase{
		public static  long PAGE_LOAD_TIMEOUT=20;
	    public static  long IMPLICIT_WAIT = 10;	
	    
	    public void switchToFrame() {
	    	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	    }
	    
	    public static Object[][] testData(String filePath,String sheetName) throws IOException{
			
			FileInputStream fis=new FileInputStream(filePath);
			XSSFWorkbook workbook =new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			int rowCount=sheet.getPhysicalNumberOfRows();
			int colCount=sheet.getRow(0).getLastCellNum();
			Object[][] data=new Object[rowCount-1][colCount];
			for(int i=0;i<rowCount-1;i++) {
				XSSFRow row=sheet.getRow(i+1);
				
				for(int j=0;j<colCount;j++) {
					
				XSSFCell element=row.getCell(j)	;
				
				if (element== null)
					data[i][j]="";
				else {
					
					element.setCellType(CellType.STRING);
					data[i][j]=element.getStringCellValue();
				}
				}
				
			}
			return data;
		}

	
}
