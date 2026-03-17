package SeleniumQuestions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wndowHandelProgramme {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		
		WebElement newTab = driver.findElement(By.xpath("//div[contains(@class, 'col-md-8 col-lg-8 col-xl-8')]/button[contains(text(),'New Tab')]"));
    
		   
		newTab.click();
		
		String ParentWindowHandle = driver.getWindowHandle();
		
		for(String window : driver.getWindowHandles()) {
			
			if(!(window.equals(ParentWindowHandle))) {
	
				driver.switchTo().window(window);
			}
			System.out.println(driver.getTitle());
		}
	}

}
