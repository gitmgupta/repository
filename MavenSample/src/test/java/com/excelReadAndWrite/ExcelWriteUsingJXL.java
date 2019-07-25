package com.excelReadAndWrite;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.Number;

public class ExcelWriteUsingJXL extends ExcelReadUsingJXL {

	static String NEW_EXCEL_PATH = "C:\\workspace\\maven.sample\\ExcelJXLCopy.xls";
	static Workbook workbbook = null;
	static WritableWorkbook writeWorkbook = null;
	static WritableSheet writeSheet = null;
	static Label label = null;
	static Number number = null;
	static ExcelWriteUsingJXL excelWriteUsingJXL = null;
	static ExcelReadUsingJXL excelReadUsingJXL = null;

	public ExcelWriteUsingJXL() throws IOException {
		workbbook = getWorkBook();
		writeWorkbook = Workbook.createWorkbook(new File(NEW_EXCEL_PATH), workbbook);
	}

	public static void writeToExcel() throws RowsExceededException, WriteException {

		final String EXCEL_FILE_LOCATION = "C:\\workspace\\maven.sample\\MyFirstExcel.xls";

		// 1. Create an Excel file
		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Manish0", 0);
			myFirstWbook.createSheet("Manish1", 1);
			myFirstWbook.createSheet("Manish2", 2);
			myFirstWbook.createSheet("Manish3", 3);
			myFirstWbook.createSheet("MiddleSheet", 4);

			// add something into the Excel sheet
			Label label = new Label(0, 0, "Test Count");
			Label label1 = new Label(1, 0, "TestCount");
			excelSheet.addCell(label);
			excelSheet.addCell(label1);

			Number number = new Number(0, 1, 1);
			excelSheet.addCell(number);

			label = new Label(1, 0, "Result");
			excelSheet.addCell(label);

			label = new Label(1, 1, "Passed");
			excelSheet.addCell(label);

			number = new Number(0, 2, 2);
			excelSheet.addCell(number);

			label = new Label(1, 2, "Passed 2");
			excelSheet.addCell(label);

			myFirstWbook.write();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public int getRowIndexs(String sheetName, String rowName) {
		int row_index = getRowIndex(sheetName, rowName);
		if (row_index == -1) {
			return writeWorkbook.getSheet(sheetName).getRows();
		}
		return row_index;
	}

	public static void writeToSpecificCell(String sheetName, String columnName, String rowName, String value)
			throws IOException, RowsExceededException, WriteException {
		excelWriteUsingJXL = new ExcelWriteUsingJXL();
		excelReadUsingJXL = new ExcelReadUsingJXL();
		int column_index = getColumnIndex(sheetName, columnName);
		System.out.println("Column Index is: " + column_index);
		int row_index = excelWriteUsingJXL.getRowIndexs(sheetName, rowName);
		System.out.println("Row Index is: " + row_index);
		writeSheet = writeWorkbook.getSheet(sheetName);

		if (getRowIndex(sheetName, rowName) == -1) {
			label = new Label(column_index, row_index, value);
			label = new Label(column_index, row_index, value);
			writeSheet.addCell(label);
		} else {
			label = new Label(column_index, row_index, value);
			writeSheet.addCell(label);
		}

		writeWorkbook.write();
		writeWorkbook.close();

	}

	public static void main(String[] args) throws RowsExceededException, WriteException, IOException {
		writeToSpecificCell("Package", "SalaryPerMonth", "Manish", "55000");
	}
}
