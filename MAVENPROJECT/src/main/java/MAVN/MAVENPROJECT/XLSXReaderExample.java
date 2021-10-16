package MAVN.MAVENPROJECT;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// download and update JARs in java build path - https://poi.apache.org/download.html

// https://www.javatpoint.com/how-to-read-excel-file-in-java
// https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/CellType.html
// https://stackoverflow.com/questions/39993683/alternative-to-deprecated-getcelltype

// https://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file
// for function to read excel 



public class XLSXReaderExample {
	
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\Lenovo\\Desktop\\mavenexcel.xlsx"); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file  

			//File (Excel file) - -FInputStream --- XSSFWorkbook  (wb) --- XSSFSheet (sheet) --- Row -- Cell
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			
			// wb.getSheet("Sheet1"); // This is also ok - giving sheet name 

			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			//wb.getshe

			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			//sheet.itera
			//sheet.
			while (itr.hasNext()) {
				Row row = itr.next();

				//row.cell
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case STRING:
						
						// field that represents string cell type
						System.out.print(cell.getStringCellValue() + " | | ");
						//str=cell.getStringCellValue();
						//fw.write(str)
						
						break;
					case NUMERIC: // field that represents number cell type
						System.out.print(cell.getNumericCellValue() + " | | ");
						// 
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + " | | ");
					default:
					}
				}
				System.out.println("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}