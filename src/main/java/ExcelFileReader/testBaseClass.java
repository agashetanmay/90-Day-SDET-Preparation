package ExcelFileReader;

import java.util.Map;

public class testBaseClass {
	
	public class TestBase {

	    // Shared test data map for each scenario
	    protected Map<String, String> testData;

	    @Before
	    public void setUp(Scenario scenario) {
	        // Extract testCaseId from tags
	        String testCaseId = scenario.getSourceTagNames().stream()
	                .filter(tag -> tag.startsWith("@TC"))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("No TC tag found"))
	                .replace("@", "");

	        String SheetName;
			// Load Excel data
	        testData =  ExcelFileReaderUtil2.getTestData("LoginData",testCaseId);
	    }

	    @After
	    public void tearDown() {
	        // Clear ThreadLocal to avoid leaks
	    	ExcelFileReaderUtil2.clearThreadLocal();
	    }
	}

}
