package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilityFile {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path;
	
	public XLUtilityFile(String path) {
		
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		fi=new FileInputStream(path);
		workBook=new XSSFWorkbook(fi);
		
		sheet=workBook.getSheet(sheetName);
		
		int rowCount=sheet.getLastRowNum();
		workBook.close();
		fi.close();
		
		return rowCount;
		
	}
	
	public int getColoumnCount(String sheetName, int rowNum) throws IOException {
		
		fi=new FileInputStream(path);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(sheetName);
		
		row=sheet.getRow(rowNum);
		
		int coloumnCount=row.getLastCellNum();
		
		workBook.close();
		fi.close();
		
		return coloumnCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int coloumnNum) throws IOException {
		
		fi=new FileInputStream(path);
		workBook=new XSSFWorkbook(fi);
		sheet=workBook.getSheet(sheetName);
		
		row=sheet.getRow(rowNum);
		
		cell= row.getCell(coloumnNum);
		
		DataFormatter formatter=new DataFormatter();
		
		String data;
		try {
			data=formatter.formatCellValue(cell);
			
			
		}catch(Exception e) {
			data="";
			
		}
		
		workBook.close();
		fi.close();
		return data;
		
	}
	
	

}
