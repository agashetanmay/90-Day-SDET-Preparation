package SeleniumQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handelingDropDownUsingJsExecutor {

	public static void main(String[] args) {

WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("country")).click();
		
      WebElement dropDownValue = driver.findElement(By.xpath("//div[@class='form-group']/select[@id='country']/option[contains(text(),'Canada')]"));
      
       JavascriptExecutor js = (JavascriptExecutor)driver;
       
       js.executeScript("arguments[0].scrollIntoView", dropDownValue);
       
       dropDownValue.click();
    		  
	}

}
