package QAMavenProject.MavenJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataAccess {
	
	public static void main(String[] args){
		
		
		
	}//main
	
	
	
	public ArrayList<String> getData(String worksheetName , String columnName , String testcaseName) throws IOException{
		
		ArrayList<String> cellValuesList = new ArrayList<String>();
		
		String path = System.getProperty("user.home") + "/eclipse-workspace/MavenJava/demoData.xlsx";
		
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//get the count of worksheets available
		int sheets = workbook.getNumberOfSheets();
		
		for(int i = 0 ; i < sheets ; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase(worksheetName)) {
				
				XSSFSheet sheetpage = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheetpage.rowIterator();
				Row firstRow = rows.next();
				
				Iterator<Cell> cell = firstRow.cellIterator();
				
				int counter = 0;
				int columnNumber = 0;
				
				while(cell.hasNext()) {
					
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase(columnName)) {
						
						columnNumber = counter;
						
					}//if
					
					counter++;
					
				}//while
				
				while(rows.hasNext()) {
					
					Row r = rows.next();
					if(r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						
						Iterator<Cell> cellValue = r.cellIterator();
						while(cellValue.hasNext()) {
							
							//System.out.println(cellValue.next().getStringCellValue());
							
							Cell c = cellValue.next();
							if(c.getCellType() == CellType.STRING) {
								
								cellValuesList.add(c.getStringCellValue());
								
							}//if
							else {
								
								cellValuesList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}//else
							
							
						}//while
						
					}//if
					
				}//while
				
				
			}//if
			
		}//for
		
		
		return cellValuesList;
		
	}

}//class
