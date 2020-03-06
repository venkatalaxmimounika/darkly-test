package com.darkly.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {
	
	//get data from excel file
	public static String getDataFromExcel(String fileName,String sheetName,int rowIndex,int cellIndex) {
	String data = null;
	try {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		data = c.toString();
		    } 
		catch (Exception e)
			{
				e.printStackTrace();
			}
		return data;
	}
	
	//write data to excel file
	public static void setDataToExcel(String fileName,String sheetName,int rowIndex,int cellIndex,String data)
	{
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row r = sh.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//get data from properties file
	public static String getDataFromProperties(String fileName,String key)
		{
		String data = null;
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			data = prop.get(key).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	//set data to properties file
	public static void setDataToProperties(String fileName,String key,String value,String commentMsg)
	{
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos, commentMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
