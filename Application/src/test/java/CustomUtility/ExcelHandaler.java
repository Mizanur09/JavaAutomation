package CustomUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import HelpingPages.GlobalizedPage;

public class ExcelHandaler extends GlobalizedPage {
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 						DO NOT TOUCH THIS LIBRARY
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/

	XSSFWorkbook WorkBrrok;
	XSSFSheet Sheet;

	int ROW1 = 0;
	int ROW2 = 1;
	int ROW3 = 2;
	int COLUMN1 = 0;
	int SHEET1 = 0;
	String NAME_SHEET1 = "Sheet1";
	String NAME_SHEET2 = "TEST";
	String FolderPath = "ResourceFolder/ExcelDoc/TestData.xlsx";
	
	//#################################################################	Create Excel File // with if your computer have create Permission   
	
	public void CreateExcelFile(String FilePath, String FileGivenName, String CreateSheet) {
		try {
			FileOutputStream OutPut = new FileOutputStream(new File(FolderPath));
			Sheet = WorkBrrok.createSheet(FileGivenName + ".xlsx");
			Sheet.getRow(0).createCell(0).setCellValue(CreateSheet);
			WorkBrrok.write(OutPut);
			OutPut.close();
			lb.Print("You Have Just Cteated Excel File With A Name Of => ("+ FileGivenName +".xlsx)");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	
//#################################################################  Excel work Book Configuration 
	
	public void Excel_Configuration() {
		try {
			File FilePath = new File(ExcelFilePath);
			FileInputStream File = new FileInputStream(FilePath);
			WorkBrrok = new XSSFWorkbook(File);
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
	}
	
//#################################################################  Writing data to excel
	
	public void WriteWorkBookBySheetName(String SheetName, int RowNumber, int ColumnNumber, String Value) {
		try {
			Excel_Configuration();
			Sheet = WorkBrrok.getSheet(SheetName);
			Sheet.getRow(RowNumber).createCell(ColumnNumber).setCellValue(Value);
			
			FileOutputStream OutPut = new FileOutputStream(ExcelFilePath);
			WorkBrrok.write(OutPut);
			lb.Print("You Have Entered Data To Excel WorkBook Sheetname => "+ SheetName +") "
					+ "Row Number => " + RowNumber + ") "
							+ "Column Number => " + ColumnNumber + ") "
									+ "Inserted Value Is => " + Value + ")");
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void WriteWorkBookBySheetNumber(int SheetNumber, int RowNumber, int ColumnNumber, String Value) {
		try {
			Excel_Configuration();
			Sheet = WorkBrrok.getSheetAt(SheetNumber);
			Sheet.getRow(RowNumber).createCell(ColumnNumber).setCellValue(Value);
			
			FileOutputStream OutPut = new FileOutputStream(ExcelFilePath);
			WorkBrrok.write(OutPut);
			lb.Print("You Have Entered Data To Excel WorkBook SheetNumber => "+ SheetNumber +") "
					+ "Row Number => " + RowNumber + ") "
							+ "Column Number => " + ColumnNumber + ") "
									+ "Inserted Value Is => " + Value + ")");
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
	}
	
//################################################################# Read From Excel Row and Column

	public String GetFirstSheetValue(int RowNumber, int ColumnNumber) {
		String ExcelData = null;
		try {
			Excel_Configuration();
			Sheet = WorkBrrok.getSheetAt(0);
			ExcelData = Sheet.getRow(0).getCell(0).getStringCellValue();
			
			lb.Print("Data From SheetNumber => 0) RowNumber => " + RowNumber
					+ "} Value of the Column => " + ColumnNumber + "] Value is ===> " + ExcelData);
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
		return ExcelData;
	}

	public String GetValue_By_SheetNumber(int SheetNumber, int RowNumber, int ColumnNumber) {
		String ExcelData = null;
		try {
			Excel_Configuration();
			Sheet = WorkBrrok.getSheetAt(SheetNumber);
			ExcelData = Sheet.getRow(RowNumber).getCell(ColumnNumber).getStringCellValue();
			lb.Print("Data From SheetNumber => "+ SheetNumber+") RowNumber => " + RowNumber
					+ "} Value of the Column => " + ColumnNumber + "] Value is ===> " + ExcelData);
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
		return ExcelData;
	}

	public String GetValue_By_SheetName(String SheetName, int RowNumber, int ColumnNumber) {
		String ExcelData = null;
		try {
			Excel_Configuration();
			Sheet = WorkBrrok.getSheet(SheetName);

			ExcelData = Sheet.getRow(RowNumber).getCell(ColumnNumber).getStringCellValue();
			lb.Print("Data From SheetName => "+ SheetName+") RowNumber => " + RowNumber
					+ "} Value of the Column => " + ColumnNumber + "] Value is ===> " + ExcelData);
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
		return ExcelData;
	}

	public void PrintValue_EachRow_BySheetNumber(int SheetNumber, int ColumnNmber) {
		try {
			lb.Print("NOTE: Loop count start from 0 which actualy 1 in excel");
			Excel_Configuration();
			Sheet = WorkBrrok.getSheetAt(SheetNumber);

			int RowCount = Sheet.getLastRowNum();
			for (int i = 0; i < RowCount; i++) {
				String data = Sheet.getRow(i).getCell(ColumnNmber).getStringCellValue();
				lb.Print("Data From SheetNumber => " + SheetNumber + ") RowNumber => " + i
						+ "} Value of the Column => " + ColumnNmber + "] Value is ===> " + data);
			}
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
	}

	public void PrintValue_EachRow_BySheetName(String SheetName, int ColumnNmber) {
		try {
			lb.Print("NOTE: Loop count start from 0 which actualy 1 in excel");
			Excel_Configuration();
			Sheet = WorkBrrok.getSheet(SheetName);

			int RowCount = Sheet.getLastRowNum();
			for (int i = 0; i < RowCount; i++) {
				String data = Sheet.getRow(i).getCell(ColumnNmber).getStringCellValue();
				lb.Print("Data From SheetName => " + SheetName + ") RowNumber => " + i
						+ "} Value of the Column => " + ColumnNmber + "] Value is ===> " + data);
			}
			WorkBrrok.close();
		} catch (Exception e) {
			lb.Print(e.getMessage());
			e.getStackTrace();
		}
	}

	@Test public void test()
	{
		PrintValue_EachRow_BySheetName("Sheet1",1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
