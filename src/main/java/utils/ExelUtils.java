package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExelUtils {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    public ExelUtils (String exelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(exelPath);
        sheet = workbook.getSheet(sheetName);
    }

    public Object getData (int row, int cell) throws IOException {
        String exelPath = "./src/main/resources/schemesfortests/ExelTest.xlsx";
        workbook = new XSSFWorkbook(exelPath);
        sheet = workbook.getSheet("Sheet1");
        DataFormatter formatte = new DataFormatter();
        Object value = formatte.formatCellValue(sheet.getRow(row).getCell(cell));
        return value;
    }

    public void  getRowCount () throws IOException {
        String exelPath = "./src/main/resources/schemesfortests/ExelTest.xlsx";
        workbook = new XSSFWorkbook(exelPath);
        sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();
    }
}
