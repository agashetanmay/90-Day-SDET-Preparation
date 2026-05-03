package SeleniumQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptexecutorForSendKeys {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement textBox = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='submit-btn']"));
		
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		js.executeScript("arguments[0].value='tanmay';", textBox);    
		
		js.executeScript("arguments[0].scrollIntoView();",submitButton );
		
		js.executeScript("arguments[0].click();",submitButton );
		
	}

}
