package SeleniumQuestions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinkcoding {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.softwaretestinghelp.com/");
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		
		for(WebElement link:links) {
			
			String urlString =   link.getAttribute("href");
			
			URL url = new URL(urlString);
			
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			
			connection.setRequestMethod("GET");
			
			connection.connect();
			
			int statusCode = connection.getResponseCode();
			
			if(statusCode >= 400) {
				
				System.out.println("broken Link: "+urlString );
				
			}
			else {
				System.out.println("valid link: "+urlString);
			}
			connection.disconnect();
			
		}
		driver.quit();
		


	}

}
