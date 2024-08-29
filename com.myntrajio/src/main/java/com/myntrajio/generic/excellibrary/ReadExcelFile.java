package com.myntrajio.generic.excellibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.myntrajio.generic.commonlibrary.FrameworkConstant;

public class ReadExcelFile implements FrameworkConstant {
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public Workbook wb = null;

	public String readData(String sheet, int row, int column) {
		// Convert physical file into java understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Create the WorkBook
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		// Fetch the data
		String data = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		
		// Print on the console
		System.out.println(data);
		
		// Close the WorkBook
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Print on the console
		System.out.println(data);
		return data;

	}

	public void writeData(int column, int row, String sheet, int data) {
		// Step 1: Convert physical file to java readable object By using
		// FileInputStream Class
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Step 2: Open the workbook BY Creating WB-Factory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// To Write the Data
		wb.getSheet(sheet).createRow(row).createCell(column).setCellValue(data);

		// convert data From Java type to Physical File
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Write the Excel
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Close the workbook
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Step 5 ::
		System.out.println("Exceution Completed");

	}

	public void displayData(String sheet, int column,int row) {
		// Convert physical file into java understandable
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Create the WorkBook
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		// Fetch the data
		String data = wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		// Close the WorkBook
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Print on the console
		System.out.println(data);

	}

	public void readMultipleData(int column, String sheet) {
		// Step 1: Convert physical file to java readable object By using
		// FileInputStream Class
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Step 2: Open the workbook BY Creating WB-Factory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// How To Fetch Multiple Data

		// Fetch The Last Row Count
		int count = wb.getSheet(sheet).getLastRowNum();

		// Fetch data of one Students Details --->
		for (int i = 0; i < 5; i++) {
			String data = wb.getSheet(sheet).getRow(i).getCell(column).getStringCellValue();
			System.out.println(data);
		}

		// Close the workbook
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
