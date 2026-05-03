package SeleniumQuestions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findTheLinkOnThePage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ultimateqa.com/dummy-automation-websites/#2_Ultimate_QA_HTML_Elements");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		
		for(int i=0;i<links.size()-1;i++) {
			
			  
			
		String link = links.get(i).getAttribute("href");
		
	System.out.println(link);
			
		
		}
		

	}

}
