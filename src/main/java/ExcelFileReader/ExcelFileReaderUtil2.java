package ExcelFileReader;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;


import java.io.InputStream;
import java.util.*;

public final class ExcelFileReaderUtil2 {

    // Put testdata.xlsx under: src/test/resources/
    private static final String RESOURCE_NAME = "testdata.xlsx";

    // DataFormatter preserves what you SEE in Excel (leading zeros, decimals, formatted dates, etc.)
    private static final DataFormatter FORMATTER = new DataFormatter(Locale.US);

    // ThreadLocal workbook for parallel tests (each thread gets its own workbook instance)
    private static final ThreadLocal<XSSFWorkbook> WORKBOOK_TL = ThreadLocal.withInitial(() -> {
        try (InputStream is = ExcelFileReaderUtil2.class.getClassLoader().getResourceAsStream(RESOURCE_NAME)) {
            if (is == null) {
                throw new IllegalStateException("Excel file not found in classpath: " + RESOURCE_NAME);
            }
            return new XSSFWorkbook(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load workbook: " + RESOURCE_NAME, e);
        }
    });

    private ExcelFileReaderUtil2() {
        // utility class
    }

    /**
     * Reads test data from a sheet where:
     * - Row 0 is header (keys)
     * - Column 0 is TestCaseId
     * - Columns 1..N are key/value data
     *
     * @param sheetName  excel sheet name
     * @param testCaseId testcase id to match (string compare, case-insensitive)
     * @return unmodifiable map of header->cellValue for the matched row, empty map if not found
     */
    public static Map<String, String> getTestData(String sheetName, String testCaseId) {
        Objects.requireNonNull(sheetName, "sheetName must not be null");
        Objects.requireNonNull(testCaseId, "testCaseId must not be null");

        XSSFWorkbook workbook = WORKBOOK_TL.get();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet not found: " + sheetName);
        }

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new IllegalStateException("Header row (row 0) missing in sheet: " + sheetName);
        }

        short lastCellNum = headerRow.getLastCellNum();
        if (lastCellNum <= 1) {
            return Collections.emptyMap();
        }

        // concurrentHashMap is thread safe
        Map<String, String> dataMap = new ConcurrentHashMap<>();

        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            // Pick TestCaseId from column 0 of the CURRENT row
            Cell tcCell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String currentTC = getCellValue(tcCell);

            if (currentTC.equalsIgnoreCase(testCaseId.trim())) {
                // Build key/value pairs from columns 1..lastCellNum-1
                for (int c = 1; c < lastCellNum; c++) {
                    Cell headerCell = headerRow.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String key = getCellValue(headerCell);

                    if (key.isEmpty()) continue; // skip blank header columns safely

                    Cell valueCell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = getCellValue(valueCell);

                    dataMap.put(key, value);
                }
                return Collections.unmodifiableMap(dataMap);
                
            }
        }

        return Collections.unmodifiableMap(Collections.emptyMap());
    }

    /**
     * Returns the displayed cell text as seen in Excel:
     * - preserves leading zeros via DataFormatter
     * - preserves decimals (as displayed)
     * - handles formula results (as displayed)
     * - handles dates (as displayed; can be customized)
     */
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        CellType type = cell.getCellType();
        if (type == CellType.FORMULA) {
            // Return evaluated/display value, not the formula text
            return FORMATTER.formatCellValue(cell).trim();
        }

        if (type == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            // If you want an ISO date instead of Excel display format, replace with:
            // return cell.getLocalDateTimeCellValue().toString();
            return FORMATTER.formatCellValue(cell).trim();
        }
          
        return FORMATTER.formatCellValue(cell).trim();
    }

    /**
     * Must be called at the end of a test thread (e.g., @AfterMethod) to avoid leaks.
     */
    public static void clearThreadLocal() {
        XSSFWorkbook wb = WORKBOOK_TL.get();
        try {
            if (wb != null) wb.close();
        } catch (Exception ignored) {
            // no-op
        } finally {
            WORKBOOK_TL.remove();
        }
    }
}