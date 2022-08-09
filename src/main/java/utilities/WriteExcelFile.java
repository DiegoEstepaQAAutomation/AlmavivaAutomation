package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {

	}

	//METODO PARA ESCRIBIR UN ARREGO DE DATOS EN EL EXCEL	
	@SuppressWarnings({ "unused", "resource" })
	public static void writeExcel(String filepath, String sheetName, String[] dataToStrings) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		XSSFRow row = newSheet.getRow(0);
		XSSFRow newRow = newSheet.createRow(rowCount + 1);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToStrings[i]);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close(); 
	}
	
	
	//METODO QUE PERMITE CREAR UN VALOR EN UNA CELDA ESPECIFICA
	@SuppressWarnings("resource")
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook netWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = netWorkbook.getSheet(sheetName);
		XSSFRow row = newSheet.getRow(rowNumber);//OBJETO FILA 
		XSSFCell firstCell = row.getCell(cellNumber-1);//FIRSTCELL VA HACER REFERENCIA A LAS PRIMERAS CELDAS DESDE DONDE VAMPS A LEER LOS TERMINIS PARA LAS BUSQUEDAS
		System.out.println("First cell value is: "+ firstCell.getStringCellValue());
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		System.out.println("nextCell value: "+ nextCell.getStringCellValue());
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		netWorkbook.write(outputStream);
		outputStream.close();		
	}
}
