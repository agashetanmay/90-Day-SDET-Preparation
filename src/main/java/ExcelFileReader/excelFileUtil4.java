package ExcelFileReader;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelFileUtil4 {
	private static final ThreadLocal<Map<String, Map<String, String>>> CACHE_TL = ThreadLocal.withInitial(HashMap::new);

	public static void preloadSheet(String sheetName) {
	    XSSFWorkbook workbook = (XSSFWorkbook) CACHE_TL.get();
	    Sheet sheet = workbook.getSheet(sheetName);
	    if (sheet == null) throw new IllegalArgumentException("Sheet not found: " + sheetName);

	    Row headerRow = sheet.getRow(0);
	    short lastCellNum = headerRow.getLastCellNum();

	    Map<String, Map<String, String>> sheetData = new HashMap<>();

	    for (int r = 1; r <= sheet.getLastRowNum(); r++) {
	        Row row = sheet.getRow(r);
	        if (row == null) continue;

	        String testCaseId = getCellValue(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
	        if (testCaseId.isEmpty()) continue;

	        Map<String, String> dataMap = new LinkedHashMap<>();
	        for (int c = 1; c < lastCellNum; c++) {
	            String key = getCellValue(headerRow.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
	            if (key.isEmpty()) continue;
	            String value = getCellValue(row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
	            dataMap.put(key, value);
	        }
	        sheetData.put(testCaseId.trim().toLowerCase(Locale.ROOT), Collections.unmodifiableMap(dataMap));
	    }

	    CACHE_TL.get().put(sheetName, sheetData);
	}

	public static Map<String, String> getTestData(String sheetName, String testCaseId) {
	    Map<String, Map<String, String>> sheetData = CACHE_TL.get().get(sheetName);
	    if (sheetData == null) {
	        preloadSheet(sheetName);
	        sheetData = CACHE_TL.get().get(sheetName);
	    }
	    return sheetData.getOrDefault(testCaseId.trim().toLowerCase(Locale.ROOT), Collections.emptyMap());
	}


}
