package SeleniumQuestions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

public class chromeDevToolForHeaders {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.executeCdpCommand("Network.enable", new HashMap<>());

		// Add headers
		Map<String, Object> headers = new HashMap<>();
		headers.put("Authorization", "test123");
		headers.put("X-API-KEY", "RM");
		headers.put("X-API", "RM123");

		Map<String, Object> params = new HashMap<>();
		params.put("headers", headers);

		driver.executeCdpCommand("Network.setExtraHTTPHeaders", params);

		driver.get("https://www.marriott.com/default.mi");

		System.out.println(driver.getPageSource());
		

	}

}
