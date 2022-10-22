package week4;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputFile = "./data/TC001.xlsx";
		System.out.println(inputFile);
		FileInputStream fis = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rowCount=sheet.getLastRowNum();
		
		System.out.println(rowCount);
		workbook.close();
		
	}

}
