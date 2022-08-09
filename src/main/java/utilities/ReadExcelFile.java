package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {

	}

	// METODO DE LECTURA DE ARCHIVO EXCEL
	@SuppressWarnings("resource")
	public static int countRow(String filepath, String sheetName) throws Exception {
	    File file = new File(filepath);
	    FileInputStream inputStream = new FileInputStream(file);
	    XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
	    XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
	    int rows = newSheet.getLastRowNum();
	    return rows;
	}
	
	//METODO PARA LEER TODA LA INFORMACIÓN DE UNA HOJA DE EXCEL
	@SuppressWarnings("resource")
	public void readExcel(String filepath, String sheetName) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		int rowCount = newSheet.getLastRowNum() + newSheet.getFirstRowNum();
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {  
			}
		}
	}

	//METODO PARA LEER EL VALOR ESPECIFICO DE UNA CELDA 
	@SuppressWarnings("resource")
	public String getCellValue(String filepath, String sheetName, int rowNumer, int cellNumber) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		XSSFRow row = newSheet.getRow(rowNumer);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.getStringCellValue();
	}
 
}
