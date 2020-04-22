package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class FileOperations {

	/**
	 * @param filePath
	 * @param key
	 * @return
	 */
	public String getValueFromPropertyFile(String filePath, String key) {
		String keyValue = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(filePath));
			keyValue = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return keyValue;
	}

	/**
	 * @param filePath
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	public void updateValueToPropertyFile(String filePath, String key, String value) throws IOException {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(filePath);
		FileOutputStream out = new FileOutputStream(filePath);
		props.load(in);
		in.close();
		props.setProperty(key, value);
		props.store(out, "");
		out.close();
	}

	/**
	 * @param excelSheetFilePath
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public String[][] getDataFromExcelSheet(String excelSheetFilePath, String sheetName) throws IOException {
		String allExcelData[][] = null;
		File file = new File(excelSheetFilePath);
		Workbook wb = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Excel file is not available at " + excelSheetFilePath);
		}
		String fileExtenstion = excelSheetFilePath.substring(excelSheetFilePath.indexOf("."));
		if (fileExtenstion.equals(".xlsx")) {
			wb = new XSSFWorkbook(fis);
		} else if (fileExtenstion.equals(".xls")) {
			wb = new HSSFWorkbook(fis);
		}
		Sheet mySheet = wb.getSheet(sheetName);
		int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		for (int i = 0; i <= rowCount; i++) {
			allExcelData[i] = new String[mySheet.getRow(i).getLastCellNum()];
			for (int j = 0; j < mySheet.getRow(i).getLastCellNum(); j++) {
				allExcelData[i][j] = mySheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return allExcelData;
	}

}
