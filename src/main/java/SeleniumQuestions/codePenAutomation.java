package SeleniumQuestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class codePenAutomation {

	public static void main(String[] args) {
		
		 ChromeOptions options = new ChromeOptions();
	       options.addArguments("--start-maximized");
			WebDriver wd = new ChromeDriver(options);
			WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(20));
		      
			wd.get("https://codepen.io/rolandixor/pen/mdwZReq");
			
		   By codeTextArea = By.xpath("//div[@class='code-wrap notranslate']/div/div/textarea");
		   
		 List<WebElement> 
		 codeTextAreaList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(codeTextArea));
		 
		 WebElement cssCodeTextArea =  codeTextAreaList.get(1);
		 
//		WebElement cssTextArea =  driver.findElement(By.tagName("fintextarea"));
		
//		cssTextArea.sendKeys("abc");
		 
		Actions action = new Actions(wd);
		action.click(cssCodeTextArea);
		action.perform();
		cssCodeTextArea.sendKeys("hello tanmay");
		
		   
	}

}
