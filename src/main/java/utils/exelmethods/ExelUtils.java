package utils.exelmethods;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExelUtils {
    public static void main(String[] args) throws IOException {
        setCellData();
    }

    public static void getRowCount() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/main/java/utils/exelmethods/test.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);
    }

    public static void getCellData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/main/java/utils/exelmethods/test.xlsx");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        String data = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println(data);
    }

    public static void setCellData() throws IOException {
        Date date = new Date();
        Format formatter = new SimpleDateFormat("YYYY-MM-dd_hh-mm-ss");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet " + formatter.format(date));
        for (int i=1; i<10; i++) {
            sheet.createRow(i);
            sheet.getRow(i).createCell(0).setCellValue(i);
        }
        workbook.write(new FileOutputStream("src/main/java/utils/exelmethods/test.xlsx"));
    }

}
