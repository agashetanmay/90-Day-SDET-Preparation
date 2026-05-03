package ExcelFileReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelUtil {

    private static final String FILE_PATH = "src/test/resources/testdata.xlsx";

    public static Map<String, String> getTestData(String sheetName, String testCaseId) {

        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);
            int colCount = headerRow.getLastCellNum();

            Iterator<Row> rows = sheet.iterator();

            rows.next(); // skip header

            while (rows.hasNext()) {
                Row row = rows.next();

                Cell testCaseCell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                String currentTC = getCellValue(testCaseCell);

                if (currentTC.equalsIgnoreCase(testCaseId)) {

                    for (int i = 0; i < colCount; i++) {

                        String key = getCellValue(headerRow.getCell(i));

                        Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                        String value = getCellValue(cell);

                        dataMap.put(key, value);
                    }
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }

    private static String getCellValue(Cell cell) {

        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {

            case STRING:
                return cell.getStringCellValue().trim();

            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            case BLANK:
                return "";

            default:
                return "";
        }
    }
}