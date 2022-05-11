package testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/main/resources/code.xls");

		FileInputStream fileInputStream = new FileInputStream(file);

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

		HSSFSheet sheet = workbook.getSheet("code");

		int lastRowNum = sheet.getLastRowNum();

		for (int i = 0; i <= lastRowNum; i++) {

			int lastCellNum = sheet.getRow(i).getLastCellNum();

			HSSFRow currentRow = sheet.getRow(i);

			for (int j = 0; j < lastCellNum; j++) {

				System.out.println(currentRow.getCell(j) + " : " + "\t");
				// System.out.println();
			}
		}
		workbook.close();

	}

}
