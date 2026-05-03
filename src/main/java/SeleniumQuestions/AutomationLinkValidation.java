package SeleniumQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationLinkValidation {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
	List<WebElement> links =driver.findElements(By.xpath("//div[@id='content']/ul/li/a"));
	
	  int size = links.size();
	  
	  for(int i=0;i<size;i++) {
		  
		  if(i==4 && links.get(i).getAttribute("href").contains("challenging_dom")) {
			  
			  links.get(i).click(); 
		  }
	  }
	  
	}

}
