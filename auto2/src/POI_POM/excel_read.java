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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test
public class excel_read {
	public void dataReadTest() throws Exception{
		
		File src= new File("C:\\Users\\viend\\Downloads\\testdata.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook xsf= new XSSFWorkbook(fis);
		
		//for .xlsx files
		XSSFSheet sheet= xsf.getSheetAt(0);
		String cell_val= sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cell_val);
		
		xsf.close();
		fis.close();
	}
}
