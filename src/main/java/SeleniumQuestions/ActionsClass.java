package SeleniumQuestions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        
		Actions action = new Actions(driver);
		
		  action.clickAndHold(null)
				  .moveToElement(null)
				  .release(null)
				  .build()
				  .perform();
    
		  action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		  action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
	}

}
