package com.sampleproject.testyantra.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using Apache POI libraries which is used to handle Microsoft excel sheet.
 * @author Chetan
 *
 */
public class ExcelUtility {

	/**
	 * This method is used to read the data from excel based on below arguments.
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/productModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		String data = cell.getStringCellValue();
		wb.close();
		return data;
	}
	
//	public String getDataFromExcel(String sheetName, int rowNum, int celNum, boolean b) throws Throwable {
//		FileInputStream fis = new FileInputStream("./testData/productModuleData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(sheetName);
//		Row row = sh.getRow(rowNum);
//		Cell cell = row.getCell(celNum);
//		String data = cell.getStringCellValue();
//		wb.close();
//		return data;
//	}
	
	/**
	 * This method is used to get the last used row number on specified sheet.
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/productModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	public void setDataToExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/productModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testData/productModuleData.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
