package com.comcast.commonutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Deepak
 *
 */
public class ExcelUtility {
	
   /**
    * used to read the data from excel workook based on
    * @param shettName
    * @param rowNum
    * @param colNum
    * @return
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * @throws Throwable
    */
	public String getExcelData(String sheetName , int rowNum , int colNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		wb.close();
		return row.getCell(colNum).getStringCellValue();
				
	}
	
	/**
	 * used to read the data from excel workbook based on testId & ColumnHeader
	 * @param sheetName
	 * @param expTestID
	 * @param expColHEader
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName , String expTestID , String expColHEader) throws Throwable {
		
				int expTestRow = 0;
				int expHeader = 0;
				FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rowCount = sh.getLastRowNum();
			    
		    for(int i=0; i<rowCount ; i++) {		
				Row row = sh.getRow(i);
				String zeroColData= row.getCell(0).getStringCellValue();
		        if(expTestID.contentEquals(zeroColData)) {
		        	//System.out.println("test is availbale");
		        	expTestRow = i;
		        	break;
		        }
		    }
		    
		    int expColHeader = expTestRow-1;
		    
		        int colCount = sh.getRow(expColHeader).getLastCellNum();
		         for(int j=0 ; j <colCount ; j++) {
		        	   String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
		        	   if(actColHeader.equals(expColHEader)) {
		        		        //System.out.println("header is avibale ");
		        		        expHeader = j;
		        		        break;
		        	   }
		         }
		         
      return sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();
				
	}
	
	
	/**
	 * used to set data back to excel based on parameter
	 * @param shettName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setExcelData(String shettName , int rowNum , int colNum ,String data) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IConstant.excelFilePath);
				wb.write(fos);
		wb.close();
	}
	/**
	 * used to get the excel used row count
	 * @param shettName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String shettName)throws Throwable {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
	
		return sh.getLastRowNum();
				
	}
	
	
	
	
}









