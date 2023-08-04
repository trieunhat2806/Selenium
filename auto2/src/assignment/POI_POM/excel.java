package POI_POM;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	public void writeExcel(String filePath, String fileName,String sheetName, String[] dataToWrite)
	throws IOException {
		File file= new File(filePath+"\\"+fileName);
		
		//create an object of FileInputStream
		FileInputStream inputStream = new FileInputStream(file);
			Workbook ExcelReader = null;
			
			//find the file extension by splitting file name
			 String fileExtensionName= fileName.substring(fileName.indexOf("."));
			 
			 if(fileExtensionName.equals(".xlsx")) {
				 ExcelReader= new XSSFWorkbook(inputStream); 
			 }
			 else if(fileExtensionName.equals(".xls")) {
				 ExcelReader=new HSSFWorkbook(inputStream);
			 }
		//read sheet by sheet
			 Sheet sheet= ExcelReader.getSheet(sheetName);
			 
			 int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		//get first row from the sheet
			 Row row= sheet.getRow(0);
		//create new row and append it at last of sheet
			 Row newRow=sheet.createRow(rowCount+1);
		//loop over the cell of new row
			 for(int i=0; i < row.getLastCellNum(); i++) {
				 //fill data in row
				 Cell cell=newRow.createCell(i);
				 cell.setCellValue(dataToWrite[i]);
		//close input stream
				 inputStream.close();
		//create an object of FileOutputStream class to create data in excel
				 FileOutputStream outputStream=new FileOutputStream(file);
		//write data 
				 ExcelReader.write(outputStream);
		//close
				 outputStream.close();
			 }
		}
	
	public static void main(String...strings) throws IOException{
	//create array with the data 
		String[] valueToWrite= {"John", "Smith"};
	// create an obj of current class
		excel objExcelFile= new excel();
	//write the file using file name, sheet name and the data to be filled
		objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\POI_POM","testdata.xlsx","data1",valueToWrite);
	}
	
}
