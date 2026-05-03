package SeleniumQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReverseDropDownList {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("country")).click();
		
       List<WebElement> dropDownValue= driver.findElements(By.xpath("//div[@class='form-group']/select[@id='country']/option"));
       
      int size = dropDownValue.size();
      
      for(int i=size-1;i>=0;i--) {
    	    
    	  String value =dropDownValue.get(i).getText();
    	  
    	  if(value.contains("China")) {
    		 
    		  dropDownValue.get(i).click();
    		  
    		  
    	  }
    	  
//    	  System.out.println(value);
      }
	}

}
