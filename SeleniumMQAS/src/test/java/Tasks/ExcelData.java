package Tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExcelData {

	@Test
	public void fetchdata() throws IOException
	{
		File file = new File("./Data/Parekh Integrated _ Test Scenarios for WMS  (4).xlsx");
		String filepath = file.getAbsolutePath();
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Random random = new Random();
		// Generate a random number between 1 and 10
		int randomNumber = random.nextInt(10);


		String username = sheet.getRow(randomNumber).getCell(0).toString();
		String pwd = sheet.getRow(randomNumber).getCell(1).toString();
		Reporter.log(username,true);
		Reporter.log(pwd,true);

		//System.out.print(sheet.getRow(i).getCell(j).toString()+" ");



	}
}
