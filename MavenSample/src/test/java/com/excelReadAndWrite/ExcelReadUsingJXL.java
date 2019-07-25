package com.excelReadAndWrite;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReadUsingJXL {
	static Workbook workbook = null;
	static String EXCEL_PATH = "C:\\workspace\\maven.sample\\ExcelJXL.xls";

	/*
	 * - To solve this exception make sure that file is save as .xls, not .xlsx or
	 * nor renamed. Exception in thread "main" jxl.read.biff.BiffException: Unable
	 * to recognize OLE stream at
	 * jxl.read.biff.CompoundFile.<init>(CompoundFile.java:116) at
	 * jxl.read.biff.File.<init>(File.java:127) at
	 * jxl.Workbook.getWorkbook(Workbook.java:221) at
	 * jxl.Workbook.getWorkbook(Workbook.java:198) at
	 * com.excelReadAndWrite.ExcelReadUsingJXL.readExcelFile(ExcelReadUsingJXL.java:
	 * 14) at
	 * com.excelReadAndWrite.ExcelReadUsingJXL.main(ExcelReadUsingJXL.java:27)
	 */
	public static Workbook getWorkBook() {
		try {
			return Workbook.getWorkbook(new File(EXCEL_PATH));
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int getSheetIndex(String SheetName) {
		workbook = getWorkBook();
		String[] listOfSheet = workbook.getSheetNames();
		for (int i = 0; i < listOfSheet.length; i++) {
			if (listOfSheet[i].equalsIgnoreCase(SheetName)) {
				return i;
			}
		}
		return -1;
	}

	public static int getColumnIndex(String SheetName, String ColumnName) {

		workbook = getWorkBook();
		Sheet sheet = workbook.getSheet(SheetName);
		for (int i = 0; i < sheet.getColumns(); i++) {
			String cellValue = sheet.getCell(i, 0).getContents();
			if (ColumnName.equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}

	public static int getRowIndex(String SheetName, String RowName) {

		workbook = getWorkBook();
		Sheet sheet = workbook.getSheet(SheetName);
		for (int i = 0; i < sheet.getRows(); i++) {
			String cellValue = sheet.getCell(0, i).getContents();
			if (RowName.equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;
	}

	public static void getCellValue(String sheetName, String columnName, String rowName)
			throws BiffException, IOException {
		ExcelReadUsingJXL excelReadUsingJXL = new ExcelReadUsingJXL();

		try {

			int sheet_index = getSheetIndex(sheetName);
			if (getSheetIndex(sheetName) == -1) {
				throw new MyException("SheetNotFoundException");
			}
			int column_index = getColumnIndex(sheetName, columnName);
			if (getColumnIndex(sheetName, columnName) == -1) {
				throw new MyException("ColumnNotFoundException");
			}
			int row_index = excelReadUsingJXL.getRowIndex(sheetName, rowName);
			if (excelReadUsingJXL.getRowIndex(sheetName, rowName) == -1) {
				throw new MyException("RowNotFoundException");
			}
			Sheet sheet = getWorkBook().getSheet(sheet_index);
			
			Cell cellValue = sheet.getCell(column_index, row_index);
			System.out.println(cellValue.getContents());
		} catch (MyException m) {
			System.out.println("Exception occured: " + m);
			// e.getMessage();
		}

	}

//	public static void main(String[] args) throws BiffException, IOException {
//
//		getCellValue("Package", "SalaryPerMonth", "Rakesh");
//
//	}
}
